package daggerok.app;

import lombok.extern.log4j.Log4j2;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;

import javax.enterprise.event.Event;
import javax.inject.Inject;

@Log4j2
public class FailureService {

    @Inject
    Event<ExceptionToCatchEvent> events;

    public String maybeSayHello() {
        try {
            if (System.currentTimeMillis() % 2 == 0)
                throw new RuntimeException("oop");
        } catch (RuntimeException e) {
            events.fire(new ExceptionToCatchEvent(e));
        }
        return "Hello!";
    }
}
