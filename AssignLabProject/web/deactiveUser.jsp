<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Deactivate User</title>

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
            var xml_users = [];
            
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
                            $('#deptsall_Up').append('<option value="' + departname.childNodes[0].nodeValue + '" > ' + departname.childNodes[0].nodeValue + '</option><br />');

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
                var typeVal= document.getElementById("role").value;
                if (selVal == "" && typeVal=="") {
                    document.getElementById("submitting").hidden = true;
                    document.getElementById("names").hidden = true;
                }
                else if (selVal != "" && typeVal!="") {
                    document.getElementById("submitting").hidden = true;
                    document.getElementById("names").hidden = false;
                    if (window.XMLHttpRequest)
                    {// code for IE7+, Firefox, Chrome, Opera, Safari
                        xmlhttp2 = new XMLHttpRequest();
                    }
                    else if (window.ActiveXObject)
                    {// code for IE6, IE5
                        xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    xmlhttp2.onreadystatechange = handleStateChange;
                    xmlhttp2.open("POST", "http://localhost:8080/AssignLabProject/getUserbyDept?deptname=" + selVal+"&type="+typeVal, true);
                    xmlhttp2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    xmlhttp2.send(null);
                }
            }
            
            function handleStateChange() {
                if (xmlhttp2.readyState == 4) {
                    var xmlDoc = xmlhttp2.responseXML;
                    var users = xmlDoc.getElementsByTagName("user");
                    if (users.length == 0) {
                        document.getElementById("names").hidden = false;
                        document.getElementById("submitting").hidden = true;
                    }
                    for (var i = 0; i < users.length; i++) {
                        document.getElementById("names").hidden = false;
                        document.getElementById("submitting").hidden = true;
                        o = users[i];
                        xml_users.push(o);
                        $('#names').append('<option value="' + o.childNodes[2].childNodes[0].nodeValue + '" > ' + o.childNodes[0].childNodes[0].nodeValue + '</option><br />');
                    }
                }
            }
            
            function onSelectUser(){
                var names = document.getElementById("names").value;
                if(names != "" ){
                     document.getElementById("submitting").hidden = false;
                }
                else{
                     document.getElementById("submitting").hidden = true;
                }
            }
            
            function checkRole() {
                var role = document.getElementById("role").value;
                var selVal = document.getElementById("deptsall").value;
                if(selVal != "" && role!=""){
                     document.getElementById("submitting").hidden = true;
                    document.getElementById("names").hidden = false;
                }
                else{
                     document.getElementById("submitting").hidden = true;
                    document.getElementById("names").hidden = true;
                }
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
                            <li><a href="Course.jsp" class="m4">Course</a></li>
                            <li class="current"><a href="User.jsp" class="m5">User</a></li>
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
                       <li><span><a href="AddUser.jsp">Create User</a></span></li>
                        <li><span><a href="UpdateUser.jsp">Update User</a></span></li>
                        <li><span><a href="#">Delete User</a></span></li>
                        <li class="last"><span><a href="deactiveUser.jsp">Deactivate User</a></span></li>
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
                        <form class="m-t" onsubmit="return CheckAndSubmit()"  method="post" action="validDeactUser">
                            <table class="form_table">
                                <tr>
                                    <td colspan="3">
                                        <div id="form_header">Deactivate User</div>
                                    </td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <h3>Select Role</h3>
                                    </td>
                                    <td>
                                        <div>
                                           <select class="form-control" onchange="checkRole()" name="role" id="role">
                                                <option selected="selected" value="" selected="selected">Choose...</option>
                                                <option value="trainee">Trainee</option>
                                                <option value="staff">Staff</option>
                                                <option value="admin">Admin</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="span-col" id="create-span"></span>
                                    </td>
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
                                        <h3>Select User</h3>
                                    </td>
                                    <td>
                                        <div>
                                           <select class="form-control" hidden name="names" onchange="onSelectUser()" id="names">
                                                <option selected="selected" value="" selected="selected">Choose...</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="span-col" id="create-span"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3">
                                        <input type="submit" hidden id="submitting" class="btn btn-create block full-width m-b" />

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

