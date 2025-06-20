pipeline{
    agent any

//    tools {
//        jdk 'jdk-23'
//        maven 'M2_HOME'
//    }

    tools {
        dockerTool 'Docker'
    }

    stages {
        stage('Build') {
            steps {
                // bat "mvn clean install -DskipTests"
                bat "docker build -t rest-assured-cucumber ."
            }
        }

        stage('Test') {
            steps {
                script{
                    catchError(buildResult:'UNSTABLE',stageResult:'FAILURE') {
                        withCredentials([usernamePassword(
                                credentialsId:'REST_BOOKER_CREDS',
                                usernameVariable:'RESTBOOKER_USERNAME',
                                passwordVariable:'RESTBOOKER_PASSWORD'

                        )]) {

                            //bat "mvn test -P${profile}"
                            bat "docker run -v \$(pwd)/allure-results:/app/allure-results"+
                                    "-e RESTBOOKER_USERNAME -e RESTBOOKER_PASSWORD -e MAVEN_PROFILE=${profile} rest-assured-cucumber"
                        }
                    }
                }
            }
        }

        stage('Report') {
            steps{
                script
                        {
                            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                        }
            }

        }

    }
}