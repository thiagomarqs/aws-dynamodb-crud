package com.myorg;

import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.services.appsync.DynamoDbDataSource;
import software.amazon.awscdk.services.dynamodb.Attribute;
import software.amazon.awscdk.services.dynamodb.AttributeType;
import software.amazon.awscdk.services.dynamodb.Table;
import software.amazon.awscdk.services.dynamodb.TableProps;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class DynamoDbStack extends Stack {
    public DynamoDbStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public DynamoDbStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        TableProps tableProps;

        Attribute partitionKey = Attribute.builder()
                .name("email")
                .type(AttributeType.STRING)
                .build();

        Attribute sortKey = Attribute.builder()
                .name("fullName")
                .type(AttributeType.STRING)
                .build();

        tableProps = TableProps.builder()
                .tableName("person")
                .partitionKey(partitionKey)
                .sortKey(sortKey)
                .removalPolicy(RemovalPolicy.DESTROY)
                .build();

        Table personTable = new Table(this, "Person", tableProps);

    }
}
