package io.github.edufolly;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object hello() {
        Config config = ConfigProvider.getConfig();

        System.out.println(config.getConfigValue("my-secret"));

        return config;
    }
}