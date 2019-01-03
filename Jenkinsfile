@Library('OpenSlateProd')_  // https://github.com/openslate/jenkins-shared-library

def deployWhen = { env.GIT_BRANCH == 'master' }

def customDeployFunction = { cfDeployRancher() }

def lastAuthor
node {
    checkout scm
    lastAuthor = getLastAuthor()
}

openslatePipeline {
    mentions = lastAuthor
    deployEnv = 'staging'
    deploy = deployWhen
    deployFunction = customDeployFunction
}
