// Jenkinsfile

@Library('jenkins-shared-library') _

/*


cleanWorkspace()

gitCheckout('https://github.com/yourusername/your-repo.git', 'main')

sonarAnalysis('your-project-key', 'Your Project Name', 'https://sonarqube.example.com', 'your-sonar-token')

sonarQualityGate('your-project-key', 'https://sonarqube.example.com', 'your-sonar-token')

installDependency()

owaspScan(reportPath: 'custom-report-path.html')

trivyfs()

dockerImagePipeline('your-docker-image-name', 'your-image-tag', 'path/to/Dockerfile')

trivyimage()

deploytoContainer()

kubeDeployPipeline('path/to/kubeconfig', 'your-namespace', 'your-deployment-name', 'your-container-name', 'your-image-tag')

def checkSonarQualityGate(String projectKey, String sonarHostUrl, String sonarToken) {
    def apiUrl = "${sonarHostUrl}/api/qualitygates/project_status?projectKey=${projectKey}"
    def response = httpRequest(url: apiUrl, httpMode: 'GET', authentication: 'sonarqube', token: sonarToken)

    // Parse the JSON response
    def json = readJSON text: response

    return json.projectStatus.status
}
*/
pipeline {
        agent any

        environment{
            SCANNER_HOME=tool 'sonar-scanner'
        }

        stages {
            stage('cleanWorkspace') {
                steps {
                    cleanWorkspace()
                }
            }

            stage('gitCheckout') {
                steps {
                    gitCheckout('https://github.com/Aj7Ay/Youtube-clone-app.git', 'main')
                }
            }
/*
          stage('SonarQube Analysis') {
                steps {
                   // sonarAnalysis('your-project-key', 'Your Project Name', 'https://sonarqube.example.com', 'your-sonar-token')
                    sonarAnalysis('youtube', 'youtube', 'http://13.201.137.11:9000', 'sonar-token')
                }
            }
*/
            stage('SonarQube Analysis') {
                steps {
                   // sonarAnalysis('your-project-key', 'Your Project Name', 'https://sonarqube.example.com', 'your-sonar-token')
                    sonarAnalysis()
                }
            }
            stage('SonarQube Quality Gate Check') {
                steps {
                   // sonarAnalysis('your-project-key', 'Your Project Name', 'https://sonarqube.example.com', 'your-sonar-token')
                    sonarQualityGate('sonar-token')
                }
            }
  /*            stage('SonarQube Quality Gate Check') {
                steps {
                    sonarQualityGate('your-project-key', 'https://sonarqube.example.com', 'your-sonar-token')
                }
            }
            stage('installDependency') {
                steps {
                    installDependency()
                }
            }
            stage('OWASP Dependency-Check') {
                steps {
                    owaspScan(reportPath: 'custom-report-path.html')
                }
            }
            stage('trivyfs Scan') {
                steps {
                    trivyfs()
                }
            }
            stage('dockerImagePipeline') {
                steps {
                    dockerImagePipeline('your-docker-image-name', 'your-image-tag', 'path/to/Dockerfile')
                }
            }
            stage('trivyimage Scan') {
                steps {
                    trivyimage()
                }
            }

            stage('deploytoContainer') {
                steps {
                    deploytoContainer()
                }
            }
            stage('kubeDeployPipeline') {
                steps {
                    kubeDeployPipeline('path/to/kubeconfig', 'your-namespace', 'your-deployment-name', 'your-container-name', 'your-image-tag')
                }
            }
 */       
 // Add more pipeline stages as needed    
        }

/*
def COLOR_MAP = [
    'FAILURE' : 'danger',
    'SUCCESS' : 'good'
]
        post {
        always {
        echo 'Slack Notifications'
        slackSend (
            channel: '#youtube-clone-deployment',
            color: COLOR_MAP[currentBuild.currentResult],
            message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} \n build ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL}"
        )
        }
    }
*/
    post {
            success {
                // Send success notification to Slack
                slackSend(
                    channel: '#youtube-clone-deployment',
                    color: 'good',
                    message: "Job: ${env.JOB_NAME} \n Build: ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL} *succeeded*",
                    //tokenCredentialId: 'your-slack-credentials-id'
                )
            }

            failure {
                // Send failure notification to Slack
                slackSend(
                    channel: '#youtube-clone-deployment',
                    color: 'danger',
                    message: "Job: ${env.JOB_NAME} \n Build: ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL} *failed*",
                    //tokenCredentialId: 'your-slack-credentials-id'
                )
            }
        }
}

