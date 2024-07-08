package com.github.thiagomarqs.awsdynamodbcrud.application.ports.in;

public interface DeletePersonUseCasePort {

    void execute(String email, String fullName);
}
