package com.github.thiagomarqs.awsdynamodbcrud.application.ports.in;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;

public interface SavePersonUseCasePort {

    Person execute(Person p);
}
