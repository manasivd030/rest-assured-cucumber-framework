# API Testing and REST Assured

## Table of Contents

- [Different Layers of API Testing](#different-layers-of-api-testing)
  - [Functionality Testing](#functionality-testing)
  - [Non-Functional Testing](#non-functional-testing)
  - [Integration Testing(If applicable)](#integration-testingif-applicable)
  - [Why API Testing is Important](#why-api-testing-is-important)
- [How REST Assured Simplifies API Testing](#how-rest-assured-simplifies-api-testing)
  - [Advantages of REST Assured](#advantages-of-rest-assured)
- [REST Assured vs HTTP Client](#rest-assured-vs-http-client)
  - [High Level Example with HTTP Client](#high-level-example-with-http-client)
  - [Same Example with REST Assured](#same-example-with-rest-assured)
- [Conclusion](#conclusion)
- [References](#references)

## Different Layers of API Testing

### Functionality Testing

- **Resource Endpoints**: Verify that requests targeting specific resources (e.g., user profiles, product listings) reach the intended endpoints and return the expected data. Test all relevant methods (GET, POST, PUT, DELETE) for each resource.

- **Request Parameters**: Ensure the API handles different types of parameters (e.g., required, optional) correctly. Test valid and invalid parameter values to check for proper error handling.

- **Data Validation**: Test that the API validates user input according to defined rules. For example, email addresses should be in a valid format, or product quantities should be within acceptable ranges.

- **Business Logic**: Verify that the API performs actions as intended based on the business requirements. This might involve testing calculations, data manipulation, or integrations with other systems.

### Non-Functional Testing

- **Performance**: Evaluate the API's response time, throughput, and resource utilization under different load conditions. Test for scalability and identify bottlenecks that could impact performance.

- **Security**: Check for vulnerabilities such as SQL injection, cross-site scripting (XSS), and improper authentication/authorization mechanisms. Ensure sensitive data is protected and transmitted securely.

- **Reliability**: Assess the API's stability and availability. Test how it handles errors, exceptions, and unexpected inputs. Verify that it gracefully recovers from failures and maintains data integrity.

- **Scalability**: Determine how well the API can handle increased load and traffic. Test its ability to scale horizontally (adding more servers) or vertically (upgrading hardware) to meet growing demands.

- **Error Handling**: Validate that the API returns appropriate error codes and messages for different scenarios (e.g., invalid requests, server errors). Test how it handles exceptions and provides meaningful feedback to clients.

### Integration Testing(If applicable)

- **Third-Party Integrations**: Test interactions with external services or APIs to ensure seamless communication and data exchange. Verify that the API correctly processes responses from other systems and handles errors gracefully.

- **Data Consistency**: Check that data remains consistent across different systems or components integrated with the API. Test synchronization mechanisms and data transformation processes to prevent data discrepancies.

- **Authentication/Authorization**: Validate the API's authentication and authorization mechanisms when interacting with other services. Test user roles, permissions, and access controls to ensure secure data access and protection.

### Why API Testing is Important

- **Ensure API functionality works as expected**: Test different use cases and data scenarios to verify the API produces the correct output for various inputs.
- **Identify and fix bugs early**: By testing APIs early in the development lifecycle, you can catch and fix issues before they impact the overall system.
- **Improve API performance**: Test APIs under load to identify performance bottlenecks and ensure they can handle real-world traffic.
- **Enhance API security**: Test APIs for potential vulnerabilities like unauthorized access or data breaches.
- **Validate integrations**: Ensure APIs work correctly when integrated with other systems or third-party services.

## How REST Assured Simplifies API Testing

REST Assured is a Java library that provides a domain-specific language (DSL) for writing API tests. It simplifies the process of sending HTTP requests, validating responses, and extracting data from JSON or XML formats.

### Advantages of REST Assured

- **Simplifies HTTP Requests and Responses**:
  - REST Assured eliminates the need for writing complex boilerplate code to build HTTP requests
  - Inbuilt support for handling responses.
  - It provides a user-friendly syntax with methods for setting URLs, headers, request body, and expected response codes.
- **Improves Readability**:
  - REST Assured utilizes a `Given/When/Then` BDD (Behavior Driven Development) style for writing tests.
  - This makes the tests more readable and easier to understand by both developers and testers.
  - You can clearly see the setup (Given), the action taken (When), and the expected outcome (Then).
- **Supports JSON and XML Parsing** that simplifies the extraction of data from API responses.
  - REST Assured offers methods for parsing JSON and XML responses, making it easy to extract specific values for validation(built-in support for JSONPath and XPath).
  - You can navigate through complex data structures and retrieve nested elements or arrays with ease.
- **Provides Extensive Validations**:
  - REST Assured offers `built-in` methods for validating response status codes, headers, and body content.
  - You can perform detailed assertions on JSON or XML structures, including nested elements and arrays.
    - It supports custom matchers and Hamcrest assertions for more advanced validations.
- **Serialization and Deserialization**:
  - REST Assured supports serialization and deserialization of Java objects to JSON or XML formats.
  - This feature simplifies sending complex payloads in requests and converting response data into Java objects for further processing.
  - This is a built-in feature that eliminates the need for external libraries or custom code.
- **Built-in Support for Authentication**:
  - REST Assured provides methods for handling different types of authentication mechanisms, such as basic, digest, OAuth 2.0 and more.
  - You can easily include authentication details in requests without manually encoding credentials or tokens.

## REST Assured vs HTTP Client

### High Level Example with HTTP Client

```java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

private static final String BASE_URL = "https://api.example.com/users/1";

public static void main(String[] args) throws IOException, InterruptedException {
  HttpRequest request = HttpRequest.newBuilder()
                                   .GET()
                                   .uri(URI.create(BASE_URL))
                                   .build();

  HttpResponse<Void> response;
  try (HttpClient client = HttpClient.newHttpClient()) {
    response = client.send(request, HttpResponse.BodyHandlers.discarding());
  }

  if (response.statusCode() == 200) {
    System.out.println("Success!");
  } else {
    System.out.println("Error: " + response.statusCode());
  }
}


```

### Same Example with REST Assured

```java

import io.restassured.RestAssured;
import io.restassured.response.Response;

public static void main(String[] args) {
    Response response = RestAssured.given()
                                   .baseUri("https://api.example.com")
                                   .and().basePath("/users/1")
                                   .when().get()
                                   .then().assertThat().statusCode(200)
                                   .and().extract().response();
  }

```

## Conclusion

API testing is a critical aspect of software development, ensuring that APIs function correctly, securely, and efficiently.

REST Assured simplifies the process of testing APIs by providing a user-friendly DSL for writing tests, handling HTTP requests and responses, and validating data formats.

>By leveraging REST Assured, teams can streamline their API testing efforts and improve the overall quality of their applications.

## References

- [What is REST](https://restfulapi.net/)
- [API Testing](https://en.wikipedia.org/wiki/API_testing)
- [Test Pyramid](https://martinfowler.com/articles/practical-test-pyramid.html)
