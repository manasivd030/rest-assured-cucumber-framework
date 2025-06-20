# Jenkins Pipeline for API Automation Tests

***

![Jenkins](https://www.jenkins.io/images/logos/oktoberfest/oktoberfest.png)

***

Table of Contents

* [Introduction](#introduction)
* [Install Jenkins](#install-jenkins)
* [Plugin Installation](#plugin-installation)
* [Create a new Jenkins job](#create-a-new-jenkins-job)
* [Jenkinsfile Pipeline with Jenkinsfile](#jenkinsfile-pipeline-with-jenkinsfile)
* [Run Jenkins job](#run-jenkins-job)
* [Reports](#reports)
* [IDE Setup for Jenkins](#ide-setup-for-jenkins)

> Prerequisites
>
> * Jenkins Installed, Up and running
> * Admin level access to manage Jenkins
> * Valid GitHub Access Token

## Introduction

***

In this section, we will learn how to set up CI for our API Automation tests. We will use Jenkins as our CI tool and
GitHub as our source code repository. We will create a Jenkins pipeline to run our tests on every push to the
repository.

### Install Jenkins

You can install Jenkins based on the OS from this [link](https://www.jenkins.io/doc/book/installing/)

### Plugin Installation

***

You need to install the following plugins in Jenkins to run your tests:

* Allure Jenkins Plugin
* Maven Integration plugin
* Jenkins HTML Publisher

### Create a new Jenkins job

1. Open Jenkins in your browser by going to `http://localhost:8080/`
2. Click on `New Item`
3. Enter a name for your project and select `Pipeline` as the project type
4. Click on `OK`
5. Scroll down to the `Pipeline` section
6. In the `Definition` dropdown, select `Pipeline script from SCM`
7. In the `SCM` dropdown, select `Git`
8. Enter the URL of your GitHub repository in the `Repository URL` field
9. Click on `Save`. Please add your GitHub credentials if prompted.

> Note: You can use your GitHub personal access token as the password. Read more about
> it [here](https://docs.github.com/en/github/authenticating-to-github/creating-a-personal-access-token)

### Jenkinsfile Pipeline with Jenkinsfile

***

You can create Jenkinsfile by using pipeline syntax generator. You can find it at your localhost Jenkins
URL [pipeline-syntax](http://localhost:8080/pipeline-syntax/). You can generate the pipeline script by selecting the
options from the dropdowns.

The Jenkinsfile from course lectures is available in the repository at project root.

Additionally, you can parameterize your Jenkins job by adding parameters in the Jenkinsfile. You can add parameters
like `suiteXmlFile`, `tags`, etc. to run specific tests. For doing this, you can choose `This project is parameterized`
option in the Jenkins job configuration. Use the `String Parameter` option to add parameters. For reading these
parameters in the Jenkinsfile, you can use the `params` object or use the parameter name directly. For
example, `params.suiteXmlFile` or `$suiteXmlFile`.

> We have covered the Jenkins setup in the course lectures. You can refer to the lectures for more details.

#### Run Jenkins job

***

1. Click on `Build with Parameters`
2. Enter the parameters if you have added any
3. Click on `Build`

## Reports

***

You can view the reports in Jenkins by clicking on the `Allure Report` link in the Jenkins job. You can also view the
console output to see the test results.

## References

***

[Jenkins Credentials Binding Plugin](https://www.jenkins.io/doc/pipeline/steps/credentials-binding/#withcredentials-bind-credentials-to-variables)
[Jenkins Pipeline Syntax](https://www.jenkins.io/doc/book/pipeline/syntax/)

## IDE Setup for Jenkins

* [Jenking Syntax Highlighting](https://stackoverflow.com/questions/47796757/jenkinsfile-syntax-highlighting-in-java-project-using-intellij-idea)

***
