pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Bhagyasree-05/selenium.git'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                dir('selenium-tests') {
                    bat 'mvn test'
                }
            }
        }
    }

    post {
        success { echo '✅ All tests passed!' }
        failure { echo '❌ Some tests failed!' }
    }
}
