package rest;

import com.example.restful_web_service.Greeting;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Component
@Log
public class GreetingController {
    private static final String template = "Hello, %S!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting =new Greeting(counter.incrementAndGet(), String.format(template, name));
        log.info("id:" +greeting.getId()+ " | Name: " + name);
        return greeting;
    }
}
