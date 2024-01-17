// vars/dockerImagePipeline.groovy

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
