def call(String repoUrl, String branch = 'master') {
    
                    script {
                        checkout([$class: 'GitSCM',
                                  branches: [[name: "refs/heads/${branch}"]],
                                  userRemoteConfigs: [[url: repoUrl]]])
                    }
                }
       