package camel.ext.com;
import org.apache.camel.builder.RouteBuilder;
public class SimpleRouteExtn extends RouteBuilder{

    @Override
    public void configure() throws Exception {
      /*  from("file:C:/extension?noop=true")
        .split(body())
        .choice()
        .when(body().contains("hi.xml"))
        .to("file:C:/xmlextension")
        .when(body().contains("hello.csv"))
        .to("file:C:/csvextension");*/
       
    	from("file:C:\\Extension?noop=true")
        .choice()
        .when()
        .simple("${file:ext} == 'xml'")
        .to("file:C:\\xmlextension")
        .when()
        .simple("${file:ext} == 'csv'")
        .to("file:C:\\csvextension")
        .otherwise()
         .to("file:D:\\outbox");
    }

}

