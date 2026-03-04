pipeline {
    agent any
    
    tools {
        maven "Maven3"
        jdk "JDK21"
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: '1b20d4cb-3555-40ad-a9f3-748a36edbc74', // ← your new credential ID
                    url: 'https: //github.com/bhavik-knight/5512-maven-assignment.git',
                    branch: 'main'
            }
        }

        stage('Verify Environment') {
            steps {
                sh '''
                    echo "JAVA_HOME: $JAVA_HOME"
                    echo "M2_HOME: $M2_HOME"
                    java -version
                    mvn -version
                '''
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            
            post {
                always {
                    // publish JUnit test results in Jenkins UI
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn clean package'
            }
        }
    }

    post {
        success { echo 'Build Successful ✅' }
        failure { echo 'Build Failed ❌' }
    }
}
