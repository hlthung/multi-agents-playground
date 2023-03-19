package com.multiagents.agents;

import com.multiagents.internal.protocol.Factory;
import com.multiagents.internal.protocol.models.Message;
import com.multiagents.agents.models.Agent;
import com.multiagents.pmds.models.User;
import com.multiagents.internal.protocol.models.Receiver;
import com.multiagents.pmds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Define the Detabase Agent class
@Component
public class DatabaseAgent extends Agent implements Receiver {

    @Autowired
    UserRepository userRepository;

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
        // Extract the user information from the message object
        User user = (User) message.getData();

//        // Save the user information to the database
        System.out.println("Received user information for " + user.getUsername());

        userRepository.save(user);
    }
}