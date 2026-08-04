# LAB 01: JAVA SE CONSOLE APPLICATION WITH MAVEN

Học phần: Công nghệ Java (IT3242)
Trường Đại học Công nghệ Đông Á (EAUT)

## Structure
- `pom.xml`: Maven configuration file
- `src/main/java/vn/edu/eaut/lab1/So.java`: Class containing business logic methods for 5 exercises
- `src/main/java/vn/edu/eaut/lab1/App.java`: Main class with Console Menu interface

## Build & Run Instructions
1. Check Java & Maven environment:
   java -version
   javac -version
   mvn -version

2. Compile:
   mvn clean compile

3. Package into executable JAR:
   mvn clean package

4. Run executable JAR:
   java -jar target/lab01-java-console-1.0-SNAPSHOT.jar
