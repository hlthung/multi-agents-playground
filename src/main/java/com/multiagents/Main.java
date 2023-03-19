package com.multiagents;


import com.multiagents.agents.DatabaseAgent;
import com.multiagents.agents.PatientRegistrationAgent;

// Example usage
public class Main {
    public static void main(String[] args) {
        DatabaseAgent databaseAgent = new DatabaseAgent();
        PatientRegistrationAgent patientRegistrationAgent = new PatientRegistrationAgent(databaseAgent);

        // Register a patient and send information from to Database Agent
        patientRegistrationAgent.registerPatient("James Doe", "123456", "555-1234", "john.doe@example.com");
    }
}