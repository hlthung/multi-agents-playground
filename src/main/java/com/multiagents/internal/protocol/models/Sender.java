package com.multiagents.internal.protocol.models;

import com.multiagents.internal.protocol.models.Message;
import com.multiagents.internal.protocol.models.Receiver;

public interface Sender {
    void send(Message message, Receiver recipient);
}