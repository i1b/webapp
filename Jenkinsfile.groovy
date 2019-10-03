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
        stage("Project build") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage("Image build ") {
            steps {
                sh 'docker build .'
            }
        }
    }
}