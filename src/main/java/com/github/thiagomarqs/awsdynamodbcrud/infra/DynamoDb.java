package com.github.thiagomarqs.awsdynamodbcrud.infra;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

public class DynamoDb {

    private static DynamoDbEnhancedClient client;

    public static DynamoDbEnhancedClient getClient() {

        if(client != null) return client;

        client = DynamoDbEnhancedClient.create();

        return client;
    }
}
