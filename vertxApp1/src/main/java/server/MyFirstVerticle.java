package server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyFirstVerticle extends AbstractVerticle {

  /**
   * this is the server class for pet feeder 
   * Need - extend
   * author : jayamine
   */
   
   static String foodAvailable="ok";
   static String foodSupply="s";
   
   
  @Override
  public void start(Future<Void> fut) {
    vertx
        .createHttpServer() 
		
        .requestHandler(request -> {
		  System.out.println("New request!"+(request.uri()));
		  if((request.uri()).startsWith("/help"))
          request.response().end("<h1>Pet feeder help Page</h1><br>"+
								 "<h3>Check foods: IP/check<br>Supply foods:IP/supply</h3>");
		  if((request.uri()).equals("/"))
          request.response().end("<h1>Pet feeder Main Page</h1><br>"+
								 "<h3>foods: "+foodAvailable+"<br></h3>");
        })
		
        .listen(8080, result -> {
          if (result.succeeded()) {
			System.out.println("Server is now listening!");
            fut.complete();
          } else {
			System.out.println("Failed to bind!");
            fut.fail(result.cause());
          }
        });
		
  }

}
