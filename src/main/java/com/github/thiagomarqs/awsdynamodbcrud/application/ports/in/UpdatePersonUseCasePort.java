package com.github.thiagomarqs.awsdynamodbcrud.application.ports.in;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;

public interface UpdatePersonUseCasePort {

    Person execute(Person p);
}
