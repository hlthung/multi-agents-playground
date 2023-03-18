package com.multiagents.pmds;

public interface Receiver {
    /**
     * Called when a message is received.
     *
     * @param message the received message.
     */
    void receive(Message message);
}