package com.github.thiagomarqs.awsdynamodbcrud.adapters.in.controllers;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.SavePersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.DeletePersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.FindPersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.UpdatePersonUseCasePort;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<Person> findOne(@RequestParam("email") @NotNull String email, @RequestParam("fullName") @NotNull String fullName) {
        Person found = findPersonUseCasePort.findOne(email, fullName);
        return ResponseEntity.ok(found);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> findAll() {
        List<Person> found = findPersonUseCasePort.findAll();
        return ResponseEntity.ok(found);
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestParam("email") @NotNull String email, @RequestParam("fullName") @NotNull String fullName, @RequestBody Person p) {
        Person updated = updatePersonUseCasePort.execute(email, fullName, p);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping()
    public ResponseEntity<Person> delete(@RequestParam("email") @NotNull String email, @RequestParam("fullName") @NotNull String fullName) {
        deletePersonUseCasePort.execute(email, fullName);
        return ResponseEntity.accepted().build();
    }

}
