package io.github.edufolly;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author Eduardo Folly
 */
@Path("/injected")
public class GeneralResource {

    @ConfigProperty(name = "my-injected")
    String myInjected;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> hello() {
        return Map.of("my-injected", myInjected);
    }

}