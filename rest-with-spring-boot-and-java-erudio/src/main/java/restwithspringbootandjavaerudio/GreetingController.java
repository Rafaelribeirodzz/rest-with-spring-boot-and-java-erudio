package restwithspringbootandjavaerudio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(); //papel desse cara é mocar um id

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")
            String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));// "counter.incrementAndGet()" a cada chamada ele vai chamar um id maior

    }
}
