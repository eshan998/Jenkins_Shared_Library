// vars/dockerImagePipeline.groovy
 /* 
def call(String imageName, String imageTag, String dockerfilePath) {
  pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Build Docker Image') {
                steps {
                    script {
                        docker.build("${imageName}:${imageTag}", "-f ${dockerfilePath} .")
                    }
                }
            }

            stage('Push Docker Image to Docker Hub') {
                steps {
                    script {
                        withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                                docker.image("${imageName}:${imageTag}").push()
                            }
                        }
                    }
                }
            }

            // Add more stages as needed
        }
    }
    }
*/
def call(String dockerHubUserName, String imageName) {
                sh "docker build --build-arg REACT_APP_RAPID_API_KEY=bc2ae202fdmshfb9233XXXXX -t ${imageName} ."
                sh "docker tag ${imageName} ${dockerHubUserName}/${imageName}:latest"
                withDockerRegistry([url:'https://index.docker.io/v1/', credentialsId: 'docker']){
                    sh "docker push ${dockerHubUserName}/${imageName}:latest"
                }




}
