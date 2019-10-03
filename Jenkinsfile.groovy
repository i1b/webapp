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
        stage("Unit tests") {
            steps {
                sh 'mvn clean test'
            }
        }
        stage("Build project") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage("Build image") {
            steps {
                sh 'docker build -t webapp:dev .'
            }
        }
        stage("Run container") {
            steps {
                sh 'docker run -p 81:8080 webapp:dev'
            }
        }
    }
}