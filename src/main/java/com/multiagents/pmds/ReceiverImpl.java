//package com.multiagents.pmds;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//import javax.jms.*;
//
//public class ReceiverImpl implements Receiver {
//
//    public ReceiverImpl(Receiver receiver) {
//
//        // Set up the JMS connection and session
//        try {
//            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//            connectionFactory.setTrustAllPackages(true);
//
//            Connection connection = connectionFactory.createConnection();
//            connection.start();
//
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            Destination destination = session.createQueue("AMIQueue");
//            MessageConsumer consumer = session.createConsumer(destination);
//            consumer.setMessageListener(message -> {
//                try {
//                    ObjectMessage objMsg = (ObjectMessage) message;
//                    Message agentMessage = (Message) objMsg.getObject();
//                    receiver.receive(agentMessage);
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            });
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//    }
//    }
//}
