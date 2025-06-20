# Dockerisation for API Automation Tests

***

![Docker](../../assets/docker-logo-blue.png)

***

> Prerequisites
> * Docker installed on your machine. Make sure Docker is up and running.

## Introduction

***

Let's explore how we can run tests in a Docker container. You can create a Dockerfile in your project root
to build a Docker image. You can run the Docker container by using the Docker image.

## Install Docker Desktop

***

> Install Docker Desktop from [here](https://docs.docker.com/desktop/)
> Refer to the Dockerfile in the project root for more details.

## Docker with Jenkins pipeline

***

You can also use Docker in your Jenkins pipeline to run your tests in a Docker container. You can use the `docker` agent
in your Jenkinsfile to run your tests in a Docker container. You can also use Docker Compose to run your tests in a
container. You can find more details on Docker in the Docker documentation.

Plugins required for Docker in Jenkins:

* Docker Pipeline
* Docker Commons
* Docker Plugin

> Refer to the video lectures for more details on Docker with Jenkins.

## Docker Handy Commands

***

```bash

# Build Docker image
docker build -t <image-name> .

# Run Docker Image
docker run -it <image-name>

# List Docker images
docker images

# List Docker containers
docker ps -a

# Run Docker container
docker run -d --name <container-name> <image-name>

# Mount volume in Docker container
docker run -v <host-path>:<container-path> <image-name>:<tag> 

#Example 
docker run -v $(pwd)/target:/usr/app/target my-image:latest
```

***
