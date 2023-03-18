package com.multiagents.pmds;

// Define the Agent2 class
class Agent2 implements Receiver {
    // Set up the Agent receiver
    public Agent2() {
        Factory factory = Factory.getInstance();
        factory.createReceiver(this);
    }

    // Implementation of the AgentReceiver interface
    @Override
    public void receive(Message message) {
        // Extract the patient information from the message object
        Patient patient = (Patient) message.getData();

        // Do something with the patient information, such as add it to a database
        System.out.println("Received patient information for " + patient.getName());
    }
}