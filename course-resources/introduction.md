# Introduction

## Table of Contents

- [What is an API?](#what-is-an-api)
- [What does REST stand for?](#what-does-rest-stand-for)
    - [Resource-Based](#resource-based)
    - [Standard Methods](#standard-methods)
    - [Stateless](#stateless)
    - [Use of URLs](#use-of-urls)
    - [Client-Server Architecture](#client-server-architecture)
    - [Representation](#representation)
    - [Stateless Operations](#stateless-operations)
- [Why the Term "RESTful"?](#why-the-term-restful)
- [API in Simple Terms](#api-in-simple-terms)
- [Key Points](#key-points)
- [Simple API E2E Flow](#simple-api-e2e-flow)

## What is an API?

An API(Application Programming Interfaces) is a set of business rules and specifications that define how applications
interact with each other.
It acts as an intermediary, allowing applications to request and receive data without needing to know the underlying
implementation details.
APIs are typically accessed through `HTTP` requests and responses, following formats like `JSON` or `XML`.

## What does REST stand for?

REST (Representational State Transfer) is a simple way to structure communication between systems on the web. Here’s a
straightforward explanation:

### Resource-Based

Think of everything on the web as a resource, like a document, image, or user profile.

> Each resource can be accessed using a unique URL (Uniform Resource Locator), which is like an address.

### Standard Methods

REST uses standard HTTP methods to perform actions on these resources. The main methods are:

- `GET`: Retrieve information about a resource (like viewing a webpage).
- `POST`: Create a new resource (like submitting a form to create a new account).
- `PUT`: Update an existing resource (like changing your profile information).
- `DELETE`: Remove a resource (like deleting a post).

### Stateless

Each request from a client to a server must contain all the information needed to understand and process the request.
The server doesn’t keep any client information between requests.

> This makes each request independent.

### Use of URLs

> Resources are identified using URLs.

For example:

- <http://example.com/users> could be a URL for a list of users.
- <http://example.com/users/123> could be a URL for a specific user with ID 123.

### Client-Server Architecture

The client (like your web browser or mobile app) sends a request to the server (where the website or application is
hosted), and the server responds.
> This separation allows each part to evolve independently.

### Representation

When a client requests a resource, the server sends back a representation of that resource. This could be in various
formats like `HTML`, `JSON`, or `XML`.

> `JSON` is commonly used because it’s easy for both humans and machines to read.

### Stateless Operations

Each operation (request) is stateless, meaning the server doesn’t store information about previous requests. This makes
it easier to scale because each request is processed in isolation.

## Why the Term "RESTful"?

The term "RESTful" is used to describe services that comply with REST principles because they embody the idea of REST.

Here’s why:

- **"REST"**:
  Represents the architectural style and principles.

- **"ful"**:
  Implies that the web services or APIs are full of or adhere completely to REST principles.

> It denotes that these services make full use of the REST design philosophy.

## API in Simple Terms

Imagine you're ordering takeout from a restaurant. Here's how it relates to a REST API:

- `Menu (Resource)`: The restaurant's menu lists all the dishes (resources) available, like pizza, burgers, etc.
- `Ordering (Method)`: You tell the restaurant what you want (method) - "I want a pizza" (GET request to retrieve info)
  or "
  I'd like to order a burger" (POST request to create a new order).
- `Kitchen (Server)`: The kitchen (server) stores the food (resources) and prepares your order (performs the action
  based
  on
  your request).
- `Delivery (Response)`: The delivery person brings you your food (response) - the information you requested (pizza) or
  the
  confirmation of your new order (burger).

REST APIs work similarly, but instead of food, they deal with information on the web.

- **Resources**: Specific pieces of information, like a user profile, a product listing, or a news article.
- **Methods**: Different ways you tell the server what to do with the resource:
    - **GET**: Retrieve information (like reading the menu)
    - **POST**: Create new information (like placing your order)
    - **PUT**: Update existing information (like asking for extra cheese)
    - **DELETE**: Remove information (like canceling your order)
- **Server**: Stores the information (resources) and responds to your requests (orders) using the methods.
- **Response**: The information the server sends back after you make a request.

## Key Points

- **Simple and Universal**: Uses common methods like GET, POST, making it easy for programs to communicate.
- **Flexible**: Allows for retrieving, creating, updating, and deleting information.
- **Web-based**: Works through the internet, enabling communication between different programs and devices.

## Simple API E2E Flow

Flow Chart for Client-Server Interaction:

```plaintext
Client (User's Application)
└───> Send Request
      ├── User Action: [Action]
      ├── Method: [HTTP Method]
      └── Resource: [Target Information]
Server
└───> Receive Request
      ├── Interpret Method and Resource
      ├── Execute Action(Method)
      └── Send Response
       └── Response Data
Client (User's Application)
└───> Receive Response
      └── Display Data to User
```

Explanation of the Flow:

1. The Client (user's application) initiates the interaction by sending a Request to the Server.
   The Request contains three key elements:
    - User Action: What the user wants to do (e.g., view a user profile, create a new user).
    - Method: The type of action being requested (GET, POST, PUT, DELETE).
    - Resource: The specific piece of information being targeted (e.g., users, a specific user ID).
2. The Server receives the Request and interprets it based on the Method and Resource.
3. The Server accesses the Resource (e.g., retrieves user data from a database) and performs the action specified by the
   Method.
4. The Server sends a Response back to the Client.
5. The Response contains the data related to the requested action (e.g., the user profile information).
6. The Client receives the Response and displays the data to the user (e.g., shows the user profile on the screen).
