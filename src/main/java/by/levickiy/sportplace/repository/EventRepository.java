package by.levickiy.sportplace.repository;

import by.levickiy.sportplace.entity.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Repository
@Transactional
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
    Optional<Event> findEventByName(String name);
    Collection<Event> findAll();
    Optional<Collection<Event>> getEventsByPlaceId(Long placeId);
    @Query("SELECT e from EVENTS e where (?1 is null or e.place.country = ?1) and (?2 is null or e.place.name = ?2) and (?3 is null or e.startDate > ?3) and (?4 is null or e.finishDate < ?4)")
    Optional<Collection<Event>> getEventsByParams(String country, String place, Date startDate, Date finishDate);
    void deleteEventById(Long id);
}
