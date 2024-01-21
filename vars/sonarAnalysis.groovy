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
  def call() {
    withSonarQubeEnv('sonar-server') {
        sh ''' $SCANNER_HOME/bin/sonar-scanner \
                -Dsonar.projectName=youtube \
                -Dsonar.projectKey=youtube'''
    }
    }
