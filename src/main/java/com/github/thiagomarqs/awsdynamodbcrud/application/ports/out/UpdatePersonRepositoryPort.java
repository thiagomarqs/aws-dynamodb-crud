package com.github.thiagomarqs.awsdynamodbcrud.application.ports.out;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;

public interface UpdatePersonRepositoryPort {

    Person update(String email, String fullName, Person p);

}
