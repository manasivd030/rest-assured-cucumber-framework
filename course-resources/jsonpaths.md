# Jayway JSONPath Examples

***

![Static Badge](https://img.shields.io/badge/jayway-2.9.0-black?logoColor=white&logoSize=auto&label=jayway-jsonpath&labelColor=%23BD1C2B&style=for-the-badge)

## Installation

***

Add the following dependency to your `pom.xml` file:

```xml

<dependency>
    <groupId>com.jayway.jsonpath</groupId>
    <artifactId>json-path</artifactId>
    <version>2.9.0</version>
</dependency>

```

## Usage Examples

***

### JSON with a list of books

Sample GET API which returns list of books [Get All Books](https://bookcart.azurewebsites.net/api/book/)

```json

[
  {
    "bookId": 2,
    "title": "Harry Potter and the Chamber of Secrets",
    "author": "JKR",
    "category": "Mystery",
    "price": 235,
    "coverFileName": "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg"
  },
  {
    "bookId": 3,
    "title": "Harry Potter and the Prisoner of Azkaban",
    "author": "JKR",
    "category": "Romance",
    "price": 213,
    "coverFileName": "c63ade52-3f90-41fa-980a-1136b6ad2128HP3.jpg"
  },
  {
    "bookId": 21,
    "title": "Slayer",
    "author": " Kiersten White",
    "category": "Mystery",
    "price": 1234,
    "coverFileName": "6d91b7b0-b8d1-41ad-a0ef-65e2324fc1b3Slayer.jpg"
  },
  {
    "bookId": 29,
    "title": "Roomies",
    "author": "Christina Lauren ",
    "category": "Biography",
    "price": 334,
    "coverFileName": "267e7cea-d66e-4e00-a220-c0ee7e70fdaf33322.jpg"
  }
]
```

| Use Case                                     | JSONPath                                            |
|----------------------------------------------|-----------------------------------------------------|
| Get Book with ID: 29                         | `$[?(@.bookId == 29)]`                              |
| Get Book with ID: 29 and Category: Biography | `$[?(@.bookId == 29 && @.category == 'Biography')]` |
| Flatten all book authors                     | `$..author`                                         |
| Get all books with price less than 500       | `$[?(@.price < 500)]`                               |
| Get books with title starting with 'Harry'   | `$[?(@.title =~ /Harry.*/i)]`                       |
| Get books with title containing 'Potter'     | `$[?(@.title =~ /.*Potter.*/i)]`                    |

### Nested JSON Objects

***

Consider another JSON which has nested objects:

```json
 {
  "firstName": "John",
  "lastName": "doe",
  "age": 26,
  "address": {
    "streetAddress": "naist street",
    "city": "Nara",
    "postalCode": "630-0192"
  },
  "phoneNumbers": [
    {
      "type": "iPhone",
      "number": "0123-4567-8888"
    },
    {
      "type": "home",
      "number": "0123-4567-8910"
    }
  ]
}
```

| Use Case                        | JSONPath                                        |
|---------------------------------|-------------------------------------------------|
| Get all phone numbers           | `$..phoneNumbers[*][*]`                         |
| Get phone number of type iPhone | `$..phoneNumbers[?(@.type == 'iPhone')].number` |

## Negation

We can use `!` for negation.

Example:

- Get All books having category not equals "Mystery"

```
[?(!(@.category=='Mystery'))]
```

- Filter books for price not than 5000 and category not equals fiction

```
[?(!(@.price < 5000 || @.category == 'Fiction'))]
```

## Reference

***

- [Jayway JSONPath](https://github.com/json-path/JsonPath)
- [Jayway JSONPath Evaluator](https://jsonpath.fly.dev)

***
