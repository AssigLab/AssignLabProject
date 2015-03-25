<%-- 
    Document   : GetLabs
    Created on : Mar 23, 2015, 6:13:39 AM
    Author     : Muhammad Lupate
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/functions.tld" prefix="f" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Lab View</title>
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
    <body id="page2">
        <iframe  name="iframe_ab"  style=" z-index: -1; border:none ; position:absolute; top:0; left:0; right:0; bottom:0; width:100%; height:100%" ></iframe>
        <!-- START PAGE SOURCE -->
        <div class="wrap">
            <header>
                <div class="container">
                    <h1><a href="#">Stuff's site</a></h1>
                    <nav>
                        <ul>
                            <li><a href="Home.jsp" class="m1">Home</a></li>
                            <li  class="current"><a href="GetGroups" class="m2">View Lab</a></li>
                            <li class="last"><button type="button" class="btn btn-logout block full-width m-b ">Log Out</button></li>

                        </ul>
                    </nav>
                    <form action="#" id="search-form">
                        <fieldset>
                            <div class="rowElem">
                                <input type="text" class="form-control" placeholder="Search" required="">
                                <button type="button" class="btn btn-search block full-width m-b">Search</button>
                        </fieldset>
                    </form>
                </div>
            </header>
            <div class="container">
                <aside>
                    <h3>Categories</h3>
                    <ul class="categories">
                        <li><span><a href="#" >About Us</a></span></li>
                        <li class="last"><span><a href="#" >Show Statistics</a></span></li>
                    </ul>

                    <h2>Fresh <span>News</span></h2>
                    <ul class="news">
                        <li><strong>June 30, 2010</strong>
                            <h4><a href="#">Sed ut perspiciatis unde</a></h4>
                            Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque. </li>
                        <li><strong>June 14, 2010</strong>
                            <h4><a href="#">Neque porro quisquam est</a></h4>
                            Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit consequuntur magni. </li>
                        <li><strong>May 29, 2010</strong>
                            <h4><a href="#">Minima veniam, quis nostrum</a></h4>
                            Uis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae. </li>
                    </ul>
                </aside>
                <section id="content">
                    <div class="inside" id="inside_form">
                        <form class="m-t" role="form" action="GetDeliveryqueue">
                            <!--<form class="m-t" role="form" action="/StaffSystem/StuffView/viewQueue.jsp">-->
                            <table class="form_table">
                                <tr>
                                    <td colspan="2">
                                        <div id="form_header">Select Lab</div>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>
                                        <h3>Select Lab</h3>
                                    </td>
                                    <td>
                                        <div>
                                            <select class="form-control" name=lab>

                                                <c:forEach var="labString" items="${sessionScope.labs}" >
                                                    <%--<c:choose>
                                                        <c:when test="${selectedFlag}">
                                                            <c:choose>
                                                                <c:when test="${f:equals(selectedLocaleString,localeString)}" >
                                                                    <option selected>${localeString}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option>${localeString}</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:when>
                                                        <c:otherwise>--%>
                                                    <option>${labString}</option>
                                                    <%--</c:otherwise>
                                                </c:choose>--%>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </td>
                                </tr>

                                <tr>
                                    <td colspan="2">
                                        <button type="submit" class="btn btn-create block full-width m-b" >Show Queue</button>

                                    </td>
                                    <td></td>
                                </tr>
                            </table>
                        </form>

                    </div>
                </section>
            </div>
        </div>
        <footer>
            <div class="footerlink">
                <p class="lf">Copyright &copy; 2010 <a href="#">Lab Management</a> - All Rights Reserved</p>
                <div style="clear:both;"></div>
            </div>
        </footer>
</html>

