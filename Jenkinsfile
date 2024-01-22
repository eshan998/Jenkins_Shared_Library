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
        tools{
            nodejs 'node16'
            jdk 'jdk17'
        }

        stages {
            stage('cleanWorkspace') {
                steps {
                    cleanWorkspace()
                }
            }

            stage('gitCheckout') {
                steps {
                    gitCheckout('https://github.com/eshan998/youtube-clone-app.git', 'main')
                }
            }

  /*         stage('SonarQube Analysis') {
                steps {
                   // sonarAnalysis('your-project-key', 'Your Project Name')
                    sonarAnalysis()
                }
            }
            stage('SonarQube Quality Gate Check') {
                steps {
                   // sonarQualityGate('your-sonar-token')
                    sonarQualityGate('sonar-token')
                }
            }
            stage('installDependency') {
                steps {
                    installDependency()
                }
            }
           stage('OWASP Dependency-Check') {
                steps {
                    dependencyCheck additionalArguments: '--scan ./ --disableYarnAudit --disableNodeAudit', odcInstallation: 'DP-Check'
                    dependencyCheckPublisher pattern: '**dependency-check-report.xml'
                }
            }
           
            stage('trivyfs Scan') {
                steps {
                    sh 'trivy fs . > trivyfs.txt'
                
                }
            }
  */          stage('dockerImagePipeline') {
                steps {
                    dockerImagePipeline('eshan3312', 'youtube')
                }
            }
   /*         stage('trivyimage Scan') {
                steps {
                    sh 'trivy image eshan3312/youtube:latest > trivyimage.text'
                }
            }

            stage('deploytoContainer') {
                steps {
                    deploytoContainer()
                }
            }
   */           stage('kubeDeployPipeline') {
                steps {
                    kubeDeployPipeline()
                }
            }
     
 // Add more pipeline stages as needed    
        }

    post {
            success {
                // Send success notification to Slack
                slackSend(
                    channel: '#youtube-test-lab',
                    color: 'good',
                    message: "Job: ${env.JOB_NAME} \n Build: ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL} *succeeded*",
                    //tokenCredentialId: 'your-slack-credentials-id'
                )
            }

            failure {
                // Send failure notification to Slack
                slackSend(
                    channel: '#youtube-test-lab',
                    color: 'danger',
                    message: "Job: ${env.JOB_NAME} \n Build: ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL} *failed*",
                    //tokenCredentialId: 'your-slack-credentials-id'
                )
            }
        }
}

