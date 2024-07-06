package com.github.thiagomarqs.awsdynamodbcrud.application.usecases;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.FindPersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.FindPersonRespositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FindPersonUseCase implements FindPersonUseCasePort {

    @Autowired
    FindPersonRespositoryPort findPersonRespositoryPort;

    @Override
    public Person execute(UUID id) {
        return findPersonRespositoryPort.find(id);
    }

}
