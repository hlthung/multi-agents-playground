package com.multiagents.pmds.agents;

import com.multiagents.pmds.*;
import com.multiagents.pmds.models.Agent;
import com.multiagents.pmds.models.Patient;

// Define the PatientRegistrationAgent class
public class PatientRegistrationAgent extends Agent implements Receiver {
    private Sender sender;
    private DatabaseAgent databaseAgent;

    public PatientRegistrationAgent(DatabaseAgent databaseAgent) {
        super(1, "PRA");
        this.getDetails();

        this.databaseAgent = databaseAgent;

        // Set up sender
        Factory factory = Factory.getInstance();
        sender = factory.createSender(this);
    }

    public void registerPatient(String name, String id, String phone, String email) {
        Patient patient = new Patient(name, id, phone, email);

        // Create a message object and send it to Agent2
        Message message = new Message(patient);
        sender.send(message, databaseAgent);
    }

    @Override
    public void receive(Message message) {
        // PatientRegistrationAgent doesn't need to receive any messages in this example
    }
}