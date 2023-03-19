package com.multiagents.internal;

public interface Receiver {
    /**
     * Called when a message is received.
     *
     * @param message the received message.
     */
    void receive(Message message);
}