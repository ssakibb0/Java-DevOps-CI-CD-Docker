
1.first create the git repo of your project
2.install the Jenkins
3.start the Jenkins in the given port for Jenkins
4.create the new item in a Jenkins website
5.config your project into the Jenkins like give the url of GITHUB etc
6.then we have to set the pipeline instruction right-> there is an 2 way of writing this pipeline script one is on Jenkins website and second option is add the Jenkins file into your project with the set of instruction.
7.Now give the instruction what we have to do 
* set the global tool of maven and JAVA_HOME
* load the maven
* give the jdk path
* build the maven
I will provide the code also dont worry

pipeline {
    agent any
    tools {
        maven 'maven'  // Ensure Maven is configured in Jenkins Tool Configuration
    }
    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'  // Set your JDK path here
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"  // Update PATH to include JDK bin folder
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ssakibb0/Java-DevOps-CI-CD-Docker.git']])
                bat 'mvn clean install'  // Running Maven build on Windows using 'bat'
            }
        }
    }  
}


-> here we have completed the step of Jenkins now we need to add docker right ?
* First add the docker file into the project and push into the GitHub
* add the command for pull img of jdk then paste the jar file into the jdk then give the command how to run the project.
* After setup the docker file then came again to the Jenkins website 
* here u need to give the command what u want to do as we given above 
* build docker img then run that docker container or push that into the docker hub.
-> docker file -> 
FROM openjdk:22
ADD target/Java-devOps.jar Java-devOps.jar
ENTRYPOINT ["java","-jar","/Java-devOps.jar"]

then we need to build the img right 
* the pipeline script 
 stage('Build Docker image'){
            steps{
                script{
                    bat 'docker build -t sakib/java-devops .'
                }
            }
        }

it successfully build.

if u want to run then use the script ->
 stage('Run Docker image'){
            steps{
                script{
                    bat 'docker run -p 8080:8080 sakib/java-devops .'
                }
            }
        }

it will run your container. at 8080 port.

port 8080 running successfully.
