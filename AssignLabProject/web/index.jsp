<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>


        <!-- General meta information -->
        <title>Login Form</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="robots" content="index, follow" />
        <!-- // General meta information -->


        <!-- Load Javascript -->
        <script type="text/javascript" src="http://localhost:8080/AssignLabProject/loginjs/jquery.js"></script>
        <script type="text/javascript" src="http://localhost:8080/AssignLabProject/loginjs/jquery.query-2.1.7.js"></script>
        <script type="text/javascript" src="http://localhost:8080/AssignLabProject/loginjs/rainbows.js"></script>
        <!-- // Load Javascipt -->

        <!-- Load stylesheets -->
        <link type="text/css" rel="stylesheet" href="http://localhost:8080/AssignLabProject/logincss/style.css" media="screen" />
        <!-- // Load stylesheets -->

        <script>


            $(document).ready(function () {

                $("#submit1").hover(
                        function () {
                            $(this).animate({"opacity": "0"}, "slow");
                        },
                        function () {
                            $(this).animate({"opacity": "1"}, "slow");
                        });
            });


        </script>

    </head>
    <body>
        <form action="LoginServlet" method="post">
            <div id="wrapper">
                <div id="wrappertop"></div>

                <div id="wrappermiddle">

                    <h2>Login</h2>

                    <div id="username_input">

                        <div id="username_inputleft"></div>

                        <div id="username_inputmiddle">
                            
                                <input type="text" name="user" id="url" value="E-mail Address" onclick="this.value = ''"/>
                                <img id="url_user" src="http://localhost:8080/AssignLabProject/loginimages/mailicon.png" alt=""/>
                            
                        </div>

                        <div id="username_inputright"></div>

                    </div>

                    <div id="password_input">

                        <div id="password_inputleft"></div>

                        <div id="password_inputmiddle">
                            
                                <input type="password" name="pwd" id="url" value="Password" onclick="this.value = ''">
                                    <img id="url_password" src="http://localhost:8080/AssignLabProject/loginimages/passicon.png" alt=""/>
                            
                        </div>

                        <div id="password_inputright"></div>

                    </div>

                    <div id="submit">

                        <!--<input type="image" src="./loginimages/submit_hover.png" id="submit1" value="Sign In">
                        <input type="image" src="./loginimages/submit.png" id="submit2" value="Sign In">-->
                        <button type="submit" class="btn btn-logout block full-width m-b">Sign In</button>

                    </div>


                    <div id="links_left">

                        <a href="#">Forgot your Password?</a>

                    </div>


                </div>

                <div id="wrapperbottom"></div>

                <div id="powered">
                </div>
            </div>
        </form>
    </body>
</html>