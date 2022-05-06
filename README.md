# Portfolio
port: 9001
This web-based application is designed to enable employees to submit reimbursement requests as well as view the status of their past requests.
It also allows Finance Managers to view all requests, filter them based on status, and evaluate pending requests.

ERS works by using html, javascript, and ajax to send http requests and receive http responses to/from a tomcat server using port 9001. The request is evauluated by a master servlet and dispatcher in JAVA. Depending on the type of request, it is sent to the controller layer which parses data from jsons and calls service layer methods which implement DAO layer methods used to interface with the database.
