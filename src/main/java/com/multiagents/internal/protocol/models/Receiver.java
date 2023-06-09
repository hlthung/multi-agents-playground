package com.multiagents.internal.protocol.models;

import com.multiagents.internal.protocol.models.Message;

public interface Receiver {
    /**
     * Called when a message is received.
     *
     * @param message the received message.
     */
    void receive(Message message);
}