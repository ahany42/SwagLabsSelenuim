# SwagLabs Selenium Test Automation Framework

This project is a structured Selenium automation framework using Java, TestNG, Maven, and Cucumber for BDD. It also integrates Excel data handling and Log4j2 for logging.

##  Project Structure

```bash
├── logs
│   └── test-log.log                         # Log output from test runs
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── example
│   │   │           ├── LoginPage.java       # Page Object for Login
│   │   │           └── PurchasePage.java    # Page Object for Purchase
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── BaseTest.java                # Base setup/teardown for tests
│       │   ├── ExcelReader.java             # Utility for reading Excel files
│       │   ├── LoginTestCase.java           # Login test scenarios
│       │   ├── ProductsTestCase.java        # Product-related test scenarios
│       │   ├── PropertiesUtil.java          # Config/property utility
│       │   └── PurchaseTestCase.java        # Purchase flow test cases
│       └── resources
│           ├── features
│           │   ├── login.feature            # BDD feature for login
│           │   ├── LoginSteps.java          # Step definitions for login
│           │   ├── purchase.feature         # BDD feature for purchase
│           │   └── PurchaseSteps.java       # Step definitions for purchase
│           ├── log4j2.xml                   # Logging configuration
│           ├── ProfileData.xlsx             # Test data file
│           └── test-config.properties       # Custom configuration
├── pom.xml                                  # Maven project config
└── testng.xml                               # TestNG suite definition
```
## Technologies Used
Java	24	
Selenium WebDriver	4.34.0	
TestNG	7.11.0	
Apache POI (poi-ooxml)	5.2.3	
Cucumber Java	7.16.1	
Log4j2 (log4j-core)	2.20.0
Maven Compiler Plugin	3.11.0
Maven Surefire Plugin	3.2.5

 ## How to Run
```bash
git clone https://github.com/your-username/SwagLabs.git
cd SwagLabs
```
```bash
mvn clean install
Run the tests
```
```bash
mvn test
```
