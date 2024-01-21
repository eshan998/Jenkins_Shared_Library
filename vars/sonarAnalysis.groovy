def call() {
 withSonarQubeEnv('sonar-server') {
                            sh """
                                sonar-scanner \
                                    -Dsonar.projectKey=youtube \
                                    -Dsonar.sources=. \
                                    -Dsonar.host.url=http://13.126.100.207:9000 \
                                    -Dsonar.login=jekins
                            """
                        }
                }
  //./gradlew sonarqube \  
 /* 
  def call() {
    withSonarQubeEnv('sonar-server') {
        sh ''' $SCANNER_HOME/bin/sonar-scanner \
                -Dsonar.projectName=youtube \
                -Dsonar.projectKey=youtube'''
    }
    }
 */