package com.multiagents.pmds;

public interface Sender {
    void send(Message message, Receiver recipient);
}