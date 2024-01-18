// vars/sonarQualityGate.groovy

def call(String credentialsId) {
    waitForQualityGate abortPipeline: false, credentialsId: credentialsId   
}

