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
                script {
                    withAWS(region: 'us-east-1', credentials: 'aws-credentials-id') {
                        s3Upload(bucket: 'elasticbeanstalk-us-east-1-563343895413', path: 'your-s3-bucket-path', includePathPattern: '**/*')
                    }
                
        }
    }

