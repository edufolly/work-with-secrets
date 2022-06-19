package io.github.edufolly;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.spi.ConfigSource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/config")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> hello() {
        Config config = ConfigProvider.getConfig();

        System.out.println(config.getConfigValue("my-secret"));

        Iterable<ConfigSource> configSources = config.getConfigSources();

        for (ConfigSource configSource : configSources) {
            if (configSource.getName().startsWith("FileSystemConfig")) {
                return configSource.getProperties();
            }
        }

        return Map.of("error", "FileSystemConfig not found.");
    }

}