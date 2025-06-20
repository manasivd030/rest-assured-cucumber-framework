# GitHub Actions for CI

***

![GitHub Actions](https://github.githubassets.com/images/modules/site/social-cards/actions.png)

***

## Introduction

***

You can also use GitHub Actions to run your tests. You can create a workflow file in your GitHub repository to run your
tests on every push to the repository. You can find more details on GitHub Actions in the GitHub documentation. You can
create a new workflow from GitHub repository by going to `Actions` tab in your repository.

Choose Java with Maven template to create a workflow file. You can customize the workflow file as per your requirements.

Sample GitHub Actions workflow file for Maven and JDK 21(For reference only):

```yaml
name: Java CI with Maven

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
    build:
    
        runs-on: ubuntu-latest
    
        steps:
        - uses: actions/checkout@v2
        - name: Set up JDK 21
        uses: actions/setup-java@v2
        with:
            distribution: 'temurin'
            java-version: '21'
        - name: API Tests with Maven
        run: mvn clean test -q
        - name: Upload Artifact
        uses: actions/upload-artifact@v4
        with:
            name: allure-reports
            path: allure-reports/
    ```
