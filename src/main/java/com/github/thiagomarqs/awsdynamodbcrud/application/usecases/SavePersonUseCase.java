package com.github.thiagomarqs.awsdynamodbcrud.application.usecases;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.SavePersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.SavePersonRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePersonUseCase implements SavePersonUseCasePort {

    @Autowired
    SavePersonRepositoryPort savePersonRepositoryPort;

    public Person execute(Person p) {
        return savePersonRepositoryPort.save(p);
    }

}
