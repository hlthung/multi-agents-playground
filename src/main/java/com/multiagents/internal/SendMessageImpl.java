package com.multiagents.internal;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;


public class SendMessageImpl implements Sender, MessageListener {
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer producer;
    private Receiver receiver;

    public SendMessageImpl(Receiver receiver) {
        this.receiver = receiver;

        // Set up the JMS connection and session
        try {
            ActiveMQConnectionFactory factory =  new ActiveMQConnectionFactory("tcp://localhost:61616");
            factory.setTrustAllPackages(true);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Set up the JMS destination and producer
            destination = session.createQueue("AMIQueue");
            producer = session.createProducer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(Message message, Receiver receiver) {
        // Create a JMS message from the AgentMessage object
        try {
            ObjectMessage jmsMessage = session.createObjectMessage();
            jmsMessage.setObject(message);

            // Set up the JMS message listener
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(this);

            // Send the JMS message to the destination
            producer.send(jmsMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(javax.jms.Message message) {
        // Extract the Message object from the JMS message and pass it to the Receiver
        try {
            Message agentMessage = (Message) ((ObjectMessage) message).getObject();
            receiver.receive(agentMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}