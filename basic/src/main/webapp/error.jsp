<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>

    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ionicons.min.css">
    <link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet">
</head>

<body>

<!-- Preloader -->
<div id="preloader"></div>

<div class="body-content">

    <%@ include file="include/header.jsp" %>

    <!-- Welcome Section -->
    <section style="height: 100vh; display:flex; justify-content:center; align-items:center;">
        <div class="text-center">
            <h1>Error Page</h1>
            
        </div>
    </section>

    <%@ include file="include/footer.jsp" %>

</div>

<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

</body>
</html>
