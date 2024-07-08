package com.github.thiagomarqs.awsdynamodbcrud.application.ports.out;

public interface DeletePersonRepositoryPort {

    void delete(String email, String fullName);

}
