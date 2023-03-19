package com.multiagents.internal;

public interface Sender {
    void send(Message message, Receiver recipient);
}