package camel.ext.com;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;



import camel.ext.com.SimpleRouteExtn;


public class MainAppl {
	public static void main(String[] args) {
        SimpleRouteExtn routeBuilder = new SimpleRouteExtn();
        CamelContext ctx = new DefaultCamelContext();
        try {
            ctx.addRoutes(routeBuilder);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/*public class MainAppl {
public static void main(String[] args) throws Exception {
CamelContext context = new DefaultCamelContext();
context.addRoutes(new SimpleRouteExtn());
context.start();
Thread.sleep(30000);
context.stop();
}
}
*/