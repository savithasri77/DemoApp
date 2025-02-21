pipeline {
    agent any

    stages {
        stage('Build') {
			steps {
				script {
            //def mvnHome = tool name: 'Apache Maven 3.9.9', type: 'maven'
   			sh "/home/labuser/Downloads/apache-maven-3.9.9/bin/mvn -B -DskipTests clean install"
   			}
   		 }
        }
        stage('Test') {
            steps {
                script {
                    // Run tests
                    //def mvnHome = tool name: 'Apache Maven 3.9.9', type: 'maven'
   					sh "/home/labuser/Downloads/apache-maven-3.9.9/bin/mvn -B -DskipTests test"
                    //sh 'mvn test'
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    // Package the application
                    //def mvnHome = tool name: 'Apache Maven 3.9.9', type: 'maven'
   					sh "/home/labuser/Downloads/apache-maven-3.9.9/bin/mvn -B -DskipTests clean package"
                    //sh 'mvn package'
                }
            }
        }
        stage('Deploy') {
            steps {
                // Assuming you are using AWS CodeDeploy
                withCredentials([credentials(id: '5633-4389-5413', type: 'AmazonWebServicesCredentialsBinding')]) {
                    codeDeploy(
                        applicationName: 'DemoAoo', 
                        deploymentGroupName: 'DemoApp-deployment-group', 
                        deploymentConfigName: 'CodeDeployDefault.AllAtOnce',
                        computePlatform: 'Server', 
                        s3Location: 's3://elasticbeanstalk-us-east-1-563343895413/DemoApp.zip' // Replace with your S3 bucket and deployment artifact
                    )
                }
            }
        }
    }
}
