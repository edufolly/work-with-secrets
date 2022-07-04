package io.github.edufolly.schedulers;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

/**
 * @author Eduardo Folly
 */
@ApplicationScoped
public class StatsScheduler {

    @Scheduled(every = "${folly.stats.every:60s}",
               delay = 10, delayUnit = TimeUnit.SECONDS)
    public void stats() {
        Log.info("Stats: OK!");
    }

}
