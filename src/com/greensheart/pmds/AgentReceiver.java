package com.greensheart.pmds;

public interface AgentReceiver {
    /**
     * Called when a message is received.
     *
     * @param message the received message.
     */
    void receive(Message message);
}