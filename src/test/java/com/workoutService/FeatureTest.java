package com.workoutService;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class FeatureTest{
    @Autowired
    private TestRestTemplate restTemplate;
    private EntityManager entitymanager;
    @LocalServerPort int randomServerPort;
    @Test
    public void testGetWorkouts() throws URISyntaxException{
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/v1/workouts";
        URI uri = new URI(baseUrl);
        ResponseEntity<ArrayList> response
                = restTemplate.getForEntity(uri, ArrayList.class);
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals(5, response.getBody().size());
    }
    @Test
    public void testGetWorkout() throws URISyntaxException{
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/v1/workouts/1";
        URI uri = new URI(baseUrl);
        ResponseEntity<JSONObject> response
                = restTemplate.getForEntity(uri, JSONObject.class);
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals("Workout 1", response.getBody().get("name"));
        Assert.assertEquals(1, response.getBody().get("id"));
        Assert.assertEquals(30, response.getBody().get("length"));
    }
    @Test
    public void testGetWorkoutByTag() throws URISyntaxException{
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/v1/workoutsByTag?tags=cardio,cardio1";
        URI uri = new URI(baseUrl);
        ResponseEntity<ArrayList> response
                = restTemplate.getForEntity(uri, ArrayList.class);
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals(1, response.getBody().size());
    }
    @Test

    public void testGetExercises() throws URISyntaxException{
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/v1/exercises";
        URI uri = new URI(baseUrl);
        ResponseEntity<ArrayList> response
                = restTemplate.getForEntity(uri, ArrayList.class);
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals(5, response.getBody().size());
    }
    @Test

    public void testGetExercise() throws URISyntaxException{
        final String baseUrl = "http://localhost:"+randomServerPort+"/api/v1/exercises/1";
        URI uri = new URI(baseUrl);
        ResponseEntity<JSONObject> response
                = restTemplate.getForEntity(uri, JSONObject.class);
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals("Exercises 1", response.getBody().get("name"));
        Assert.assertEquals(1, response.getBody().get("id"));
    }
}

