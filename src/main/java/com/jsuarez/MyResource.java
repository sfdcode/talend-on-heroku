package com.jsuarez;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 *
 * @author jsuarez
 */
@Path("myresource")
public class MyResource {

    private final static String QUEUE_NAME = "hello";

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {

        try{
            String uri = System.getenv("CLOUDAMQP_URL");
            if (uri == null) uri = "amqp://guest:guest@localhost";
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUri(uri);
            factory.setRequestedHeartbeat(30);
            factory.setConnectionTimeout(30);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello CloudAMQP!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());            
            System.out.println(" [x] Sent '" + message + "'");

            channel.close();
            connection.close();

        }catch(Exception e){
            System.err.println(e.getMessage());
        }

        return "Hello, Heroku!!!";
    }
}

