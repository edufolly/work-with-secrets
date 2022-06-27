package io.github.edufolly;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.config.spi.ConfigSource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author Eduardo Folly
 */
@Path("/")
public class GeneralResource {

    @ConfigProperty(name = "my-injected")
    String myInjected;

    @ConfigProperty(name = "my.uppercase.secret")
    String myUppercaseSecret;

    @GET
    @Path("/config")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> config() {
        Config config = ConfigProvider.getConfig();

        for (ConfigSource configSource : config.getConfigSources()) {
            if (configSource.getName().startsWith("FileSystemConfig")) {
                return configSource.getProperties();
            }
        }

        return Map.of("error", "FileSystemConfig not found.");
    }

    @GET
    @Path("/injected")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> injected() {
        return Map.of("my-injected", myInjected);
    }

    @GET
    @Path("/uppercase")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> uppercase() {
        return Map.of("my.uppercase.secret", myUppercaseSecret);
    }

}