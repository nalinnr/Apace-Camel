package com.example.com;

import java.util.concurrent.TimeoutException;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import org.springframework.boot.SpringApplication;
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
                System.out.println("hello world");
                from("file:D:\\inbox")
                        .process(new Processor() {
                            public void process(Exchange msg) throws Exception {
                                System.out.println(msg.getIn().getBody(
                                        String.class));

                            }

                        }).to("rabbitmq://localhost:5672/amq.direct?routingKey=hello");

            }
        });

        context.start();
        Thread.sleep(4000);
        context.stop();
	}
}
