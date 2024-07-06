package com.github.thiagomarqs.awsdynamodbcrud.application.ports.out;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;

import java.util.UUID;

public interface FindPersonRespositoryPort {

    Person find(UUID id);

}
