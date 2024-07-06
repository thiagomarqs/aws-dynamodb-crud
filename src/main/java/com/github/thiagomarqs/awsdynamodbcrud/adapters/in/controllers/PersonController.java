package com.github.thiagomarqs.awsdynamodbcrud.adapters.in.controllers;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.SavePersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.DeletePersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.FindPersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.UpdatePersonUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    SavePersonUseCasePort savePersonUseCasePort;

    @Autowired
    FindPersonUseCasePort findPersonUseCasePort;

    @Autowired
    DeletePersonUseCasePort deletePersonUseCasePort;

    @Autowired
    UpdatePersonUseCasePort updatePersonUseCasePort;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person p) {
        Person created = savePersonUseCasePort.execute(p);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> read(@PathVariable("id") UUID id) {
        Person found = findPersonUseCasePort.execute(id);
        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") UUID id, @RequestBody Person p) {
        p.setId(id);
        Person updated = updatePersonUseCasePort.execute(p);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable("id") UUID id) {
        deletePersonUseCasePort.execute(id);
        return ResponseEntity.accepted().build();
    }

}
