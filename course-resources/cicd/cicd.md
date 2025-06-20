# CI Setup for API Automation Tests

***

Table of Contents

* [Introduction](#introduction)
* [Prerequisites](#prerequisites)
* [Resources from the course](#resources-from-the-course)
* [Jenkins](#jenkins)
* [GitHub Actions](#github-actions)
* [Dockerization](#dockerization)
* [Conclusion](#conclusion)
* [References](#references)

***

## Introduction

***
In this section, we will learn how to setup CI for our API Automation tests. We will use Jenkins as our CI tool and
GitHub as our source code repository. We will create a Jenkins pipeline to run our tests on every push to the
repository.

## Prerequisites

***

* Jenkins installed on your machine
* GitHub account
* GitHub repository with your API Automation tests
* Docker installed on your machine

## Resources from the course

***

* [Jenkinsfile](https://github.com/ch-akash/qa-api-automation/blob/temp/Jenkinsfile)
* [Dockerfile](https://github.com/ch-akash/qa-api-automation/blob/temp/Dockerfile)
* [GitHub Actions Workflow](https://github.com/ch-akash/qa-api-automation/tree/temp/.github/workflows)

### Jenkins

***

Refer to the [Jenkins](jenkins.md) file for more details.

### GitHub Actions

***

Refer to the [GitHub Actions](github.md) file for more details.

### Dockerization

***

Dockerization has separate md file in the course repository. You can refer to the [docker.md](docker.md) file for more details.

## Conclusion

***

In this section, we learned how to setup CI for our API Automation tests. We used Jenkins as our CI tool and GitHub as
our source code repository. We created a Jenkins pipeline to run our tests on every push to the repository. We also
learned how to use GitHub Actions to run our tests. We dockerized our tests and ran them in a Docker container. We also
used Docker in our Jenkins pipeline to run our tests in a Docker container.

## References

***

* [Jenkins Pipeline](https://www.jenkins.io/doc/book/pipeline/)
* [GitHub Actions](https://docs.github.com/en/actions)
* [Using Docker with Jenkins Pipeline](https://www.jenkins.io/doc/book/pipeline/docker/)
* [Docker with Jenkins Pipeline - macOS Setup](https://www.jenkins.io/doc/book/pipeline/docker/#path-setup-for-mac-os-users)

***
