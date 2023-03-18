package com.multiagents.pmds;

// Define the Agent1 class
class Agent1 implements Receiver {
    private Sender sender;
    private Agent2 agent2;

    public Agent1(Agent2 agent2) {
        this.agent2 = agent2;

        // Set up the Agent sender
        Factory factory = Factory.getInstance();
        sender = factory.createSender(this);
    }

    public void registerPatient(String name, String id, String phone, String email) {
        Patient patient = new Patient(name, id, phone, email);

        // Create a message object and send it to Agent2
        Message message = new Message(patient);
        sender.send(message, agent2);
    }

    // Implementation of the AgentReceiver interface
    @Override
    public void receive(Message message) {
        // Agent1 doesn't need to receive any messages in this example
    }
}