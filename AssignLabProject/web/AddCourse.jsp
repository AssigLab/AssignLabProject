<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Create Course</title>
        <!--get All Active department from request --> 
        <c:set var="deptlist" value="${requestScope.allactiveDepart}"/>

        <meta charset="utf-8">
        <link rel="stylesheet" href="./css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="./css/style.css" type="text/css" media="all">
        <script type="text/javascript" src="./js/jquery-1.4.2.min.js" ></script>
        <script type="text/javascript" src="./js/cufon-yui.js"></script>
        <script type="text/javascript" src="./js/cufon-replace.js"></script>
        <script type="text/javascript" src="./js/Myriad_Pro_300.font.js"></script>
        <script type="text/javascript" src="./js/Myriad_Pro_400.font.js"></script>
        <script>
            // check user select depart
            function chooseDept() {
                var selVal = document.getElementById("deptsall").value;
                if (selVal == "") {
                    return false;
                }
                else if (selVal != "") {
                    return true;
                }
            }

            function add_lab() {
                var start_date = document.getElementById("sdate").value;
                var end_date = document.getElementById("edate").value;
                var start_time = document.getElementById("stime").value;
                var end_time = document.getElementById("etime").value;
                if (start_date.trim() != "" && end_date.trim() != "" && start_time.trim() != "" && end_time.trim() != "") {
                    if ((new Date(start_date + " " + start_time).getTime()) < (new Date(end_date + " " + end_time).getTime())) {
                        var alldates=start_date + " " + start_time + " , " + end_date + " " + end_time;
                        $('#containsLab').append('<label><input type="checkbox" class="list_labs" checked name="labs" value="'+alldates+'"/><label>' + alldates + "<br/>");
                        document.getElementById("errorDateTime").innerHTML = "";
                    } else {
                       
                        document.getElementById("errorDateTime").innerHTML = "check start date and time is before end date and time"
                    }
                }

                return false;
            }

            function remove_lab() {
                $(".list_labs:unchecked").parent().remove();
            }
            
            function checkName(){
                var req;
                if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
                   req=new XMLHttpRequest();
                }
                else{// code for IE6, IE5
                  req=new ActiveXObject("Microsoft.XMLHTTP");
                }
                req.onreadystatechange=function(){
                        if (req.readyState==4 && req.status==200){
                                document.getElementById("errorName").innerHTML=req.responseText;
                        }
                }
                var vvv=document.getElementById("name").value;
                req.open("GET" , "http://127.0.0.1:8080/AssignLabProject/validAddCourse?Name="+vvv,true);
                req.send(null);
            }
            
            function submitForm(){
                var c=0;
                if(document.getElementById("deptsall").value=="") {
                    document.getElementById("errorDepart").innerHTML="Choose Depart";
                    c++;
                }
                else{
                    document.getElementById("errorDepart").innerHTML="";
                    c--;
                }
                

                if(document.getElementById("errorName").innerHTML!=""){
                    c++;
                }
                else{
                    c--;
                }
                if(c==-2){
                    return true;
                }
                else{
                    return false;
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
                            <li><a href="index.jsp" class="m1">Home</a></li>
                            <li><a href="Group.jsp" class="m2">Group</a></li>
                            <li><a href="Department.jsp" class="m3">Department</a></li>
                            <li class="current"><a href="Course.jsp" class="m4">Course</a></li>
                            <li><a href="User.jsp" class="m5">User</a></li>
                            <li class="last"><button type="button" class="btn btn-logout block full-width m-b">Log Out</button></li>

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
                        <li><span><a href="beforeAddCourse">Create Course</a></span></li>
                        <li><span><a href="#">Update Course</a></span></li>
                        <li><span><a href="#">Delete Course</a></span></li>
                        <li><span><a href="beforeDeactCourse">Deactivate Course</a></span></li>
                        <li  class="last"><span><a href="#">Add Lab To Course</a></span></li>
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
                        <form class="m-t" role="form"  method="post" action="validAddCourse">
                            <table class="form_table">
                                <tr>
                                    <td colspan="3">
                                        <div id="form_header">Create Course</div>
                                    </td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <h3>Name</h3>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <input type="text" onblur="checkName()" name="name" class="form-control" placeholder="Course Name" required="">
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
                                            <textarea class="form-control" name="description" placeholder="Course  Description" required=""> </textarea>

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
                                            <select class="form-control"  name="AllDepart" id="deptsall">
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
                                    <td colspan="3">
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
                                                            return false;">Add lab</a> <br/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3">
                                        <div id="containsLab" style="border:2px solid #ccc; width:300px; height: 350px; overflow: auto;">
                                        </div><br/>
                                        <a href="" onclick="remove_lab();
                                                                    return false;">Remove</a>  
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" class="btn btn-create block full-width m-b" onclick="submitForm()" />

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

