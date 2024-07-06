package com.github.thiagomarqs.awsdynamodbcrud.application.ports.out;

import java.util.UUID;

public interface DeletePersonRepositoryPort {

    void delete(UUID id);

}
