package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonMapper personMapper;

    public PersonController(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @GetMapping
    public List<Person> all() {
        return personMapper.findAll();
    }

    @PostMapping
    public Person create(@RequestBody CreatePersonRequest req) {
        personMapper.insertByName(req.name());
        Long id = personMapper.lastInsertId();
        return new Person(id, req.name());
    }

    public record Person(Long id, String name) {}
    public record CreatePersonRequest(String name) {}
}