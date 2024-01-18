def call(String projectKey, String projectName, String sonarHostUrl, String sonarToken) {

                    script {
                        withSonarQubeEnv('sonar-server') {
                            sh """
                                ./gradlew sonarqube \
                                -Dsonar.projectKey=${projectKey} \
                                -Dsonar.projectName=${projectName} \
                                -Dsonar.host.url=${sonarHostUrl} \
                                -Dsonar.login=${sonarToken}
                            """
                        }
                    }
                }
    