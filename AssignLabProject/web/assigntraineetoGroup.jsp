<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Assign Trainee to Group</title>
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
                        <form class="m-t" role="form" action="Home.jsp">
                            <table class="form_table">
                                <tr>
                                    <td colspan="2">
                                        <div id="form_header">Assign Trainee to Group</div>
                                    </td>
                                    <td></td>

                                </tr>
                                <tr>
                                    <td>
                                        <h3>Select Group</h3>
                                    </td>
                                    <td>
                                        <div>
                                            <select class="form-control" >
                                                <option value="Group1">Group1</option>
                                                <option value="Group2">Group2</option>
                                                <option value="Group3">Group3</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <h3>Select Department</h3>
                                    </td>
                                    <td>
                                        <div>
                                            <select class="form-control" >
                                                <option value="EWD">EWD</option>
                                                <option value="SD">SD</option>
                                                <option value="MAD">MAD</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <h3>Select Trainee</h3>
                                    </td>
                                    <td>
                                        <div>

                                            <select class="form-control" >
                                                <option value="Heba">Heba</option>
                                                <option value="Rania">Rania</option>
                                                <option value="Sara">Sara</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <button type="button" class="btn btn-create block full-width m-b" ><a id="link_btn" href="#openModal">Add</a></button>

                                    </td>
                                    <td></td>
                                </tr>
                            </table>
                        </form>
                        <!--Modal Dialog for Update group  -->
                        <div id="openModal" class="modalDialog">
                            <div>

                                <a href="#close" title="Close" class="close">X</a>
                                <form class="m-t" role="form" action="Home.jsp">
                                    <table class="popup-form">
                                        <tr>
                                            <td colspan="2">
                                                <div id="popup_form_header">Assign Trainee To Group</div>
                                            </td>
                                            <td></td>

                                        </tr>
                                        <tr>
                                            <td>
                                                <h3>Group</h3>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <input type="text" class="form-control"  id="popup_txt1" placeholder="GroupName" readonly="" >
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h3>Department</h3>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <input type="text" class="form-control"  id="popup_txt1" placeholder="DepartmentName" readonly="" >
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h3>Trainee</h3>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <input type="text" class="form-control"  id="popup_txt1" placeholder="TraineeName" readonly="" >
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

