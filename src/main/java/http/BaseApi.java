/*
Initially when we designed the base API client, we had the access level as protected
The idea to keep this access level protected was if you create an object of any API class that is extending base API in a test class,
that TestNG class should not be able to access the methods of base API itself, even if it has a object of get booking API.

It cannot access the methods of base API itself, so that was the idea of keeping methods protected.
* */
package http;

import config.PropertyUtil;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static config.PropertyUtil.getConfig;

public abstract class BaseApi {
    // SRP (Single Responsibility Principle) applied: this class abstracts and encapsulates HTTP request setup and execution
    private final RequestSpecification requestSpecification;

    // Initializes the RestAssured request specification for use in API methods
    public BaseApi() {

            var httpConfig = HttpClientConfig.httpClientConfig()
                                             .setParam("http.connection.timeout", getConfig().connectionTimeout())
                                             .setParam("http.socket.timeout", getConfig().socketTimeout());
            this.requestSpecification = RestAssured.given()
                                                   .baseUri(getConfig().baseUrl())
                                                   //This filter will be by default applied to all the requests we do not want to give option for not applying
                                                   //The whole idea is we want to capture the CURL for the request entire request payload and the response
                                                   //It would be attached with each test case on the step when you are making an HTTP call
                                                   .filter(new AllureRestAssured())
                                                   .config(RestAssured.config().httpClient(httpConfig));
    }

    // Sets the request body using a POJO or Map
    protected BaseApi setRequestBody(Object object) {
        this.requestSpecification.body(object);
        return this;
    }

    // Set the basepath
    protected void setBasePath(String basePath) {
        this.requestSpecification.basePath(basePath);
    }

    // Sets the content type (e.g., JSON, XML) for the request
    protected BaseApi setContentType(ContentType contentType) {
        this.requestSpecification.contentType(contentType);
        return this;
    }

    // Configures Basic Authentication credentials for the request
    protected BaseApi setBasicAuth(String username, String password) {
        this.requestSpecification.auth().preemptive().basic(username, password);
        return this;
    }

    // Configures Basic Authentication credentials for the request
    protected void setPathParam(String paramName, Object paramValue) {
        this.requestSpecification.pathParam(paramName, paramValue);
    }

    // Logs all request data (method, URI, headers, body, etc.)
    public BaseApi logAllRequestData() {
        this.requestSpecification.filter(new RequestLoggingFilter());
        return this;
    }

    // Logs specific parts of the request (based on provided log detail level)
    public BaseApi logAllSpecificRequestDetail(LogDetail logDetail) {
        this.requestSpecification.filter(new RequestLoggingFilter(logDetail));
        return this;
    }

    // Logs specific parts of the response (based on provided log detail level)
    public BaseApi logAllResponseData()
    {
        this.requestSpecification.filter(new ResponseLoggingFilter());
        return this;
    }

    // Logs specific parts of the response (based on provided log detail level)
    public BaseApi logAllSpecificResponseDetail(LogDetail logDetail) {
        this.requestSpecification.filter(new ResponseLoggingFilter(logDetail));
        return this;
    }

    // Sends an HTTP request based on the given method type (GET, POST, PUT, DELETE, PATCH)
    protected Response sendRequest(Method methodType) {
        final RequestSpecification when = this.requestSpecification.when();
        return switch(methodType) {
            case GET -> when.get();
            case PUT -> when.put();
            case POST -> when.post();
            case DELETE -> when.delete();
            case PATCH -> when.patch();
            default -> throw new IllegalStateException("Input method type not supported - " + methodType);
        };
    }

}
