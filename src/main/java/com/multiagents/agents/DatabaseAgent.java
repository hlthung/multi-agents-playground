package com.multiagents.agents;

import com.multiagents.internal.Factory;
import com.multiagents.internal.Message;
import com.multiagents.agents.models.Agent;
import com.multiagents.pmds.models.Patient;
import com.multiagents.internal.Receiver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Define the Detabase Agent class
public class DatabaseAgent extends Agent implements Receiver {

    // Set up the Agent receiver
    public DatabaseAgent() {
        super(0, "DTA");
        this.getDetails();

        Factory factory = Factory.getInstance();
        factory.receivedMessageAt(this);
    }

    // Implementation of the AgentReceiver interface
    @Override
    public void receive(Message message) {
        // Extract the patient information from the message object
        Patient patient = (Patient) message.getData();

        // Save the patient information to the database
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "newuser", "password");

            String query = "INSERT INTO patients (name, id, phone, email) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, patient.getName());
            pstmt.setString(2, patient.getId());
            pstmt.setString(3, patient.getPhone());
            pstmt.setString(4, patient.getEmail());

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Received patient information for " + patient.getName());
    }
}