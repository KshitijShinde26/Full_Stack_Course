<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Submit Form</title>
</head>
<body>
Submit Form</br>
<jsp:useBean id="user" class="com.basic.Java_Beans.User" scope="session"></jsp:useBean>
<form action="formValue.jsp">
First Name:<input type="text" name="firstName" value ='<jsp:getProperty property="firstName" name="user"/>'>
Last Name:<input type="text" name="firstName" value ='<jsp:getProperty property="lastName" name="user"/>'>
<input type="submit" value="submit">
</form>
</body>
</html>