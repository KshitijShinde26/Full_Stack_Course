<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Output</title>
</head>
<body>

<h2>Form Submitted Successfully</h2>

Name: <%= request.getParameter("fullname") %><br/>
Gender: <%= request.getParameter("gender") %><br/>
Skill: <%= request.getParameter("skill") %><br/>

Languages:
<%
String[] langs = request.getParameterValues("language");
if (langs != null) {
    for (String l : langs) {
        out.print(l + " ");
    }
}
%>

</body>
</html>