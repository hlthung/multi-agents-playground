package com.multiagents.pmds;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

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

    public Sender createSender(Receiver receiver) {
        return new SenderImpl(receiver);
    }

    public void createReceiver(Receiver receiver) {
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connectionFactory.setTrustAllPackages(true);

            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("AMIQueue");
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(message -> {
                try {
                    ObjectMessage objMsg = (ObjectMessage) message;
                    Message agentMessage = (Message) objMsg.getObject();
                    receiver.receive(agentMessage);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}