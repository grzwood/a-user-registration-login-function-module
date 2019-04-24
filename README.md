# a-user-registration-login-function-module
Using JSP + Servlet + JavaBean technology, build a user registration login function module based on MVC mode.
Implement user registration
a) Implementation of View in MVC (jsp file)
1. Create a user registration page (register.jsp) using JSP: The page contains all the user fields identified in 1, and the registration information is submitted to the server for processing via the form.
2. Complete the data validity verification of the registration information: Add the processing of the validity verification of the submitted data in the user registration page. The password is required to be 6-8 digits and must consist of letters and numbers.
3. Create a user registration success page (register_success.jsp) using JSP: Give a successful login prompt.
4. Use JSP to create a user registration failure page (register_failure.jsp): Give a registration failure prompt.
b) Implementation of Model in MVC (JavaBean)
1. Create a database connection bean (DB_Conn.java) using JDBC: encapsulates the ability to establish a connection to the database and release the connection.
2. Create a User Bean (User.java) using JavaBean: Encapsulate all user fields.
3. Create a user database operation bean (DB_User.java) using JavaBean: encapsulate the addition, deletion, modification, and checking operations on the user information table.
c) Implementation of the Controller in MVC (Servlet)
1. Use the Servlet to create a user registration processing Servlet (RegProc.java): implement the user registration page control function, first verify that the user is unique, the only one is stored in the database and jump to the registration success page, otherwise jump to the registration failure page. When the database fails, it also jumps to the registration failure page.
