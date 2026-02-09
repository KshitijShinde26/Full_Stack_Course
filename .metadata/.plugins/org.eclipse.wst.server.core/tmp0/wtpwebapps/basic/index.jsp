<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="com.basic.Hello, java.util.Date" %>
<meta charset="UTF-8">
<title>Example</title>
</head>
<body>
<%= new Hello().message() %>
<br>
<% out.print(new Date()); %>
</body>
</html>