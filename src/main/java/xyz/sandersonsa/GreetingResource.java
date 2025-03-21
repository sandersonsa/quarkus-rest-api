package xyz.sandersonsa;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String hello(@Context HttpHeaders httpHeaders) {
        
        // Retrieve all cookies from the header
        Map<String, Cookie> cookies = httpHeaders.getCookies();

        // Iterate over the cookies and print their values
        cookies.forEach((name, cookie) -> {
        System.out.println("Cookie Name: " + name + " | Value: " + cookie.getValue());
        });
                
        Optional<String> podName = Optional.ofNullable(System.getenv("HOSTNAME"));
        if (podName.isPresent()) {
            System.out.println("Pod Hostname: " + podName.get());
            return "Hello from Quarkus REST :: " + podName.get();
        }   
        return "Hello from Quarkus REST";
    }
}
