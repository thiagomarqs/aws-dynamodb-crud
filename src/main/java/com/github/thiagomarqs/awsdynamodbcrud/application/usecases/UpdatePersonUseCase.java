package com.github.thiagomarqs.awsdynamodbcrud.application.usecases;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.UpdatePersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.UpdatePersonRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePersonUseCase implements UpdatePersonUseCasePort {

    @Autowired
    UpdatePersonRepositoryPort updatePersonRepositoryPort;

    @Override
    public Person execute(Person p) {
        return updatePersonRepositoryPort.update(p.getId(), p);
    }

}
