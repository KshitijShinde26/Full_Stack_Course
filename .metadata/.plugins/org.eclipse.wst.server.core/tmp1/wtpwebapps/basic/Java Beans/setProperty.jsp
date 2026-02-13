<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set property</title>
</head>
<body>
<jsp:useBean id="user" class="com.basic.Java_Beans.User" scope="session"></jsp:useBean>
<jsp:setProperty property="firstName" name="user" value="firstName"/><br/>
<jsp:setProperty property="lastName" name="user" value="lastName"/>
Values are updated
</body>
</html>