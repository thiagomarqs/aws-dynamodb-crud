package com.github.thiagomarqs.awsdynamodbcrud.application.usecases;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.FindPersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.FindPersonRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindPersonUseCase implements FindPersonUseCasePort {

    @Autowired
    FindPersonRepositoryPort findPersonRepositoryPort;

    @Override
    public Person findOne(String email, String fullName) {
        return findPersonRepositoryPort.find(email, fullName);
    }

    @Override
    public List<Person> findAll() {
        return findPersonRepositoryPort.findAll();
    }

}
