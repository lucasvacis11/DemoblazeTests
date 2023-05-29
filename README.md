# DemoblazeTests
This project is a Selenium WebDriver test automation suite for the Demoblaze website, an example e-commerce site. The tests are written in Java and use the TestNG testing framework.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
To run the tests, you will need:

Java Development Kit (JDK)
Maven
A Selenium WebDriver compatible browser installed (the tests are currently configured to run on Chrome)
### Installing
1. Clone this repository to your local machine using git clone https://github.com/lucasvacis11/DemoblazeTests.git.

2. Navigate to the directory where the project was cloned.

3. Run mvn clean install to install the required dependencies.

### Running the tests
To run the tests, use the command mvn test.

## Project Structure
The src/main/java/com/demoblaze/Pages directory contains Page Object Model (POM) classes for each page of the Demoblaze website. These classes define the interactions with the web pages.

The src/test/java/com/demoblaze/Tests directory contains the TestNG test classes. These classes use the page classes to define the tests.

The BaseTest.java class in src/test/java/com/demoblaze sets up and tears down the WebDriver for each test.

## Built With
Selenium - Web browser automation
TestNG - Testing framework
Maven - Dependency Management

## Contributing
Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.

## Authors
Lucas Vacis - Initial work
