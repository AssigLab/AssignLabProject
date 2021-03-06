<%-- 
    Document   : Home
    Created on : Mar 24, 2015, 4:30:49 AM
    Author     : Muhammad Lupate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title> Stuff's View</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="http://localhost:8080/AssignLabProject/stuffcss/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="http://localhost:8080/AssignLabProject/stuffcss/style.css" type="text/css" media="all">
        <script type="text/javascript" src=http://localhost:8080/AssignLabProject/stuffjs/jquery-1.4.2.min.js" ></script>
        <script type="text/javascript" src="http://localhost:8080/AssignLabProject/stuffjs/cufon-yui.js"></script>
        <script type="text/javascript" src="http://localhost:8080/AssignLabProject/stuffjs/cufon-replace.js"></script>
        <script type="text/javascript" src="http://localhost:8080/AssignLabProject/stuffjs/Myriad_Pro_300.font.js"></script>
        <script type="text/javascript" src="http://localhost:8080/AssignLabProject/stuffjs/Myriad_Pro_400.font.js"></script>
        <script type="text/javascript" src="http://localhost:8080/AssignLabProject/stuffjs/script.js"></script>
        <!--<link href="../studentcss/bootstrap.min.css" rel="stylesheet">-->
        <link href="http://localhost:8080/AssignLabProject/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="http://localhost:8080/AssignLabProject/stuffcss/animate.css" rel="stylesheet">
        <!--[if lt IE 7]>
        <link rel="stylesheet" href="css/ie6.css" type="text/css" media="screen">
        <script type="text/javascript" src="js/ie_png.js"></script>
        <script type="text/javascript">ie_png.fix('.png, footer, header nav ul li a, .nav-bg, .list li img');</script>
        <![endif]-->
        <!--[if lt IE 9]><script type="text/javascript" src="js/html5.js"></script><![endif]-->
    </head>
    <body id="page1">
        <!-- START PAGE SOURCE -->
        <div class="wrap">
            <header>
                <div class="container">
                    <h1><a href="#">Stuff's site</a></h1>
                    <nav>
                        <ul>
                            <li  class="current"><a href="#" class="m1">Home</a></li>
                            <li><a href="StuffView/GetDepartments.jsp" class="m2">View Lab</a></li>
                            <li class="last">
                                <form action="LogoutServlet" method="post">
                                    <button type="submit" class="btn btn-logout block full-width m-b">Log Out</button>
                                </form>
                            </li>                        </ul>
                    </nav>
                   
                </div>
            </header>
            <div class="container">
                <aside>
                    <h3>Categories</h3>
                    <ul class="categories">
                        <li><span><a href="#" >About Us</a></span></li>
                        <!--<li class="last"><span><a href="#" >Show Statistics</a></span></li>-->
                    </ul>

                    <h2>Fresh <span>News</span></h2>
                    <ul class="news">
                        <li><strong>18-02-2015</strong>
                            <h4><a href="#">On the 11th of February 2015,</a></h4>
                             Information Technology Institute hosted the well-known acclaimed Egyptian writer Gamal El-Ghitani. </li>
                        <li><strong>08-02-2015</strong>
                            <h4><a href="#">On February 3rd, 2015,</a></h4>
                            Information Technology Institute hosted an esteemed delegation from the American multinational technology and consulting corporation, IBM.   </li>
                        
                    </ul>
                </aside>
                <section id="content">
                    <div id="banner">
                        <h2><a href="GetDepartments.jsp">Professional Lab<span>Management System  <span>Since 2015</span></span></a></h2>
                    </div>

                </section>
            </div>
        </div>
        <footer>
            <div class="footerlink">
                <p class="lf">Copyright &copy; 2015 <a href="#">Lab Management</a> - All Rights Reserved</p>
                <div style="clear:both;"></div>
            </div>
        </footer>
</html>
