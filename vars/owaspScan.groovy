// vars/owaspScan.groovy

def call(String reportPath = 'dependency-check-report.html') {
                    script {
                        def depCheckCmd = 'dependency-check.sh'
                        def reportDir = "${env.WORKSPACE}/${reportPath}"

                        sh """
                            ${depCheckCmd} \
                            --scan ${env.WORKSPACE} \
                            --project "My Project" \
                            --out ${reportDir} \
                            --format HTML \
                            --log dependency-check.log
                        """
                    }
                }