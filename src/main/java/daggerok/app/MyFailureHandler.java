package daggerok.app;

import lombok.extern.log4j.Log4j2;
import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;

import javax.inject.Singleton;

@Log4j2
@Singleton
@ExceptionHandler
public class MyFailureHandler {
    private void on(@Handles ExceptionEvent<Throwable> throwableEvent) {
        log.info("error found: {}", throwableEvent.getException().getLocalizedMessage());
    }
}
