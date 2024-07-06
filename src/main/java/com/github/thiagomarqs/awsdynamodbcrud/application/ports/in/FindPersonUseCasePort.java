package com.github.thiagomarqs.awsdynamodbcrud.application.ports.in;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;

import java.util.UUID;

public interface FindPersonUseCasePort {

    Person execute(UUID id);
}
