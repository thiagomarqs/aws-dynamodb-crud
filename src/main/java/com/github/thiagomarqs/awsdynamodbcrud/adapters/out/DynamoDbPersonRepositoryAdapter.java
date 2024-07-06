package com.github.thiagomarqs.awsdynamodbcrud.adapters.out;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.DeletePersonRepositoryPort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.FindPersonRespositoryPort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.SavePersonRepositoryPort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.UpdatePersonRepositoryPort;
import com.github.thiagomarqs.awsdynamodbcrud.infra.DynamoDb;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.UUID;

@Component
public class DynamoDbPersonRepositoryAdapter implements SavePersonRepositoryPort, FindPersonRespositoryPort, DeletePersonRepositoryPort, UpdatePersonRepositoryPort {

    final DynamoDbEnhancedClient client = DynamoDb.getClient();
    final TableSchema<Person> personTableSchema = TableSchema.fromBean(Person.class);
    final DynamoDbTable<Person> personTable = client.table("Person", personTableSchema);

    @Override
    public Person save(Person p) {
        if(p.getId() == null) {
            p.setId(UUID.randomUUID());
        }
        personTable.putItem(p);
        return p;
    }

    @Override
    public Person update(UUID id, Person p) {
        personTable.updateItem(p);
        return p;
    }

    @Override
    public Person find(UUID id) {
        Key key = Key.builder().partitionValue(id.toString()).build();
        QueryConditional query = QueryConditional.keyEqualTo(key);
        PageIterable<Person> results = personTable.query(query);
        return results.items().stream().findFirst().orElseThrow();
    }

    @Override
    public void delete(UUID id) {
        Key key = Key.builder().partitionValue(id.toString()).build();
        personTable.deleteItem(key);
    }
}
