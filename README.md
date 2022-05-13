# Expense Reimbursement System

## Project Description

This web-based application is designed to enable employees to submit reimbursement requests as well as view the status of their past requests. It also allows Finance Managers to view all requests, filter them based on status, and evaluate pending requests.

## Technologies Used

* Java - version 14.0.2
* Maven - version 3.8.5
* PostgreSQL - version 13.6-2
* DBeaver - version 22.0.4
* VS Code - version 1.65.2
* Spring Tools Suite 3 - version 3.9.16

## Features

* Uses html, javascript, and ajax to send http requests and receive http responses to/from a tomcat server using port 9001.
* The request is evauluated by a master servlet and dispatcher in JAVA.
* Depending on the type of request, it is sent to the controller layer which parses data from jsons and calls service layer methods which implement DAO layer methods used to interface with the database.

To-do list:
* Implement look-up tables in the database to reduce number of queries when retrieving reimbursement request.

## Getting Started

- git clone https://github.com/Maplesushi/Portfolio.git
- Environment Varaibles should be setup as follows:
  - In windows, Edit the system environment variables by typing Edit the system environment variables into the windows search field and pressing enter.
  - Select the "Environment Varaibles..." button
  - Select "New..." button under System variables
  - Create an "AWS_URL" variable with the value containing the URL:Port of the database to be connected to.
  - Select "New..." button under System variables
  - Create an "DB_USER" variable with the value containing the username of the database to be connected to.
  - Select "New..." button under System variables
  - Create an "DB_PASS" variable with the value containing the password of the database to be connected to.

## Usage

> Once installed, Use STS3 to launch the TomCat server on port 9001. Open up a web browser and navigate to http://localhost:9001/index.html/
> Accounts must be created in the databse before a login can occur. Run Project-1-ERS-model.sql in DBeaver to create the table

## Contributors

> Dillon Meier
