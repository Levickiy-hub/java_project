package by.levickiy.sportplace.service;

import by.levickiy.sportplace.dto.EventDto;
import by.levickiy.sportplace.entity.Event;

import java.util.Collection;
import java.util.Optional;

public interface EventService {
    Collection<Event> getAllEvents();
    Event getEventById(Long id) throws Exception;
    Event getEventByName(String name) throws Exception;
    void saveEvent(EventDto eventDto);
    Collection<Event> getEvents(int page, int counter);
    Collection<Event> getAllEventByName(String name, int page, int counter);
    Collection<Event> getAllEventByParams(EventDto eventDto);
    void deleteAllEventsByPlaceId(Long placeId);
    Optional<Collection<Event>> getAllEventsByPlaceId(Long placeId);
    void deleteEvent(Long id);
    void updateEvent(EventDto eventDto, Long id);
}
