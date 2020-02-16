package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/listgreeting")
    public  List<Greeting>  listGreting(@RequestParam(value = "name", defaultValue = "World") String name) {
         List<Greeting> lsitGretting=new ArrayList<Greeting>();
        lsitGretting.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        lsitGretting.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        lsitGretting.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        lsitGretting.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        lsitGretting.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        lsitGretting.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        lsitGretting.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));

        return lsitGretting;
    }
}
