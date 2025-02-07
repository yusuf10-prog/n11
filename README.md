# N11 Test Automation Project

This project contains automated tests for the N11 e-commerce website using Selenium WebDriver, Cucumber, and Java.

## Features
- Page Object Model design pattern
- Cucumber BDD scenarios
- Allure reporting
- Fake data generation using JavaFaker
- Screenshot capture on test failure

## Prerequisites
- Java 11 or higher
- Maven
- Firefox browser
- Allure command-line tool (optional, for viewing reports)

## Project Structure
```
src
├── test
│   ├── java
│   │   ├── pages
│   │   │   ├── BasePage.java
│   │   │   ├── N11HomePage.java
│   │   │   └── N11LoginPage.java
│   │   ├── runners
│   │   │   └── TestRunner.java
│   │   └── stepdefinitions
│   │       ├── N11NavigationSteps.java
│   │       └── N11LoginSteps.java
│   └── resources
│       ├── features
│       │   ├── n11Navigation.feature
│       │   └── n11Login.feature
│       └── allure.properties
```

## Running Tests
To run all tests:
```bash
mvn clean test
```

To run a specific feature:
```bash
mvn test -Dtest=runners.TestRunner -Dcucumber.features="src/test/resources/features/n11Login.feature"
```

## Generating Allure Reports
After running the tests, generate and open the Allure report:
```bash
allure serve target/allure-results
```

## Test Scenarios
1. Navigation Test
   - Navigate to N11 homepage
   - Click through all menu items
   - Scroll to bottom of page

2. Login Test with Fake Credentials
   - Navigate to login page
   - Enter randomly generated credentials
   - Verify error message

## Contributing
Feel free to fork this repository and submit pull requests.
