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
        stage("Docker") {
            steps {
                sh 'docker run hello-world'
            }
        }
        stage("Echo") {
            steps {
                sh 'echo step'
            }
        }
    }
}