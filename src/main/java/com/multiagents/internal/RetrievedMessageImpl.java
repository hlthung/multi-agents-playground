package com.multiagents.internal;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class RetrievedMessageImpl {

    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageConsumer consumer;

    public RetrievedMessageImpl(Receiver receiver) {

        // Set up the JMS connection and session
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            factory.setTrustAllPackages(true);

            connection = factory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("AMIQueue");
            consumer = session.createConsumer(destination);
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
