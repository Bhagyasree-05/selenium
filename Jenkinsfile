pipeline {
    agent any  // Jenkins lo ye node available unte automatic use chestundi

    triggers {
        pollSCM('* * * * *')  // Git push ayithe automatic trigger avuthundi
    }

    stages {

        stage('Checkout') {
            steps {
                // GitHub repo URL change cheyyandi ne repo URL ki
                git 'https://github.com/Bhagyasree-05/Calculator.git'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                dir('selenium-tests') {
                    // Maven test run cheyadam
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        success {
            echo '✅ All tests passed successfully!'
        }
        failure {
            echo '❌ Some tests failed! Check console output.'
        }
    }
}
