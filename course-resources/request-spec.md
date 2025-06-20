# It all starts with a request

***
![RestAssured](https://img.shields.io/badge/RestAssured-5.4.0-blue?labelColor=00A86B&style=for-the-badge)

Let's understand how to define API request with RestAssured's RequestSpecification class.

Every API Request contains three key elements:

- `User Action` defines what the user wants to do (e.g., view a user profile, create a new user).
- `Method` defines the type of action being requested (`GET`, `POST`, `PUT`, `DELETE`).
- `Resource` defines the specific piece of information being targeted (e.g., users, a specific user ID).

## RequestSpecification Class - The Core of RestAssured

***

RequestSpecification is a class in RestAssured that allows you to specify how the request will look like. It is used to
build a request by specifying the request method:

- URI
- Headers
- Query parameters
- Form parameters
- Path parameters
- Request Body
- Authentication
- Content Type
- Cookies

## Creating a RequestSpecification

It is initialized using the `given()` method which is a static method in the RestAssured class. The `given()` method
returns an instance of RequestSpecification which can be used to build a request.

```java
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RequestSpecExampleTest {

    @Test
    public void sampleRequestSpecTest() {
        //New instance of RequestSpecification
        RequestSpecification request = RestAssured.given();
        //Define request specifications here by chaining methods
        request.baseUri("https://api.example.com")
               .and().basePath("/v1")
               .and().header("header-name", "header-value")
               .and().contentType(ContentType.JSON)
               .and().accept(ContentType.JSON)
               .and().queryParam("limit", 10)
               .and().formParam("name", "John Doe")
               .and().cookie("test-cookie")
               .pathParam("id", 123)
               .body("{ \"key\": \"value\" }");
    }
}

```

## Highlights of Methods in RequestSpecification

***

- `baseUri(String uri)`: Sets the base URI for the request.
- `basePath(String path)`: Sets the base path for the request.
- `header(String name, String value)`: Adds a header to the request.
- `cookie("cookie-name")`: Adds a cookie to the request.
- `queryParam(String name, Object value)`: Adds a query parameter to the request.
- `formParam(String name, Object value)`: Adds a form parameter to the request.
- `pathParam(String name, Object value)`: Adds a path parameter to the request.
- `auth().basic(String username, String password)`: Sets basic authentication for the request.
- `auth().oauth2(String accessToken)`: Sets OAuth2 authentication for the request.
- `body(Object body)`: Sets the request body.
- `contentType(ContentType contentType)`: Sets the content type of the request.
- `accept(ContentType contentType)`: Sets the accept type of the request.
- `log()`: Logs the request details.

High Level HTTP Method Types:

- `post()`: Sends a POST request.
- `get()`: Sends a GET request.
- `put()`: Sends a PUT request.
- `delete()`: Sends a DELETE request.
- `patch()`: Sends a PATCH request.

> Syntactic Sugar and BDD Style: We can chain these above methods using `given(), when(), and(), then()` methods.

## Benefits of RequestSpecification

***

- **Reusability**: RequestSpecification allows you to define common request specifications that can be reused across
  multiple test cases.
- **Maintainability**: RequestSpecification helps in maintaining the request specifications in a single place, making it
  easier to update them when needed.
- **Readability**: RequestSpecification makes the test code more readable by separating the request building logic from
  the test logic.

***
