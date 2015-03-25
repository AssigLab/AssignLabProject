<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Deactivate Group</title>
        <c:set var="grouplist" value="${requestScope.allactiveGroups}"/>
        <meta charset="utf-8">
        <link rel="stylesheet" href="./css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="./css/style.css" type="text/css" media="all">
        <script type="text/javascript" src="./js/jquery-1.4.2.min.js" ></script>
        <script type="text/javascript" src="./js/cufon-yui.js"></script>
        <script type="text/javascript" src="./js/cufon-replace.js"></script>
        <script type="text/javascript" src="./js/Myriad_Pro_300.font.js"></script>
        <script type="text/javascript" src="./js/Myriad_Pro_400.font.js"></script>
        <!--[if lt IE 7]>
        <link rel="stylesheet" href="css/ie6.css" type="text/css" media="screen">
        <script type="text/javascript" src="js/ie_png.js"></script>
        <script type="text/javascript">ie_png.fix('.png, footer, header nav ul li a, .nav-bg, .list li img');</script>
        <![endif]-->
        <!--[if lt IE 9]><script type="text/javascript" src="js/html5.js"></script><![endif]-->
        <script>

            function refreshComp1() {
                var selVal = document.getElementById("groupselection").value;
                if (selVal == "") {
                    document.getElementById("updateButton").hidden = true;
                    document.getElementById("popup_txt1").value = "";
                    document.getElementById("popup_txt2").value = "";
                }
                else if (selVal != "") {

                    var stateArray = new Array();
            <c:forEach var = "state" items = "${grouplist}" varStatus = "status" >
                    stateArray[${status.index}] = "${state.description}";
            </c:forEach>
                    document.getElementById("updateButton").hidden = false;
                    document.getElementById("popup_txt1").value = selVal;
                    document.getElementById("popup_txt2").innerHTML = stateArray[(document.getElementById("groupselection").selectedIndex) - 1];
                }
            }

        </script>
    </head>
    <body id="page2">
        <iframe  name="iframe_ab"  style=" z-index: -1; border:none ; position:absolute; top:0; left:0; right:0; bottom:0; width:100%; height:100%" ></iframe>
        <!-- START PAGE SOURCE -->
        <div class="wrap">
            <header>
                <div class="container">
                    <h1><a href="#">Student's site</a></h1>
                    <nav>
                        <ul>
                            <li><a href="Home.jsp" class="m1">Home</a></li>
                            <li class="current"><a href="Group.jsp" class="m2">Group</a></li>
                            <li><a href="Department.jsp" class="m3">Department</a></li>
                            <li><a href="Course.jsp" class="m4">Course</a></li>
                            <li><a href="User.jsp" class="m5">User</a></li>
                            <li class="last">
                                <form action="LogoutServlet" method="post">
                                    <button type="submit" class="btn btn-logout block full-width m-b">Log Out</button>
                                </form>
                            </li>
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
                         <li><span><a href="createGroup.jsp" >Create Group</a></span></li>
                        <li><span><a href="getAllGroupsForUpdate" >Update Group</a></span></li>
                        <li><span><a href="deleteGroup.jsp" >Delete Group</a></span></li>
                        <li><span><a href="getAllGroupsForDeactive" >Deactivate Group</a></span></li>
                        <li><span><a href="assignstufftoGroup.jsp" >Assign Stuff To Group</a></span></li>
                        <li><span><a href="assigncoursetoGroup.jsp" >Assign Course To Group</a></span></li>
                        <li class="last"><span><a href="assigntraineetoGroup.jsp" >Assign Trainee To Group</a></span></li>
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
                        <form class="m-t" role="form"  method="post" action="validateNameDeactivateGroup">
                            <table class="form_table">
                                <tr>
                                    <td colspan="2">
                                        <div id="form_header">Deactivate Groups</div>
                                    </td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <h3>Select Group</h3>
                                    </td>
                                    <td>
                                        <div>
                                            <select class="form-control" name="AllGroups" onchange="refreshComp1()" id="groupselection">
                                                <option selected="selected" value="" selected="selected">Choose...</option>
                                                <c:forEach var="fieldItem" items="${grouplist}">
                                                    <option value="${fieldItem.name}">${fieldItem.name}</option>             
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="span-col" id="create-span">${requestScope.chName}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <button type="button" hidden class="btn btn-create block full-width m-b" id="updateButton" ><a id="link_btn" href="#openModal">Deactivate</a></button>
                                    </td>
                                    <td></td>
                                </tr>
                            </table>
                            <!--Modal Dialog for Update group  -->
                            <div id="openModal" class="modalDialog">
                                <div>

                                    <a href="#close" title="Close" class="close">X</a>
                                    <table class="popup-form">
                                        <tr>
                                            <td colspan="2">
                                                <div id="popup_form_header">Deactivate Group</div>
                                            </td>
                                            <td></td>

                                        </tr>
                                        <tr>
                                            <td>
                                                <h3>Group Name</h3>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <input type="text" class="form-control" name="name"  id="popup_txt1" placeholder="Group Name" readonly="">
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h3>Group Description</h3>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <textarea class="form-control" name="description" id="popup_txt2" placeholder="Group Description" readonly=""> </textarea>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <button type="submit" class="btn btn-create block full-width m-b" id="popup_btn1">Apply</button>
                                                <button type="submit" class="btn btn-create block full-width m-b" id="popup_btn2">Cancel</button> 
                                            </td>
                                            <td>

                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
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

