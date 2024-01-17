// Jenkinsfile

@Library('jenkins-shared-library') _
def COLOR_MAP = [
    'FAILURE' : 'danger',
    'SUCCESS' : 'good'
]
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

 /*           stage('SonarQube Analysis') {
                steps {
                    sonarAnalysis('your-project-key', 'Your Project Name', 'https://sonarqube.example.com', 'your-sonar-token')
                }
            }
            stage('SonarQube Quality Gate Check') {
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
            
        }

        post {
            always {
                slackSend(
                    channel: '#youtube-clone-deployment',
                    color: status == 'success' ? 'good' : 'danger',
                    message: "Job '${env.JOB_NAME} ${env.BUILD_NUMBER}' ${status}",
                    //tokenCredentialId: 'slack-token'
                )
            }
        }
*/
        post {
        always {
        echo 'Slack Notifications'
        slackSend (
            channel: '#channel name',   #change your channel name
            color: COLOR_MAP[currentBuild.currentResult],
            message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} \n build ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL}"
        )
    }
    }
    }
// Add more pipeline stages as needed
