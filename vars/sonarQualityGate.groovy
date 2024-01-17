// vars/sonarQualityGate.groovy

def call(String projectKey, String sonarHostUrl, String sonarToken) {

                    script {
                        def qualityGateStatus = checkSonarQualityGate(projectKey, sonarHostUrl, sonarToken)
                        echo "SonarQube Quality Gate Status: ${qualityGateStatus}"

                        if (qualityGateStatus != 'OK') {
                            error "Quality gate did not pass. Build failed."
                        }
                    }
                }


