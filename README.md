This project Demonstrate how to execute the UI automation test scripts for Entrata website in Java with Selenium WebDriver .

Prerequisites: Java Development Kit (JDK) 11: Ensure you have JDK installed
Maven: This project uses Maven for dependency management
IDE: IDE like IntelliJ can be used


**Setting Up the Project**

Clone the Repository with following command on terminal: git clone https://github.com/BhagyashreeSSathe/entrata-automation/tree/master 

To execute all the tests run the following command mvn verify or mvn clean install

Run Individual test file from src/test/java/Tests

OR

Run XML file from src/resources/testng.xml

**Test Scenarios covered**
1>> EntraDemo test File

  1. Validate Home Page Title 
  2.Accept Cookies
  3.Schedule a Demo
  4. Fill demo Form

2>> EntrataTests

 1. Validate Home Page Title 
 2.Accept Cookies
 3.Navigate to Pages from dropdown and come back
 4. Validate Login Button present
 5. Check Broken links present 

**Note for Evaluator**
1.As time was short I could cover very few scenarios. (busy with production support  )
2.For Designing Initial approach for framework was Page Object Model but scripts were giving errors so at run time created just test files. But I have thorough knowledge of POM 
3.For Data driven testing Plans were for Excel readers, somehow the data is not read
For reporting tried Extent Reports, but unfortunately it is not working, Tried Allure report too and Surefire plugin(but It only support Junit) . So just added Screenshot code for single page

