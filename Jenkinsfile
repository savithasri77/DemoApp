pipeline {
    agent any

    stages {
        stage('Build') {
			steps {
				script {
            //def mvnHome = tool name: 'Apache Maven 3.9.9', type: 'maven'
   			sh "/home/labuser/Downloads/apache-maven-3.9.9/bin/mvn clean install"
   			}
   		 }
        }
        stage('Test') {
            steps {
                script {
                    // Run tests
                    def mvnHome = tool name: 'Apache Maven 3.9.9', type: 'maven'
   					sh "${mvnHome}/bin/mvn test"
                    //sh 'mvn test'
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    // Package the application
                    def mvnHome = tool name: 'Apache Maven 3.9.9', type: 'maven'
   					sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
                    //sh 'mvn package'
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
