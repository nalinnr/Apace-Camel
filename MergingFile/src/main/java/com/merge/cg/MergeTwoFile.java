package com.merge.cg;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MergeTwoFile  extends RouteBuilder {

	 @Override
	    public void configure() throws Exception {
	     from("file:D:\\inbox?noop=true")
	  .convertBodyTo(String.class)
	  .aggregate(simple("${file:ext} == 'txt'"), new Strategy()) 
	  .completionTimeout(30000)
	  .completionSize(2)
	  .to("file:D:\\newinbox"); 
	   }

}
