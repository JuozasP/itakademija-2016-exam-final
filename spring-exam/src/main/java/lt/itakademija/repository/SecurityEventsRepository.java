package lt.itakademija.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

/**
 * Security events repository.
 * 
 * @author mariusg
 */

public interface SecurityEventsRepository {

    /**
     * Returns a list of registered events.
     *
     * @return list of registered events.
     */
    List<RegisteredEvent> getEvents(String location, String description, Date dateFrom, Date dateTill);

    List<RegisteredEvent> getEvents();

    /**
     * Creates registered event.
     *
     * @param eventRegistration event data
     * @return created event
     */
    RegisteredEvent create(EventRegistration eventRegistration);

    /**
     * Deletes a registered event.
     *
     * @param id event id
     * @return deleted event
     */
    RegisteredEvent delete(Long id);

    /**
     * Updates registered event.
     *
     * @param id event id
     * @param registeredEventUpdate data to update
     * @return updated event
     */
    RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate);

    RegisteredEvent findById(Long id);

}
