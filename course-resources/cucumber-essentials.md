# Cucumber Essentials

***

![Static Badge](https://img.shields.io/badge/cucumber-7.18.0-blue?logo=cucumber&style=for-the-badge&logoColor=cyan)

## Table of Contents

- [Introduction](#introduction)
  - [What is Cucumber?](#what-is-cucumber)
  - [What is Gherkin?](#what-is-gherkin)
  - [What is BDD?](#what-is-bdd)
- [Cucumber Feature Files](#cucumber-feature-files)
  - [Anatomy of Feature File](#anatomy-of-feature-file)
  - [Gherkin Syntax](#gherkin-syntax)
  - [Keywords](#keywords)
  - [Secondary Keywords](#secondary-keywords)
- [Handling Test Data with Step Arguments](#handling-test-data-with-step-arguments)
  - [Doc Strings](#doc-strings)
  - [Data Tables](#data-tables)
  - [Passing String and Integer Arguments](#passing-string-and-number-arguments)
- [Examples of Feature Files](#examples-of-feature-files)
  - [Feature: Login Functionality with Data Tables](#feature-login-functionality-with-data-tables)
  - [Example with Doc Strings](#example-with-doc-strings)
  - [Example with Background and Tags](#example-with-background-and-tags)
- [Sharing Data Between Steps - Dependency Injection](#sharing-data-between-steps---dependency-injection)
  - [Example of Dependency Injection](#example-of-dependency-injection)
- [Conclusion](#conclusion)
- [Further Reading](#further-reading)

## Introduction

***

### What is Cucumber?

***
Cucumber is a testing tool that supports `Behavior Driven Development (BDD)`. It offers a way to write tests that
anybody can understand, regardless of their technical knowledge. It is a tool that executes plain-text functional
descriptions as automated tests.

### What is Gherkin?

***
The language that Cucumber understands is called Gherkin. Gherkin is a Business Readable, Domain Specific Language that
lets you describe software’s behavior without detailing how that behavior is implemented.

### What is BDD?

***

`Behavior Driven Development (BDD)` is a branch of Test Driven Development (TDD). It encourages you to write tests that
anybody can understand, regardless of their technical knowledge.

## Cucumber Feature Files

***

Feature files are the essential part of cucumber which is used to write test automation scripts. These files can be
written by anyone including non-programmers. These files can serve as an automation test script as well as live
documents.

### Anatomy of Feature File

***

A Feature File is an entry point to the Cucumber tests. This is a file where you will describe your tests in Descriptive
language (Like English). You can either create a new feature file or use existing one. This file can have any name, but
it should have `.feature` extension.

### Gherkin Syntax

***

Gherkin is a `Business Readable, Domain Specific Language`. That means it is a language that is designed to be read by
humans. It is a simple `English representation` of the application behavior.

Gherkins uses specific keywords to describe the `behaviour` of the application. Each keyword is translated to many
spoken languages; in this reference we will use English.

### Keywords

***

1. `Feature`: The Feature keyword is used to describe a software feature, and to group the related scenarios.
2. `Scenario`: The Scenario keyword is used to define a new test scenario.
3. `Given`: The Given steps are the prerequisite for the further steps.
4. `When`: The When steps describe the `key action` that takes place in the test.
5. `Then`: The Then steps describe the `expected outcome` of the test.
6. `And` & `But`: These are used to chain multiple `Given`, `When`, and `Then` steps together to form a complete test
   scenario.
7. `Scenario Outline`: The Scenario Outline keyword can be used to run the same Scenario multiple times, with different
   combinations of values.
8. `Examples`: The Examples keyword is used to define a table of inputs. These inputs are used by the Scenario Outline.
9. `Background`: The Background keyword is used to define a set of steps that are common to all the tests in the Feature
   file.
10. `Rule`: The Rule keyword is used to define a business rule which is a collection of scenarios that belong to this
    business rule.

### Secondary Keywords

***

1. `@` (Tags): Tags are a way to group Scenarios and Features. This is a way to organize your features and scenarios.
2. `#` (Comments): Comments are used to explain the scenarios and steps in the feature file.
3. `"""` (Doc Strings): Doc Strings are used to provide a detailed description of a particular step.
4. `|` (Data Tables): Data Tables are used to pass a list of values to a step.

## Handling Test Data with Step Arguments

***

### Doc Strings

***

> 📌 Doc Strings are used to provide a detailed description of a particular step. It is defined by using triple double
> quotes `"""`. It is used to pass a large text into a step.

Example:

```gherkin
Scenario: Successful Login with Valid Credentials
Given User is on the Login page
When User enters the following credentials
"""
    {
      "username": "testuser",
      "password": "password123"
    }
    """
Then Message displayed Login Successfully
```

### Data Tables

***

> 📌 Data Tables are used to pass a list of values to a step. It is defined by using `|` (pipe) character. It is used to
> pass a list of values to a step.

Example of Data Tables with List of Maps:

```gherkin

Scenario: Successful Login with Valid Credentials
Given User is on sign-up page
When User enters the following personal details
| first_name | last_name | email            | password     |
| John       | Doe       | test@gmail.com   | password123  |
| Simon      | Doe       | test2@gmail.com  | password1234 |

Then Message displayed Login Successfully
```

This data table will be converted to `List<Map<String, String>>` in the step definition. It will be similiar to this:

```json
[
  {
    "first_name": "John",
    "last_name": "Doe",
    "email": "test@gmail.com",
    "password": "password123"
  },
  {
    "first_name": "Simon",
    "last_name": "Doe",
    "email": "test2@gmail.com",
    "password": "password1234"
  }
]
```

Data Tables can also be used with keys and values. Example:

```gherkin

Scenario: Successful Login with Valid Credentials
Given User is on sign-up page
When User enters the following personal details
| key         | value            |
| first_name  | John             |
| last_name   | Doe              |
| email       |test@gmail.com    |

Then Message displayed Login Successfully
```

This data table will be converted to `Map<String, String>` in the step definition. It will be similiar to this:

```json
{
  "first_name": "John",
  "last_name": "Doe",
  "email": "test@gmail.com"
}
```

> For detailes on Data Table API, please refer to the official documentation
> here: [Data Table API](https://github.com/cucumber/cucumber-jvm/tree/main/datatable)

### Passing String and Number Arguments

***

You can pass string and integer arguments to the step definition. Example:

```gherkin
Scenario: Successful Login with Valid Credentials
Given We want to write a step with parameters
When I pass a string "hello" and an integer 5
Then I should be able to use the string and integer in the test
```

> 📝 String can be passed using double quotes and integer can be passed without quotes. We can also pass double and float
> values.

Example:

```gherkin
Scenario: Successful Login with Valid Credentials
Given We want to write a step with parameters
When I pass a string "hello" and a double 5.5
Then I should be able to use the string and double in the test
```

## Examples of Feature Files

***

### Feature: Login Functionality with Data Tables

***

> 📌 Using Scenario Outline with examples, allows us to run the same Scenario multiple times with different combinations
> of values.

We can also parameterize scenario title to make it more readable in the test reports. The parameters are defined
with `<` and `>`.
Example:

```gherkin
Feature: Login Functionality

  This feature file tests the login functionality of the application.

  Scenario Outline: Successful Login with Valid Credentials for user: <username>
    Given User is on the Login page
    When User enters " <username> " and " <password> "
    Then Message displayed Login Successfully

    Examples:
      | username | password  |
      | testuser | testpass  |
      | admin    | adminpass |
```

### Example with Doc Strings

***

```gherkin
Feature: Login Functionality

  This feature file tests the login functionality of the application.

  Scenario : Successful Login with Valid Credentials
    Given User is on the Login page
    When User enters the following credentials
     """
      {
        "username": "testuser",
        "password": "password123"
      }
      """
    Then Message displayed Login Successfully
```

### Example with Background and Tags

***

> 📌 Background is used to define a set of steps that are common to all the scenarios in the Feature file. Background
> will run before each scenario in the feature file.
>
> - We can keep common steps in the Background that required to run before each scenario. Such as login steps, setup
    etc.
> - We can also use Tags to group Scenarios and Features. This is a way to organize your features and scenarios. Tags
    are then used from the command line to run specific tests.

```gherkin
#Feature file level tags(This is a comment)
@login-tests
Feature: Login Functionality

  This feature file tests the login functionality of the application.
 
  #This will run before each scenario in this feature file.
  Background: User is logged in
    Given User is on the Login page

  #Scenario level tag
  @smoke
  Scenario: Successful Login with Valid Credentials
    When User enters "testuser" and "password123"
    Then Message displayed Login Successfully

  @regression
  Scenario: Unsuccessful Login with Invalid Credentials
    When User enters "testuser" and "passsword123"
    Then Error message displayed
```

## Sharing Data Between Steps - Dependency Injection

***

Cucumber supports Dependency Injection. Dependency Injection is a design pattern that removes the dependency from the
programming code. It is a way to supply a dependent object to a class (dependent class) rather than creating an object
inside the class. This is achieved in Cucumber using `PicoContainer`. It follows constructor-based dependency injection.

### Example of Dependency Injection

***

Imagine we have Cucumber step definitions in multiple classes. A single scenario can use steps from different classes.
In a situation when test data or objects need to be shared between thse steps, which are in different classes, we can
use Dependency Injection. We can store data that needs to be shared in a shared class object and inject this object in
the step definition class constructors.

- These shared objects can be stored in a `SharedData` class. This class is only shared between the steps of same
  scenario and not between different scenarios. For each scenario, a new instance of `SharedData` class is created
  automatically by Cucumber.
- We can inject this `SharedData` object in the step definition class constructors. This way we can share data between
  steps of the same scenario.
- By default Cucumber follows test isolation. This means that each scenario is independent of each other. This is to
  avoid any side effects of one scenario on another.

Example:

`Class to store shared data`

```java
public class SharedData {
    //We can keep fields public for simplicity and reduce boilerplate code.
    public String authToken;
}
```

`Step Definitions class that logs in and extracts the authToken and stores in shared data object`

```java
public class AuthStepDefinitions {
    private SharedData sharedData;

    //Dependency Injection through constructor
    public AuthStepDefinitions(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("Create valid auth token with auth API")
    public void createAuthToken() {
        //Send request to auth API
        //Get the response
        //Fetch session token from response and store in shared data class
        sharedData.authToken = "authToken-extracted-from-response";
    }
}
```

`Update Booking Api step definiton class that uses the stored authToken from shared data object`

```java

public class UpdateBookingStepDefinitions {
    private SharedData sharedData;

    //Dependency Injection through constructor. The sharedData object is injected by Cucumber
    //which has values stored by other steps from different classes.
    public CreateBookingDefinitions(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("Send authenticated request to update booking API")
    public void sendRequestToUpdateBookingAPI() {
        //Send request to update booking API
        //Use the authToken from shared data to authenticate the request
        var authToken = sharedData.authToken;
    }
}
```

`The Scenario will look like this:`

```gherkin

Feature: Update Booking with Auth Token

  Scenario: Update Booking with Auth Token
        
        #This step is in login definitions class. 
        #Extracts the authToken and stores in shared data object
    Given Create valid auth token with auth API

        #This step is in update booking definitions class. 
        #Uses the stored authToken from shared data object
    When Send authenticated request to update booking API

    Then Booking updated successfully
```

## Conclusion

***

In this course, we have learned the basics of Cucumber. We have learned about the Gherkin syntax, Feature files, and how
to write test scenarios. We have also learned about handling test data with Step Arguments, Doc Strings, and Data
Tables. We have also learned about sharing data between steps using Dependency Injection.

> Follow the course lectures to see conding implementations with real examples.

## Further Reading

***

- [Dependency Injection in Cucumber](https://cucumber.io/docs/cucumber/state/)
- [Cucumber PicoContainer](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-picocontainer)
- [Dependency Injection](https://stackoverflow.com/questions/130794/what-is-dependency-injection)
