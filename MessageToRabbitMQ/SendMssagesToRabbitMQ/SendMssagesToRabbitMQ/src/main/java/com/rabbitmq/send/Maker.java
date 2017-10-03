package com.rabbitmq.send;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
public class Maker {
	 public static final String QUEUE_NAME = "FirstQueue";
	    public static Connection connection;

	    public void setupConnection() throws IOException, TimeoutException {
	        ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost("192.168.99.100");
	        factory.setUsername("guest");
	         factory.setPassword("guest");

	        connection = factory.newConnection();
	        Channel channel = connection.createChannel();
	        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	        channel.exchangeDeclare(QUEUE_NAME, "MyExchange");
	        channel.queueBind(QUEUE_NAME, "MyExchange", "Firstkey");
	    }
}



