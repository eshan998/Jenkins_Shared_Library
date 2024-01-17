// vars/kubeDeployPipeline.groovy

def call(String kubeConfig, String namespace, String deploymentName, String containerName, String imageTag) {
    pipeline {
        agent any

        environment {
            KUBECONFIG = kubeConfig
        }

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Deploy to Kubernetes') {
                steps {
                    script {
                        sh "kubectl config use-context ${kubeConfig}"
                        sh "kubectl apply -f kube-manifests/${deploymentName}-deployment.yaml --namespace=${namespace}"

                        // Update the deployment with the new image tag
                        sh "kubectl set image deployment/${deploymentName} ${containerName}=${deploymentName}:${imageTag} --namespace=${namespace}"

                        // Wait for the deployment to rollout
                        sh "kubectl rollout status deployment/${deploymentName} --namespace=${namespace}"
                    }
                }
            }

            // Add more stages as needed
        }
    }
}
