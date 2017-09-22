package cg.camel.com;
import org.apache.camel.builder.RouteBuilder;
public class SimpleRouteJava extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:C:/Camel?noop=true").to("file:C:/Camel1");
    }

}