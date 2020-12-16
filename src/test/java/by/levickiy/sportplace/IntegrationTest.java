package by.levickiy.sportplace;

import by.levickiy.sportplace.entity.Event;
import by.levickiy.sportplace.entity.Place;
import by.levickiy.sportplace.service.impl.EventServiceImpl;
import by.levickiy.sportplace.service.impl.PlaceServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders headers = new HttpHeaders();
    @Autowired
    private PlaceServiceImpl placeService;

    @Autowired
    private EventServiceImpl eventService;

    @Test
    public void getPlaceByIdFromServiceReturnEqualInRest() throws JsonProcessingException {
        Place place = placeService.getPlaceById(1L);
        String jsonPlace = mapToJson(place);
        HttpEntity<Place> entity = new HttpEntity<>(place, headers);
        ResponseEntity<String> response = restTemplate.exchange(formFullURLWithPort("/rest/api/v1/places/1"), HttpMethod.GET, entity, String.class);

        Assert.assertEquals(response.getBody(), jsonPlace);
    }

    @Test
    public void getEventByIdFromServiceReturnNotNullResult() throws Exception {
        Event event = eventService.getEventById(1L);
        HttpEntity<Event> entity = new HttpEntity<>(event, headers);
        ResponseEntity<String> response = restTemplate.exchange(formFullURLWithPort("/rest/api/v1/events/7"), HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }




    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    private String formFullURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
