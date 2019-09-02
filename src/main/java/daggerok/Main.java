package daggerok;

import daggerok.app.FailureService;
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j2;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Log4j2
public class Main {

    public static void main(String[] args) {

        SeContainerInitializer initializer
                = SeContainerInitializer.newInstance()
                                        // .disableDiscovery()
                                        .addPackages(true, Main.class);

        try (SeContainer container = initializer.initialize()) {
            FailureService failureService = container.select(FailureService.class).get();
            IntStream.range(0, 5)
                     .peek(value -> Try.run(() -> TimeUnit.MILLISECONDS.sleep(11)))
                     .forEach(value -> failureService.maybeSayHello());
        }
    }
}
