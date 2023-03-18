package com.greensheart.pmds;

public interface AgentSender {
    void send(Message message, AgentReceiver recipient);
}