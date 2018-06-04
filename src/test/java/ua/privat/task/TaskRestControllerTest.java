package ua.privat.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ua.privat.task.domains.Person;
import ua.privat.task.domains.Task;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void getAllTasks() {
        ResponseEntity< List<Task>> responseEntity =
                restTemplate.exchange("http://localhost:8080/tasks", HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>(){});
        List<Task> task = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        task.forEach(t -> assertEquals(t.getName(), "testy"));
    }


    @Test
    public void addTask() {
        Task task = new Task();
        task.setName("Unit test");
        task.setStartDate(LocalDate.of(2018,6,3));
        task.setEndDate(LocalDate.of(2018,6,4));
        task.setPerson(Arrays.asList(new Person().setId(3L)));
       restTemplate.put("http://localhost:8080/tasks", task);
    }

    @Test
    public void deleteTask() {
        Task task = new Task();
        task.setName("Unit test");
        task.setStartDate(LocalDate.of(2018,6,3));
        task.setEndDate(LocalDate.of(2018,6,4));
        task.setPerson(Arrays.asList(new Person().setId(3L)));
        restTemplate.delete("http://localhost:8080/tasks", task);
    }

}