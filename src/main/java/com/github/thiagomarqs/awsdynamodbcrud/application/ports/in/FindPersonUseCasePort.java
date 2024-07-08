package com.github.thiagomarqs.awsdynamodbcrud.application.ports.in;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;

import java.util.List;

public interface FindPersonUseCasePort {

    Person findOne(String email, String fullName);

    List<Person> findAll();
}
