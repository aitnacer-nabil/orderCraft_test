pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
              git branch: 'jenkins', url: 'https://github.com/aitnacer-nabil/orderCraft_test'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn compile test'
            }
        }

    }

    post {
        success {
            echo 'Build succeeded!'

        }

        failure {
             echo 'Build failed!'
        }
    }
}