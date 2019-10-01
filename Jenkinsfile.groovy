properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label 'master'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage("Step 1") {
            steps {
                sh 'echo step 1'
            }
        }
        stage("Step 2") {
            steps {
                sh 'echo step 2'
            }
        }
    }
}