package com.github.thiagomarqs.awsdynamodbcrud.application.usecases;

import com.github.thiagomarqs.awsdynamodbcrud.application.ports.in.DeletePersonUseCasePort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.DeletePersonRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePersonUseCase implements DeletePersonUseCasePort {

    @Autowired
    DeletePersonRepositoryPort deletePersonRepositoryPort;

    @Override
    public void execute(String email, String fullName) {
        deletePersonRepositoryPort.delete(email, fullName);
    }

}
