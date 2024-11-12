FROM openjdk:22
ADD target/Java-devOps.jar Java-devOps.jar
ENTRYPOINT ["java","-jar","/Java-devOps.jar"]