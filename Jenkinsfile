@Library('OpenSlateProd')_  // https://github.com/openslate/jenkins-shared-library

deployWhen = { env.GIT_BRANCH == 'master' }

node {
    checkout scm
    def lastAuthor = getLastAuthor()
}

openslatePipeline {
    mentions = lastAuthor
    deployEnv = 'prod'
    publish = publishWhen
    deploy = deployWhen
}
