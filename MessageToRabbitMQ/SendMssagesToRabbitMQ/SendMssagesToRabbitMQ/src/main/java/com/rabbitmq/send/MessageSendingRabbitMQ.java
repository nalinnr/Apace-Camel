package com.rabbitmq.send;
import java.util.concurrent.TimeoutException;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MessageSendingRabbitMQ {

	public static void main(String[] args) throws Exception, TimeoutException {
		

        Maker queueProd = new Maker();
        queueProd.setupConnection();
        System.out.println(queueProd.toString());

        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {

            public void configure() throws Exception {
               
                from("file:D:\\Rabbitmq")
                .to("rabbitmq://192.168.99.100:15672/MyExchange?routingKey=Firstkey&queue=FirstQueue");

            }
        });

        context.start();
        Thread.sleep(4000);
        context.stop();
	}
}

