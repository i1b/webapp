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
        stage("Maven") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage("Docker") {
            steps {
                sh 'docker build .'
            }
        }
    }
}