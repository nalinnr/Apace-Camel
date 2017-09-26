package com.rabbitmq.retrieve;

import java.util.concurrent.TimeoutException;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RetrieveMessageFromRabbitMqApplication {

	public static void main(String[] args) throws Exception, TimeoutException {
		

        Maker queueProd = new Maker();
        queueProd.setupConnection();
        System.out.println(queueProd.toString());

        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {

            public void configure() throws Exception {
                System.out.println("hello world");
                from("rabbitmq://localhost:5672/amq.direct?routingKey=hello")
                        .to("ftp://localhost:21");

            }
        });

        context.start();
        Thread.sleep(4000);
        context.stop();
	}
}

