package com.github.thiagomarqs.awsdynamodbcrud.application.ports.out;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;

import java.util.List;

public interface FindPersonRepositoryPort {

    Person find(String email, String fullName);

    List<Person> findAll();

}
