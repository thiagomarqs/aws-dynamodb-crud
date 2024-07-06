package com.github.thiagomarqs.awsdynamodbcrud.application.ports.in;

import java.util.UUID;

public interface DeletePersonUseCasePort {

    void execute(UUID id);
}
