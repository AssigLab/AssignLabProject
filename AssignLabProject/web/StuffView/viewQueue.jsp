<%-- 
    Document   : viewQueue
    Created on : Mar 24, 2015, 5:17:21 AM
    Author     : Muhammad Lupate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title> Stuff's View</title>
        <meta charset="utf-8">
        <META 
            HTTP-EQUIV="Refresh"
            CONTENT="5; URL=#">
        <Meta http-equiv="Pragma" content="no cache">
        <Meta http-equiv="Cache-control" content="no cache">
        <meta http-equiv="Expires" content="0">    

        <link rel="stylesheet" href="http://localhost:8080/AssignLabProject/stuffcss/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="http://localhost:8080/AssignLabProject/stuffcss/style.css" type="text/css" media="all">
        <script type="text/javascript" src="../stuffjs/jquery-1.4.2.min.js"></script>
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

        <% // response.addHeader("Refresh", "10;http://localhost:8080/StaffSystem/StuffView/viewQueue.jsp");%>

        <div class="wrap">
            <header>
                <div class="container">
                    <h1><a href="#">Stuff's site</a></h1>
                    <nav>
                        <ul>
                            <li><a href="Home.jsp" class="m1">Home</a></li>
                            <li   class="current"><a href="GetGroups" class="m2">View Lab</a></li>
                            <li class="last">
                                <form action="LogoutServlet" method="post">
                                    <button type="submit" class="btn btn-logout block full-width m-b">Log Out</button>
                                </form>
                            </li>                        </ul>
                    </nav>
                    <form action="#" id="search-form">
                        <fieldset>
                            <div class="rowElem">
                                <input type="text" class="form-control" placeholder="Search" required="">
                                <button type="button" class="btn btn-search block full-width m-b">Search</button>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </header>
            <div class="container">
                <aside>
                    <h3>Categories</h3>
                    <ul class="categories">                        
                        <li><span><a href="../EnableUploading" >Enable Uploading</a></span></li>
                        <li><span><a href="/StaffSystem/StuffView/GetLabsToShift.jsp" >Shift Queue</a></span></li>
                        <li class="last"><span class="pull-right text-muted small">
                                <!--<form action="../CloseLab" method="get" name="clsoeForm">-->

                                <a href="../CloseLab" >Close Lab</a></span></li>
                        <!--<input type="submit" class="btn btn-que block full-width m-b"/>-->
                        <!--</form>-->

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
                    <div>
                        <button type="button" class="btn btn-upload block full-width m-b"><a id="link_btn" href="../DownloadServlet">Download File</a></button>
                    </div>
                    <!--Modal Dialog for Delete group  -->
                    <div id="openuploadModal" class="modalDialog">
                        <div>

                            <a href="#close" title="Close" class="close">X</a>
                            <form class="m-t" role="form" action="index.html">
                                <table class="popup-form">
                                    <tr>
                                        <td colspan="2">
                                            <div id="popup_form_header">Download Files</div>
                                        </td>
                                        <td></td>

                                    </tr>
                                    <tr>
                                        <td>
                                            <!--<h3>Choose File</h3>-->
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <!--<input type="file" class="form-control"  id="popup_upload"  >-->
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">
                                            <button type="submit" class="btn btn-create block full-width m-b" id="popup_btn1">Download</button>
                                            <!--<button type="submit" class="btn btn-create block full-width m-b" id="popup_btn2"><a id="link_btn" href="#close" >Cancel</a></button>--> 
                                        </td>
                                        <td>

                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                    <div>
                        <div class="ibox " id="ass-que">
                            <div class="ibox-title">
                                <h5>Delivery Queue</h5>
                            </div>
                            <div class="ibox-content">

                                <div class="dd" id="nestable2">
                                    <ol class="dd-list">

                                        <li class="dd-item" data-id="1">
                                            <%--
                                            <c:forEach var="deliveryString" items="${sessionScope.delivery}" >
                                                <div class="dd-handle" value="${deliveryString}">
                                                    <span class="label label-info"><i class="fa fa-cog"></i></span> ${deliveryString}
                                                    <span class="pull-right text-muted small">Any Comment</span>
                                                </div>
                                            </c:forEach>--%>
                                            <jsp:useBean id="delivery" scope="request" class="DAO.QueueDAO"/>
                                            <c:forEach var="deliveryString" items="${delivery.getTraineeInDeliveryQueue_Staff(sessionScope.lab)}" >

                                                <div class="dd-handle">
                                                    <form class="m-t" role="form" action="../HandleDeliveryQueue">
                                                        <li class="dd-item" data-id="1">            <span class="label label-info"><i class="fa fa-cog"></i></span> ${deliveryString.getUserName()}
                                                            <span class="pull-right text-muted small">${deliveryString.getComment()}</span> 
                                                        </li><li class="dd-item" data-id="1">
                                                            <input type="submit" name="pick" value="Pick" class="btn btn-que block full-width m-b"/>
                                                            <input type="hidden" name="hidden" value="${deliveryString.getUserName()}"/>
                                                            <input type="submit" name="dequeue" value="Dequeue" class="btn btn-que block full-width m-b"/>
                                                        </li>   </form>                                                    
                                                </div>
                                            </li>
                                        </c:forEach>

                                    </ol>
                                </div>
                            </div>                            
                        </div>
                        <div class="ibox " id="del-que">
                            <div class="ibox-title">
                                <h5>Assistance Queue</h5>
                            </div>
                            <div class="ibox-content">

                                <div class="dd" id="nestable2">
                                    <ol class="dd-list">
                                        <li class="dd-item" data-id="1">

                                            <jsp:useBean id="assis" scope="request" class="DAO.QueueDAO"/>
                                            <c:forEach var="assisString" items="${assis.getTraineeInAssistanceQueue_Staff(sessionScope.lab)}" >
                                            <li class="dd-item" data-id="1">
                                                <div class="dd-handle">

                                                    <form class="m-t" role="form" action="../HandleAssisQueue">
                                                        <li class="dd-item" data-id="1">
                                                            <span class="label label-info"><i class="fa fa-cog"></i></span> ${assisString.getUserName()}
                                                            <span class="pull-right text-muted small">    ${assisString.getComment()}</span> 
                                                        </li>    <li class="dd-item" data-id="1">
                                                            <input type="submit" name="pick" value="Pick" class="btn btn-que block full-width m-b"  />
                                                            <input type="hidden" name="hidden" value="${assisString.getUserName()}">
                                                            <input type="submit" name="dequeue" value="Dequeue" class="btn btn-que block full-width m-b"/>
                                                        </li>
                                                    </form>                                                    
                                                </div>
                                            </li>   
                                        </c:forEach>
                                        </li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!--Modal Dialog for Delete group  -->
                <div id="openModal" class="modalDialog">
                    <div>

                        <a href="#close" title="Close" class="close">X</a>
                        <form class="m-t" role="form" action="index.html">
                            <table class="popup-form">
                                <tr>
                                    <td colspan="2">
                                        <div id="popup_form_header">Request</div>
                                    </td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <h3>Comment</h3>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <input type="text" class="form-control"  id="popup_txt1" placeholder="GroupName" readonly="" >
                                        </div>
                                    </td>
                                </tr>

                                <tr>
                                    <td colspan="2">
                                        <button type="submit" class="btn btn-create block full-width m-b" id="popup_btn1">Confirm</button>
                                        <button type="submit" class="btn btn-create block full-width m-b" id="popup_btn2"><a id="link_btn" href="#close" >Cancel</a></button> 
                                    </td>
                                    <td>

                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="footerlink">
                <p class="lf">Copyright &copy; 2010 <a href="#">Lab Management</a> - All Rights Reserved</p>
                <div style="clear:both;"></div>
            </div>
        </footer>
</html>