# graphql-java-demo
GraphQL backend service and consumer service demo application

## Branches -
  - [With Spring boot starter](/ariskycode/graphql-java-demo/tree/with-sb-starter)
  - [Without Spring boot starter](/ariskycode/graphql-java-demo/tree/without-sb-starter)
  - [Rest Client for Consumer Application](/ariskycode/graphql-java-demo/tree/rest-client)
  
### With and Without Spring Boot Starter Branch
These branches serve as basic demo implementations for creating a GraphQL API in Java

- Without Spring Boot Starter 
  This allows for a flexible backend which can interface with other types of frameworks. It also allows for schema stitching and declaring your own runtime schema bindings.
  
- With Spring Boot Starter
  This relies on Spring components or beans for initializing schema. All services can be autowired which makes implementation easier.
  
### Rest Client for Consumer Application
This branch has an implementation of RestClient(RestTemplate) service which calls the GraphQL API and retrieves data as per the the defined query. The GraphQL query can be modified as needed.
This is exposed under the getSpeakers and speaker endpoint and can serve as sample code for GraphQL API consumption through Java.


