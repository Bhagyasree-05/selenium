pipeline {
    agent any

    triggers {
        pollSCM('* * * * *') // Git push trigger
    }

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
                    bat 'mvn test'  // Windows CMD, Linux use sh
                }
            }
        }
    }

    post {
        success { echo '✅ All tests passed!' }
        failure { echo '❌ Some tests failed!' }
    }
}
