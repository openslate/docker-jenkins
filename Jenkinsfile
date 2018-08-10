@Library('OpenSlateProd')_  // https://github.com/openslate/jenkins-shared-library

def deployWhen = { env.GIT_BRANCH == 'master' }

def lastAuthor
node {
    checkout scm
    lastAuthor = getLastAuthor()
}

openslatePipeline {
    mentions = lastAuthor
    deployEnv = 'prod'
    publish = deployWhen
    deploy = deployWhen
}
