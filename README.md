![APP SMART](logo.png)

# PROJECT SUMMARY
* This project developed for App Smart GmbH 
* **[Java 11](https://openjdk.java.net/projects/jdk/11/)**  used as developing language
* **[Maven 3.8.4](https://maven.apache.org/docs/3.8.4/release-notes.html)** used as a build management tool
* **[Cucumber BDD](https://cucumber.io/)** used as a Framework
* Project support multi OS
* Project support different browsers, selenium grid and parallel testing
* For reporting was used "maven-cucumber-reporting plugin" version "5.0.0"
* Project was developed with **[Intellij IDEA](https://www.jetbrains.com/idea/)**
* You can find the task details on **[App Smart - Case Study](https://drive.google.com/file/d/1tPIg0R4WIEVG25v9qMIm2h3B20DCmST3/view?usp=sharing)**

# SUMMARY OF STRUCTURE
* Project was developed by using cucumber framework. There is 4 main title

    * src folder ==> contains test codes and feature files (main body of code structure)
        * src folder structure like the below
        
      ![structure](Capture.png)   
    
        * java folder contain main code structure and resource folder contain feature/scenario files
          * POM design pattern was used in JAVA folder
          * pages package ==> Page Object Model that contains definition of relevant of each different page
          * runners package ==> contains runner class for run the project
          * step definition ==> contains relevant each step codes
          * utilities ==> contains utility classes for test run
        * resource folder ==> contains feature/execution files for scenarios which has written gherkin.
    * configuration.properties ==> contains several options like browser and URLs that using in the project;
    * docker-compose.yml ==> provide using docker containers for selenium grid operations
    * pom.xml ==> contains dependencies, options, plugins that the project needs
* In additional, there is some detail tips in the relevant class for methods and classes

# TEST EXECUTION

* You must have relevant JAVA, maven, **[Google Chrome (latest version)](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)**
* Clone the project to your local
* If you want to run the test case with IDE you must to use cukesrunner class and just click the run button.

### Developed by Gokberk Kaan Uzun
#### contact@kaanuzun.com