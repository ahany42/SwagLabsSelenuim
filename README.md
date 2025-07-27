# SwagLabs Selenium Test

This project is a structured Selenium automation framework using Java, TestNG, Maven, and Cucumber for BDD. It integrates Excel data handling, Log4j2 for logging, and Allure for detailed test reporting.

##  Project Structure

```bash
├── allure-report/                           # Allure generated HTML report
├── allure-results/                          # Allure raw result files
├── logs/
│   └── test-log.log                         # Log output from test runs
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           ├── LoginPage.java       # Page Object for Login
│   │   │           └── PurchasePage.java    # Page Object for Purchase
│   │   
│
│   └── test/
│       ├── java/
│       │   ├── BaseTest.java                # Base setup/teardown for tests
│       │   ├── ExcelReader.java             # Utility for reading Excel files
│       │   ├── LoginTestCase.java           # Login test scenarios
│       │   ├── ProductsTestCase.java        # Product-related test scenarios
│       │   ├── PropertiesUtil.java          # Config/property utility
│       │   └── PurchaseTestCase.java        # Purchase flow test cases
│       └── resources/
│           ├── log4j2.xml                   # Logging configuration
│           ├── ProfileData.xlsx             # Profile Data To Fill Purchase Form
│           ├── ProductData.xlsx             # Product To Purchase
│           └── test-config.properties       # Custom configuration
├── pom.xml                                  # Maven project config
└── testng.xml                               # TestNG suite definition
                    
```
## Technologies Used
Java 24
Selenium WebDriver 4.34.0
TestNG 7.11.0
Apache POI (poi-ooxml) 5.2.3
Cucumber Java 7.16.1
Log4j2 (log4j-core) 2.20.0
Allure TestNG 2.24.0
Maven Compiler Plugin 3.11.0
Maven Surefire Plugin 3.2.5

## Test Cases
### Login
- Validate that User cannot Login With Invalid User Name <br/>
- Validate that User cannot Login With Invalid Password <br/>
- Validate that User cannot Login With Invalid User Name and Password <br/>
- Validate that User cannot Login With Locked Account <br/>
- Validate that User cannot Login with empty User Name or Password <br/>
- Validate that User can Login With Valid Email and Password <br/><br/>

### Products
- Validate that User can View price Label for Each product <br/>
- Validate that User can View Add to cart button for each product <br/><br/>

### Purchase
- Validate that User can Add Item to Cart <br/>
- Validate that items in cart is increased by one <br/>
- Validate that User Can Fill Checkout Form <br/>
- Validate that User Can Finish purchase and Checkout <br/>

 
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
## Allure Reports
Generate Report
```bash
allure generate allure-results --clean -o allure-report
```
View Report
```bash
allure open allure-report
```
