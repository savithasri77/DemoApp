pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Clean and build the project using Maven
		    maven: '/home/labuser/Downloads/apache-maven-3.9.9/bin' 
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run tests
                    sh 'mvn test'
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    // Package the application
                    sh 'mvn package'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Deploy the application (this is just an example, adjust as needed)
                   // sh 'scp target/demo-0.0.1-SNAPSHOT.jar user@server:/path/to/deploy'
                   sh "echo 'Iam in Deploy Stage'"
                }
            }
        }
    }
}
