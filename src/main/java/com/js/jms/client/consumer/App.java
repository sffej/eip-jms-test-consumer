package com.js.jms.client.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public String getGreeting() {
        return "JMS Consumer App running...";
    }

    public static void main(String[] args) throws Exception {

        System.out.println(new App().getGreeting());

        Connection connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("EVENTS.Q");

        MessageConsumer receiver = session.createConsumer(queue);
        TextMessage msg = (TextMessage)receiver.receive();

        System.out.println("Message received >>> " + msg.getText() );
        connection.close();

    }
}
