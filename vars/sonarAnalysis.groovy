/*def call(String projectKey, String projectName, String sonarHostUrl, String sonarToken) {

                    script {
                        withSonarQubeEnv('sonar-server') {
                            sh """
                                $SCANNER_HOME/bin/sonar-scanner \
                                -Dsonar.projectKey=${projectKey} \
                                -Dsonar.projectName=${projectName} \
                                -Dsonar.host.url=${sonarHostUrl} \
                                -Dsonar.login=${sonarToken}
                            """
                        }
                    }
                }
  //./gradlew sonarqube \  
  */
  def call(String projectKey, String projectName) {
    script{
    withSonarQubeEnv('sonar-server') {
        sh ''' $SCANNER_HOME/bin/sonar-scanner \
                -Dsonar.projectName=${projectName} \
                -Dsonar.projectKey=${projectKey} '''
    }
    }
}
