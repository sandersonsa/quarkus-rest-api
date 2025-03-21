package xyz.sandersonsa;

import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Optional<String> podName = Optional.ofNullable(System.getenv("HOSTNAME"));
        if (podName.isPresent()) {
            System.out.println("Pod Hostname: " + podName.get());
            return "Hello from Quarkus REST :: " + podName.get();
        }        
        return "Hello from Quarkus REST";
    }
}
