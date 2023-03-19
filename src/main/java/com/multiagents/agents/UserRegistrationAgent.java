package com.multiagents.agents;

import com.multiagents.internal.protocol.Factory;
import com.multiagents.internal.protocol.models.Message;
import com.multiagents.internal.protocol.models.Receiver;
import com.multiagents.internal.protocol.models.Sender;
import com.multiagents.agents.models.Agent;
import com.multiagents.pmds.models.User;

// Define the PatientRegistrationAgent class
public class UserRegistrationAgent extends Agent implements Receiver {
    private Sender sender;
    private DatabaseAgent databaseAgent;

    public UserRegistrationAgent(DatabaseAgent databaseAgent) {
        super(1, "PRA");
        this.getDetails();

        this.databaseAgent = databaseAgent;

        // Set up sender
        Factory factory = Factory.getInstance();
        sender = factory.sendTo(this);
    }

    public void registerPatient(User user) {
        // Create a message object and send it to Agent2
        Message message = new Message(user);
        sender.send(message, databaseAgent);
    }

    @Override
    public void receive(Message message) {
        // PatientRegistrationAgent doesn't need to receive any messages in this example
    }
}