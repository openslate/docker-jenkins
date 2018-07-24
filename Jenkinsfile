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
            steps {
                withDockerRegistry([url: 'https://registry.osslabs.net', credentialsId: 'docker-oss']) {
                    cf 'prod', '--project-name $REPO_NAME deploy'
                }
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
