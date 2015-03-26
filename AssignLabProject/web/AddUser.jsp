<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Create User</title>

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

            function checkRole() {
                var role = document.getElementById("role").value;
                if (role != "") {
                    if (role == "trainee")
                        document.getElementById("intake").hidden = false;
                    else
                        document.getElementById("intake").hidden = true;
                }
                else {
                    document.getElementById("intake").hidden = true;
                }
            }

            function checkEmail() {
                var regexEmail = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
                var email=document.getElementById("email").value;
                if (email.trim() != "") {
//                    if (!regexEmail.test(email.value)) {
//                        document.getElementById("errorEmail").innerHTML = "Please,Correct Email";
//                    }
//                    else {
//                        document.getElementById("errorEmail").innerHTML="";
                        var req;
                        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                            req = new XMLHttpRequest();
                        }
                        else {// code for IE6, IE5
                            req = new ActiveXObject("Microsoft.XMLHTTP");
                        }
                        req.onreadystatechange = function() {
                            if (req.readyState == 4 && req.status == 200) {
                                document.getElementById("errorEmail").innerHTML = req.responseText;
                            }
                        }
                        var vvv = document.getElementById("email").value;
                        req.open("POST", "http://localhost:8080/AssignLabProject/getEmailUser?email=" + vvv, true);
                        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                        req.send(null);
//                    }
                }
            }

            function CheckAndSubmit() {
                if (document.getElementById("errorEmail").innerHTML.trim() == "" && document.getElementById("errorphone").innerHTML.trim() == ""  
                 && document.getElementById("deptsall").value.trim() != "" && document.getElementById("role").value.trim() != "") {
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
                        <form class="m-t" onsubmit="return CheckAndSubmit()"  method="post" action="validAddUser">
                            <table class="form_table">
                                <tr>
                                    <td colspan="3">
                                        <div id="form_header">Create User</div>
                                    </td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <h3>Name</h3>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <input type="text" name="name" class="form-control" placeholder="Name" required="">
                                        </div>
                                    </td>
                                    <td>
                                        <span class="span-col" id="errorName"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <h3>E-mail</h3>
                                    </td>
                                    <td>
                                        <br/>
                                        <div class="form-group">
                                            <input type="email" onblur="checkEmail()" id="email" name="email" class="form-control" placeholder="E-Mail" required="">
                                        </div>
                                    </td>
                                    <td>
                                        <br/>
                                        <span class="span-col" id="errorEmail"></span>
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
                                            <select class="form-control"  name="AllDepart" id="deptsall">
                                                <option selected="selected" value="" selected="selected">Choose...</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <br/>
                                        <span class="span-col" id="errorDepart"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br/>
                                        <h3>Role</h3>
                                    </td>
                                    <td>
                                        <br/>
                                        <div class="form-group">
                                            <select class="form-control" onchange="checkRole()" name="role" id="role">
                                                <option selected="selected" value="" selected="selected">Choose...</option>
                                                <option value="trainee">Trainee</option>
                                                <option value="staff">Staff</option>
                                                <option value="admin">Admin</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <br/>
                                        <span class="span-col" id="errorRole"></span>
                                    </td>
                                </tr>
                                <tr hidden id="intake">
                                    <td>
                                        <br/>
                                        <h3>Intake</h3>
                                    </td>
                                    <td>
                                        <br/>
                                        <div class="form-group">
                                            <input type="text" name="intake" class="form-control" placeholder="Intake">
                                        </div>
                                    </td>
                                    <td>
                                        <br/>
                                        <span class="span-col" id="errorIntake"></span>
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

