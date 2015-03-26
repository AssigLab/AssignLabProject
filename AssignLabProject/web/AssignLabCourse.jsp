<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Create Course</title>

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
                    document.getElementById("courseall").hidden = true;
                }
                else if (selVal != "") {
                    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                        xmlhttp2 = new XMLHttpRequest();
                    }
                    else if (window.ActiveXObject) {// code for IE6, IE5
                        xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    xmlhttp2.onreadystatechange = function() {
                        if (xmlhttp2.readyState == 4) {
                            var xmlDoc = xmlhttp2.responseXML;
                            var courses = xmlDoc.getElementsByTagName("course");
                            if (courses.length == 0) {
                                document.getElementById("courseall").hidden = true;
                            }
                            for (var i = 0; i < courses.length; i++) {
                                document.getElementById("courseall").hidden = false;
                                o = courses[i];
                                // store all courses
                                var coursename = o.childNodes[0];
                                $('#courseall').append('<option value="' + coursename.childNodes[0].nodeValue + '" > ' + coursename.childNodes[0].nodeValue + '</option><br />');
                            }
                        }
                    }
                    xmlhttp2.open("POST", "http://localhost:8080/AssignLabProject/getCoursesByDept?deptname=" + selVal, true);
                    xmlhttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    xmlhttp2.send(null);
                }
            }

            function onSelectCourse(){
                var selVal = document.getElementById("courseall").value;
                if(selVal!="") {
                    document.getElementById("courseInfo").hidden = false;
                    document.getElementById("LLLL").hidden = false;
                }
                else {
                     document.getElementById("courseInfo").hidden = true;
                    document.getElementById("LLLL").hidden = true;
                }
            }
           /* function onSelectCourse() {
                var req;
                var selVal = document.getElementById("courseall").value;
                if (selVal == "") {
                    document.getElementById("LLLL").hidden = true;
                    document.getElementById("courseInfo").hidden = true;
                }
                else if (selVal != "") {
                    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                        req = new XMLHttpRequest();
                    }
                    else if (window.ActiveXObject) {// code for IE6, IE5
                        req = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    req.onreadystatechange = function() {
                        if (req.readyState == 4) {
                            var xmlDoc22 = req.responseXML;
                            var labds = xmlDoc22.getElementsByTagName("Lab");
                            for (var i = 0; i < labds.length; i++) {
                                o = labds[i];
                                // store all courses
                                var coursename = o.childNodes[0];
                                alert(coursename.childNodes[1].nodeValue);
//                                o = labds[i];
//                                // store all courses
//                                var lab = o.childNodes[0];
//                                alert(o.nodeValue);
////                                var alldates = lab.childNodes[1].nodeValue + " , " + lab.childNodes[2].nodeValue;
////                                alert(alldates);
//                                $('#AssignedLab').append('<label><input type="checkbox" class="list_labs" checked name="labs" value="' + lab.childNodes[0].nodeValue + '"/><label>' + alldates + "<br/>");
                            }
                        }
                    }
                    req.open("POST", "http://localhost:8080/AssignLabProject/getLabs?coursename=" + selVal, true);
                    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    req.send(null);
                }
            }*/

            function remove_lab() {
                $(".list_labs:not(:checked)").parent().remove();
                return false;
            }
            
            function add_lab() {
                var start_date = document.getElementById("sdate").value;
                var end_date = document.getElementById("edate").value;
                var start_time = document.getElementById("stime").value;
                var end_time = document.getElementById("etime").value;
                if (start_date.trim() != "" && end_date.trim() != "" && start_time.trim() != "" && end_time.trim() != "") {
                    if ((new Date(start_date + " " + start_time).getTime()) < (new Date(end_date + " " + end_time).getTime())) {
                        var alldates=start_date + " " + start_time + " , " + end_date + " " + end_time;
                        $('#NewLab').append('<label><input type="checkbox" class="list_labs" id="labs" checked name="labs" value="'+alldates+'"/><label>' + alldates + "<br/>");
                        document.getElementById("errorDateTime").innerHTML = "";
                    } else {
                       
                        document.getElementById("errorDateTime").innerHTML = "check start date and time is before end date and time"
                    }
                }

                return false;
            }
             function CheckAndSubmit() {
                if($('.list_labs:checked').length > 0){
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
                        <li><strong>18-02-2015</strong>
                            <h4><a href="#">On the 11th of February 2015,</a></h4>
                             Information Technology Institute hosted the well-known acclaimed Egyptian writer Gamal El-Ghitani. </li>
                        <li><strong>08-02-2015</strong>
                            <h4><a href="#">On February 3rd, 2015,</a></h4>
                            Information Technology Institute hosted an esteemed delegation from the American multinational technology and consulting corporation, IBM.   </li>
                        
                    </ul>
                </aside>
                <section id="content">
                    <div class="inside" id="inside_form">
                        <form class="m-t" onsubmit="return CheckAndSubmit()"  method="post" action="validAssigLabCourse">
                            <table class="form_table">
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
                                            <select class="form-control"  hidden style="width:250px" onchange="onSelectCourse()" name="AllCourse"  id="courseall">
                                                <option selected="selected" value="" selected="selected">Choose...</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="span-col" id="create-span">${requestScope.chName}</span>
                                    </td>
                                </tr>
                                <tr hidden id="courseInfo">
                                    <td colspan="3">
                                        <table>
                                            <div class="form-group">
                                                <br/>
                                                <h3>Start dateTime </h3>
                                                <input class="form-control" style="width:250px" type="date" id="sdate"/>
                                                <input class="form-control" style="width:250px" type="time" id="stime"/><br/>
                                                <br/>
                                                <h3>End dateTime </h3>
                                                <input class="form-control" style="width:250px"  type="date" id="edate"/>
                                                <input class="form-control" style="width:250px"  type="time" id="etime"/><br/>
                                                `   <br/>
                                            </div>
                                            <span class="span-col" id="errorDateTime"></span><br/>
                                            <a href="" onclick="add_lab();
                                                    return false;">Add lab</a> <br/><br/>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3">
                                        <table id="LLLL" hidden>
                                            <tr>
                                               <!-- <td>
                                                    <h3>Assigned Lab</h3><br/>
                                                    <div id="AssignedLab" style="border:2px solid #ccc; width:270px; height: 350px; overflow: auto;">
                                                    </div><br/>
                                                    <a href="" onclick="remove_lab();
                                                            return false;">Remove</a>  
                                                </td>-->
                                                <td>
                                                    <h3>New Labs</h3><br/>
                                                    <div id="NewLab" name="NewLab" class="list_labs" style="border:2px solid #ccc; width:270px; height: 350px; overflow: auto;">
                                                    </div><br/>
                                                    <a href="" onclick="remove_lab();
                                                            return false;">Remove</a>  
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <!--  <tr>
                                   <td colspan="3">
                                        <h3>Assigned Lab</h3><br/>
                                        <div id="RemovedLab" style="border:2px solid #ccc; width:300px; height: 350px; overflow: auto;">
                                        </div><br/>
                                        <a href="" onclick="remove_lab();
                                                return false;">undo</a> 
                                    </td>
                                </tr>-->
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" class="btn btn-create block full-width m-b" />

                                    </td>
                                    <td></td>
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

