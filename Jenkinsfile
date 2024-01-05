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

        stage('Clean') {
            steps {
                bat 'mvn clean '
            }
        }

        stage('Test CustomerService') {
            steps {
                bat 'mvn test -Dtest=CustomerServiceImplTest'
            }
        }
        stage('Test ProductService') {
            steps {
                bat 'mvn test -Dtest=ProductServiceImplTest '
            }
        }
        stage('Test OrderService') {
            steps {
                bat 'mvn test -Dtest=OrderServiceImplTest'
            }
        }
        stage('Test mvn') {
            steps {
                bat 'mvn -v'
            }
        }
    }

    post {
        success {
            echo 'Test succeeded!'

        }

        failure {
             echo 'Test failed!'
        }
    }
}