<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="submit.jsp" method="get">

Full Name :
<input type="text" name="fullname" /><br/><br/>

Gender :
<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female" checked>Female
<br/><br/>

Language learned :
<input type="checkbox" name="language" value="Java" checked>Java
<input type="checkbox" name="language" value="Python">Python
<input type="checkbox" name="language" value="C++">C++
<br/><br/>

Skill :
<input type="text" name="skill" /><br/><br/>

<input type="submit" value="Submit">
</form>
</body>
</html>
</body>
</html>