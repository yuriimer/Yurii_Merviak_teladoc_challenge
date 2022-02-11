This repository contains selenium-cucumber-java test project.

Installation (pre-requisites)
JDK 1.8+ (make sure Java class path is set)
Maven (make sure .m2 class path is set)
Intellij idea or Eclipse
Maven
Cucumber
Clone repository or download zip and set it up in your local workspace.

Run Some Sample Tests
Open terminal (MAC OSX) or command prompt / power shell (for windows OS) and navigate to the project directory type mvn clean test command to run features.

To run features on specific browser use, mvn test "-Dbrowser=browser_name" browser_name can be one of following but make sure that browser’s driver file are present and specified in system variable. -- firefox -- chrome 

To run specific feature if you have multiple feature files use, mvn test -Dcucumber.options="src/test/resource/test-feature"
