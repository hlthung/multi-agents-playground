package com.multiagents.internal.protocol;

import com.multiagents.internal.protocol.models.Receiver;
import com.multiagents.internal.protocol.models.Sender;

/**
 * The Factory class is responsible for creating instances of AgentSender and AgentReceiver objects.
 * It is a singleton class, meaning that there can only be one instance of the class at any given time. 
 * The getInstance() method is used to obtain the singleton instance of the class.
 */
public class Factory {
    private static Factory instance;

    private Factory() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public Sender sendTo(Receiver receiver) {
        return new SendMessageImpl(receiver);
    }

    public RetrievedMessageImpl receivedMessageAt(Receiver receiver) {
        return new RetrievedMessageImpl(receiver);
    }
}