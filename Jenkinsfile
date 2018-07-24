@Library('OpenSlateProd')_  // https://github.com/openslate/jenkins-shared-library

def cfDeploy(String environ) {
    withDockerRegistry([url: 'https://registry.osslabs.net', credentialsId: 'docker-oss']) {
        sh "compose-flow -e {environ} --config-name ${environ}-${env.REPO_NAME} --project-name ${env.REPO_NAME} publish"
        sh "compose-flow -e {environ} --config-name ${environ}-${env.REPO_NAME} --project-name ${env.REPO_NAME} deploy"
    }
}

pipeline {
    agent any
    environment {
        REPO_NAME = getRepoName()
        LAST_AUTHOR = getLastAuthor()
    }
    stages {
        stage('Deploy') {
            agent {
                label 'manager'
            }
            when {
                branch 'master'
            }
            steps {
                cfDeploy 'prod'
            }
            post {
                success {
                    slackSuccess()
                }
                failure {
                    slackFailure env.LAST_AUTHOR
                }
            }
        }
    }
}
