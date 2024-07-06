package com.github.thiagomarqs.awsdynamodbcrud.application.ports.out;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;

public interface SavePersonRepositoryPort {

    Person save(Person p);

}
