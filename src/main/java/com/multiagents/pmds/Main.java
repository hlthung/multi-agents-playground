package com.multiagents.pmds;


import com.multiagents.pmds.agents.DatabaseAgent;
import com.multiagents.pmds.agents.PatientRegistrationAgent;

// Example usage
public class Main {
    public static void main(String[] args) {
        DatabaseAgent databaseAgent = new DatabaseAgent();
        PatientRegistrationAgent patientRegistrationAgent = new PatientRegistrationAgent(databaseAgent);

        // Register a patient and send information from to Database Agent
        patientRegistrationAgent.registerPatient("James Doe", "123456", "555-1234", "john.doe@example.com");
    }
}