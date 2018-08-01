@Library('OpenSlateProd')_  // https://github.com/openslate/jenkins-shared-library

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
            environment {
                DEPLOY_ENV = 'prod'
            }
            steps {
                cfPublish()
                cfDeploy()
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
