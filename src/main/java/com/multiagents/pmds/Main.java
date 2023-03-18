package com.multiagents.pmds;


// Example usage
public class Main {
    public static void main(String[] args) {
        Agent2 agent2 = new Agent2();
        Agent1 agent1 = new Agent1(agent2);

        // Register a patient and send their information to Agent2
        agent1.registerPatient("John Doe", "123456", "555-1234", "john.doe@example.com");
    }
}