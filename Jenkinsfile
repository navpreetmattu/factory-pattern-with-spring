pipeline {
    agent any
     tools {
        maven 'Maven 3.6.3'
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn -DskipTests clean package'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
