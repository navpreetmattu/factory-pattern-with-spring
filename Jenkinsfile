pipeline {
    agent any
     tools {
         maven "M2_HOME"
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
