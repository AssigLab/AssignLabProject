<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.jsp.jstl.core.*"%>
<%@ page import="javax.servlet.jsp.el.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title> Student's View</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta charset="utf-8">
        <link rel="stylesheet" href="view/studentcss/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="view/studentcss/style.css" type="text/css" media="all">
        <script type="text/javascript" src="view/studentjs/jquery-1.4.2.min.js" ></script>
        <script type="text/javascript" src="view/studentjs/cufon-yui.js"></script>
        <script type="text/javascript" src="view/studentjs/cufon-replace.js"></script>
        <script type="text/javascript" src="view/studentjs/Myriad_Pro_300.font.js"></script>
        <script type="text/javascript" src="view/studentjs/Myriad_Pro_400.font.js"></script>
        <script type="text/javascript" src="view/studentjs/script.js"></script>
        <!--<link href="../studentcss/bootstrap.min.css" rel="stylesheet">-->
        <link href="view/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="view/studentcss/animate.css" rel="stylesheet">

        <!--[if lt IE 7]>
        <link rel="stylesheet" href="css/ie6.css" type="text/css" media="screen">
        <script type="text/javascript" src="js/ie_png.js"></script>
        <script type="text/javascript">ie_png.fix('.png, footer, header nav ul li a, .nav-bg, .list li img');</script>
        <![endif]-->
        <!--[if lt IE 9]><script type="text/javascript" src="js/html5.js"></script><![endif]-->
    </head>
    <body id="page1">
        <!-- START PAGE SOURCE -->







        <%

            response.setIntHeader("Refresh", 15);
        %>
        <div class="wrap">
            <header>
                <div class="container">
                    <h1><a href="#">Student's site</a></h1>
                    <nav>
                        <ul>
                            <li class="current"><a href="#" class="m1">Home</a></li>
                            <li><a href="#" class="m2">About Us</a></li>
                            <li class="last"><a href="#" class="m3">Schedule</a></li>
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
                        </fieldset>
                    </form>
                </div>
            </header>
            <div class="container">
                <aside>
                    <h3>Groups</h3>
                    <ul class="categories">
                        <li>

                            <c:forEach items="${groupList}" var="group"> 

                                <span><a href="#"> ${group.name} </a></span>

                            </li>
                        </c:forEach>


                    </ul>

                    <h2>Fresh <span>News</span></h2>
                    <ul class="news">
                        <li style=" color:#ff7b01">
                            ${notification}
                        </li>

                </aside>
                <section id="content">
                    <div>
                        <button type="button" class="btn btn-upload block full-width m-b"><a id="link_btn" href="#openuploadModal">Upload File</a></button>
                        <span style=" color:#ff7b01"> ${cantUploadFile}  </span>
                    </div>




                    <!--Modal Dialog to upload file  -->
                    <div id="openuploadModal" class="modalDialog">
                        <div>

                            <a href="#close" title="Close" class="close">X</a>
                            <form class="m-t" role="form" action="UploadServlet"  method="post" enctype="multipart/form-data">
                                <table class="popup-form">
                                    <tr>
                                        <td colspan="2">
                                            <div id="popup_form_header">Upload File</div>
                                        </td>
                                        <td></td>

                                    </tr>
                                    <tr>
                                        <td>
                                            <h3>Choose File</h3>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <input type="file" class="form-control"  id="popup_upload"  name="fileName" >
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">



                                            <button type="submit" class="btn btn-create block full-width m-b" id="popup_btn1">Upload</button>
                                            <button type="submit" class="btn btn-create block full-width m-b" id="popup_btn2"><a id="link_btn" href="#close" >Cancel</a></button> 
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
                                <h5>Assistant Queue</h5>
                            </div>
                            <div class="ibox-content">

                                <div class="dd" id="nestable2">
                                    <ol class="dd-list">
                                        <li class="dd-item" data-id="1">
                                            <c:forEach items="${assistanceQueue}" var="user">
                                                <div class="dd-handle">
                                                    <span class="label label-info"><i class="fa fa-cog"></i></span> ${user.name}
                                                    <span class="pull-right text-muted small">Any Comment</span>
                                                </div>
                                                <!--                                            <div class="dd-handle">
                                                                                                <span class="label label-info"><i class="fa fa-bolt"></i></span> Rania Mohamed.
                                                                                                <span class="pull-right text-muted small">Any Comment</span>
                                                                                            </div>
                                                                                            <div class="dd-handle">
                                                                                                <span class="label label-info"><i class="fa fa-cog"></i></span> Sara Hussien.
                                                                                                <span class="pull-right text-muted small">Any Comment</span>
                                                                                            </div>-->
                                            </c:forEach>
                                        </li>
                                    </ol>

                                </div>
                                <div style=" color:#ff7b01" >  ${cantRequestAssistant} </div>
                            </div>
                            <div class="ibox-bottom">
                                <form class="m-t" role="form" action=" CancelAssistanceQueueRequest" methode="post">
                                    <button type="button" class="btn btn-que block full-width m-b"><a id="link_btn" href="#openModal">Request</a></button>
                                    <button type="submit" class="btn btn-que block full-width m-b">Cancel</button>
                                </form>
                            </div>

                        </div>
                        <div class="ibox " id="del-que">
                            <div class="ibox-title">
                                <h5>Delivery Queue</h5>
                            </div>
                            <div class="ibox-content">

                                <div class="dd" id="nestable2">
                                    <ol class="dd-list">
                                        <c:forEach items="${deliveryQueue}" var="user">
                                            <li class="dd-item" data-id="1">
                                                <div class="dd-handle">
                                                    <span class="label label-info"><i class="fa fa-cog"></i></span> ${user.name}
                                                    <span class="pull-right text-muted small">Any Comment</span>
                                                </div>


                                            </li>
                                        </c:forEach>
                                    </ol>
                                </div>
                                <div style=" color:#ff7b01" >  ${cantRequestDelivery} </div>
                            </div>
                            <div class="ibox-bottom">
                                <form class="m-t" role="form" action=" CancelDeliveryQueueRequest" methode="post">
                                    <button type="button" class="btn btn-que block full-width m-b"><a id="link_btn" href="#openModal1">Request</a></button>
                                    <button type="submit" class="btn btn-que block full-width m-b">Cancel</button>
                                </form>
                            </div>

                        </div>
                    </div>
                </section>
                <!--Modal Dialog for Delete group  -->


                <div id="openModal1" class="modalDialog">
                    <div>

                        <a href="#close" title="Close" class="close">X</a>
                        <form class="m-t" role="form" action="RequestDeliveryQueueServlet" methode="post">
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
                                            <input type="text" class="form-control"  id="popup_txt1" placeholder="comment" name="comment">
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










                <!--                     -->
                <div id="openModal" class="modalDialog">
                    <div>

                        <a href="#close" title="Close" class="close">X</a>
                        <form class="m-t" role="form" action="RequestAssistantQueueServlet" methode="post">
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
                                            <input type="text" class="form-control"  id="popup_txt1" placeholder="comment" name="comment" >
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


        <script>
            function myFunction() {
                var x = document.getElementById("popup_upload").value;
                alert(x);
// document.getElementById("demo").innerHTML = x;
            }
        </script>
</html>

<!--  <ol class="dd-list">
                                        <li class="dd-item" data-id="1">
                                            <div class="dd-handle">
                                                <span class="label label-info"><i class="fa fa-cog"></i></span> Heb Mohamed.
                                                <span class="pull-right text-muted small">Any Comment</span>
                                            </div>
                                            <div class="dd-handle">
                                                <span class="label label-info"><i class="fa fa-bolt"></i></span> Rania Mohamed.
                                                <span class="pull-right text-muted small">Any Comment</span>
                                            </div>
                                            <div class="dd-handle">
                                                <span class="label label-info"><i class="fa fa-cog"></i></span> Sara Hussien.
                                                <span class="pull-right text-muted small">Any Comment</span>
                                            </div>

                                        </li>
                                    </ol>-->