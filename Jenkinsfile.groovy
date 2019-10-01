properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label 'master'
    }
    triggers {
        pollSCM('* * * * *')
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
    }
}