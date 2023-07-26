# README for API Automation Challenge
## Pre-set
Before running this project, ensure you have the following pre-requisites set up:
- JDK 1.8 installed on your machine.
- Maven configured as an environment variable (M2_HOME) with the path to your JDK Java 1.8 installation.
- Make sure to include the Maven bin directory in your system PATH as %M2_HOME%\bin.# Installation Steps

# 1. Clone the Repository:
git clone https://github.com/christianLoyola10/API-Testing.git

# 2. Navigate to the Project Directory:
cd API-Testing

# 3. Build the Project:
mvn clean install

# 4. Run the Tests:
mvn test

# Execution
## To execute the tests in IDE, make sure to Run As "Junit Test" the following .java file.
src\test\java\com\apiautomationchallenge\cucumber\AppRunner.java
