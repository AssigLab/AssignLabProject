<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Update Course</title>
        <!--get All Active department from request --> 
        <c:set var="deptlist" value="${requestScope.allactiveDepart}"/>

        <meta charset="utf-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="./css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="./css/style.css" type="text/css" media="all">
        <script type="text/javascript" src="./js/jquery-1.4.2.min.js" ></script>
        <script type="text/javascript" src="./js/cufon-yui.js"></script>
        <script type="text/javascript" src="./js/cufon-replace.js"></script>
        <script type="text/javascript" src="./js/Myriad_Pro_300.font.js"></script>
        <script type="text/javascript" src="./js/Myriad_Pro_400.font.js"></script>

        <script>
            var xmlhttp = null;
            var xmlhttp2 = null;
            var xmlhttp3 = null;
            var xml_courses = [];
            
            function getAllDepart() {
                var req;
                if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                    req = new XMLHttpRequest();
                }
                else {// code for IE6, IE5
                    req = new ActiveXObject("Microsoft.XMLHTTP");
                }
                req.onreadystatechange = function() {
                    if (req.readyState == 4 && req.status == 200) {
                        var xmlDoc = req.responseXML;
                        var depts = xmlDoc.getElementsByTagName("depart");
                        for (var i = 0; i < depts.length; i++) {
                            o = depts[i];
                            // store all courses
                            var departname = o.childNodes[0];
                            $('#deptsall').append('<option value="' + departname.childNodes[0].nodeValue + '" > ' + departname.childNodes[0].nodeValue + '</option><br />');
                        }
                    }
                }
                req.open("POST", "http://localhost:8080/AssignLabProject/getDeparts", true);
                req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                req.send(null);
            }

            // when user select department , will assign department name , description in text field
            function refreshComp() {
                var selVal = document.getElementById("deptsall").value;
                if (selVal == "") {
                    document.getElementById("courseInfo").hidden = true;
                }
                else if (selVal != "") {
                    if (window.XMLHttpRequest)
                    {// code for IE7+, Firefox, Chrome, Opera, Safari
                        xmlhttp2 = new XMLHttpRequest();
                    }
                    else if (window.ActiveXObject)
                    {// code for IE6, IE5
                        xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    xmlhttp2.onreadystatechange = handleStateChange;
                    xmlhttp2.open("POST", "http://localhost:8080/AssignLabProject/getCoursesByDept?deptname=" + selVal, true);
                    xmlhttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    xmlhttp2.send(null);
                }
            }

            function handleStateChange() {
                if (xmlhttp2.readyState == 4) {
                    var xmlDoc = xmlhttp2.responseXML;
                    var courses = xmlDoc.getElementsByTagName("course");
                    if (courses.length == 0) {
                        document.getElementById("courseInfo").hidden = true;
                    }
                    for (var i = 0; i < courses.length; i++) {
                        document.getElementById("courseall").hidden = false;
                        o = courses[i];
                        // store all courses
                        
                        var coursename = o.childNodes[0];
                        xml_courses.push(o);
                        $('#courseall').append('<option value="' + coursename.childNodes[0].nodeValue + '" > ' + coursename.childNodes[0].nodeValue + '</option><br />');
                    }
                }
            }

            function checkName() {
                var req;
                if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                    req = new XMLHttpRequest();
                }
                else {// code for IE6, IE5
                    req = new ActiveXObject("Microsoft.XMLHTTP");
                }
                req.onreadystatechange = function() {
                    if (req.readyState == 4 && req.status == 200) {
                        document.getElementById("errorName").innerHTML = req.responseText;
                    }
                }
                var vvv = document.getElementById("name").value;
                req.open("GET", "http://localhost:8080/AssignLabProject/validAddCourse?name=" + vvv + "&selectCourse=" + document.getElementById("courseall").value, true);
                req.send(null);
            }

            function refreshButton() {
                var selVal = document.getElementById("courseall").selectedIndex;
                if (selVal != 0) {
                    document.getElementById("courseInfo").hidden = false;
                    
                    var courses = xml_courses[selVal - 1];
                    document.getElementById("name").value = courses.childNodes[0].childNodes[0].nodeValue;
                    document.getElementById("desc").innerHTML = courses.childNodes[1].childNodes[0].nodeValue;
                    document.getElementById("deptsall_UP").selectedIndex = document.getElementById("deptsall").selectedIndex;
                }
                else {
                    document.getElementById("courseInfo").hidden = true;
                }
            }

            function CheckAndSubmit() {
                if (document.getElementById("errorName").innerHTML.trim() == "" && document.getElementById("deptsall_UP").value.trim() != "") {
                    return true;
                }
                return false;
            }
        </script>
    </head>
    <body id="page2" onload="getAllDepart()">
        <iframe  name="iframe_ab"  style=" z-index: -1; border:none ; position:absolute; top:0; left:0; right:0; bottom:0; width:100%; height:100%" ></iframe>
        <!-- START PAGE SOURCE -->
        <div class="wrap">
            <header>
                <div class="container">
                    <h1><a href="#">Student's site</a></h1>
                    <nav>
                        <ul>
                            <li><a href="Home.jsp" class="m1">Home</a></li>
                            <li><a href="Group.jsp" class="m2">Group</a></li>
                            <li><a href="Department.jsp" class="m3">Department</a></li>
                            <li class="current"><a href="Course.jsp" class="m4">Course</a></li>
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
                        <li><span><a href="AddCourse.jsp">Create Course</a></span></li>
                        <li><span><a href="updateCourse.jsp">Update Course</a></span></li>
                        <li><span><a href="#">Delete Course</a></span></li>
                        <li><span><a href="deactiveCourse.jsp">Deactivate Course</a></span></li>
                        <li  class="last"><span><a href="AssignLabCourse.jsp">Add Lab To Course</a></span></li>
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
                        <form class="m-t" method="post" onsubmit="return CheckAndSubmit ()" action="validUpdateCourse">
                            <table class="form_table">
                                <tr>
                                    <td colspan="2">
                                        <div id="form_header">Update Course</div>
                                    </td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <h3>Select Department</h3>
                                    </td>
                                    <td>
                                        <div>
                                            <select class="form-control"  style="width:250px" name="AllDepart" onchange="refreshComp()" id="deptsall">
                                                <option selected="selected" value="" selected="selected">Choose...</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="span-col" id="create-span">${requestScope.chName}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <h3>Select Course</h3>
                                    </td>
                                    <td>
                                        <div>
                                            <select class="form-control"  hidden style="width:250px" onchange="refreshButton()" name="AllCourse"  id="courseall">
                                                <option selected="selected" value="" selected="selected">Choose...</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="span-col" id="create-span">${requestScope.chName}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3">
                                        <table id="courseInfo" hidden class="form_table">
                                            <tr>
                                                <td>
                                                    <h3>Name</h3>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <input type="text" onblur="checkName()" id="name" name="name" class="form-control" placeholder="Course Name" required="">
                                                    </div>
                                                </td>
                                                <td>
                                                    <span class="span-col" id="errorName">${requestScope.chName}</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <br/>
                                                    <h3>Description</h3>
                                                </td>
                                                <td>
                                                    <br/>
                                                    <div class="form-group">
                                                        <textarea class="form-control" id="desc" name="description" placeholder="Course  Description" required=""> </textarea>

                                                    </div>
                                                </td>
                                                <td>
                                                    <br/>
                                                    <span class="span-col" id="des-span"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <br/>
                                                    <h3>Department</h3>
                                                </td>
                                                <td>
                                                    <br/>
                                                    <div class="form-group">
                                                        <select class="form-control"  name="AllDepart_Up" id="deptsall_UP">
                                                            <option selected="selected" value="" selected="selected">Choose...</option>
                                                            <c:forEach var="fieldItem" items="${deptlist}">
                                                                <option value="${fieldItem.name}">${fieldItem.name}</option>             
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </td>
                                                <td>
                                                    <br/>
                                                    <span class="span-col" id="errorDepart"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <input type="submit" class="btn btn-create block full-width m-b" />
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </table>
                                    </td>
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
    </body> 
</html>

