package com.github.thiagomarqs.awsdynamodbcrud.adapters.out;

import com.github.thiagomarqs.awsdynamodbcrud.application.domain.Person;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.DeletePersonRepositoryPort;
import com.github.thiagomarqs.awsdynamodbcrud.application.ports.out.FindPersonRepositoryPort;
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

import java.util.List;
import java.util.UUID;

@Component
public class DynamoDbPersonRepositoryAdapter implements SavePersonRepositoryPort, FindPersonRepositoryPort, DeletePersonRepositoryPort, UpdatePersonRepositoryPort {

    final DynamoDbEnhancedClient client = DynamoDb.getClient();
    final TableSchema<Person> personTableSchema = TableSchema.fromBean(Person.class);
    final DynamoDbTable<Person> personTable = client.table("person", personTableSchema);

    @Override
    public Person save(Person p) {
        personTable.putItem(p);
        return p;
    }

    @Override
    public Person update(String email, String fullName, Person p) {

        // PK and SK can't be changed, so these lines force them to remain unchanged
        p.setEmail(email);
        p.setFullName(fullName);

        personTable.updateItem(p);

        return p;
    }

    @Override
    public Person find(String email, String fullName) {

        Key key = buildPersonKey(email, fullName);

        QueryConditional query = QueryConditional.keyEqualTo(key);

        PageIterable<Person> results = personTable.query(query);

        return results.items().stream().findFirst().orElse(null);

    }

    @Override
    public List<Person> findAll() {
        PageIterable<Person> found = personTable.scan();
        return found.items().stream().toList();
    }

    @Override
    public void delete(String email, String fullName) {

        Key key = buildPersonKey(email, fullName);

        personTable.deleteItem(key);
    }

    private static Key buildPersonKey(String email, String fullName) {
        return Key.builder()
                .partitionValue(email)
                .sortValue(fullName)
                .build();
    }
}
