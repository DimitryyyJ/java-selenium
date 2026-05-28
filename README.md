# Java Selenium Test Automation Project

This is a Java Selenium WebDriver project for automated testing of the SauceDemo web application.

## Technologies

* Java
* Selenium WebDriver
* Maven
* Page Object Model
* ChromeDriver

## Project Overview

The project follows the Page Object Model structure. Each page of the application is represented by a separate Java class, which makes the tests easier to read, maintain and extend.

## Tested Functionality

* User login
* Inventory page interactions
* Adding products to the cart
* Shopping cart verification
* Checkout form completion
* Order completion page verification
* Error message validation

## Project Structure

```text
src/
pom.xml
.gitignore
```

## How to Run

Clone the repository and run the tests with Maven:

```bash
mvn test
```

## Purpose

This project was created to practice test automation with Java and Selenium, including working with web elements, page classes, user actions and basic end-to-end testing flow.

