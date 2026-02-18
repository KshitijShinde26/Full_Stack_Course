<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
<div class="navbar-solid-state">

    <header id="header" class="alt">
        <nav>
            <a href="#menu" class="a-menu">
                Menu <i class="ion-android-menu"></i>
            </a>
        </nav>
    </header>

    <nav id="menu">
        <div class="inner">
            <h2>Menu</h2>
            <ul class="links">
                <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                <li><a href="#">Elements</a></li>
            </ul>
            <a href="#" class="close">Close</a>
        </div>
    </nav>

</div>
<section id="banner">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Welcome to Demo Web page!</h2>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12"> 
                        <p>By Kshitij <a href="http://www.themewagon.com">(THEMEWAGON as Background image)</a></p>
                    </div>
                </div>

                
            </div>
        </section>


</body>
</html>