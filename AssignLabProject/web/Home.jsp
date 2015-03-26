<!DOCTYPE html>
<html lang="en">
    <head>
        <title> Admin's View</title>
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
    <body id="page1">
        <!-- START PAGE SOURCE -->
        <div class="wrap">
            <header>
                <div class="container">
                    <h1><a href="#">Student's site</a></h1>
                    <nav>
                        <ul>
                            <li class="current"><a href="Home.jsp" class="m1">Home</a></li>
                            <li><a href="Group.jsp" class="m2">Group</a></li>
                            <li><a href="Department.jsp" class="m3">Department</a></li>
                            <li><a href="Course.jsp" class="m4">Course</a></li>
                            <li><a href="User.jsp" class="m5">User</a></li>
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
                    <h3>Categories</h3>
                    <ul class="categories">
                        <li><span><a href="#">About Us</a></span></li>
                        <li><span><a href="#">Contacts </a></span></li>
                        <li><span><a href="#">Show Statistics</a></span></li>
                        <li class="last"><span><a href="#">Calendar</a></span></li>
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
                    <div id="banner">
                        <h2>Professional <span>Management System  <span>Since 2015</span></span></h2>
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
