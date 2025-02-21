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
                steps {
                // Assuming you are using AWS CodeDeploy
                script {
                    // Access AWS credentials (ensure properly configured in Jenkins)
                    def awsCredentials = credentials('aws-access-key') 
                    
                    // Execute CodeDeploy deployment command
                    sh "aws codedeploy deploy-application-revision --application-name Demo --deployment-group-name DemoDeploymentGroup --revision-number $(ls -l target/Demo.jar | awk '{print $NF}') --s3-location s3://elasticbeanstalk-us-east-1-563343895413/demo.jar --region us-east-1 --credentials sridhar.savitha@wipro.com:${awsCredentials.password}"
                }
            }

            }
        }
    }
}
