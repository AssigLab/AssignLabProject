/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.StaffDAO;
import DAO.TraineeDAO;
import Pojo.Lab;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Pojo.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";

    protected void getSession(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Create a session object if it is already not  created.
        HttpSession session = request.getSession(true);
        // Get session creation time.
//        Date createTime = new Date(session.getCreationTime());
//       // Get last access time of this web page.
//        Date lastAccessTime =new Date(session.getLastAccessedTime());
//        String userIDKey = new String("userID");
//        String userID = new String("ABCD");
        User u;
        // Check if this is new comer on your web page.
        // get request parameters for userID and password

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        System.out.println(user + " " + pwd);
        if (session.isNew()) {
            u = new User();

            System.out.println(user);
            //check for user logging if admin 

            u.setName(user);
            u.setPass(pwd);
            session.setAttribute("user", u);
            System.out.println("new session");

        } else {
            u = (User) session.getAttribute("user");
            if (u == null) {
                u = new User();
                u.setName(user);
                u.setPass(pwd);

                System.out.println("user is null ");
            }
            System.out.println("old session");
        }
        TraineeDAO td = new TraineeDAO();
        u = td.SelectOneActive(u);
        if (u != null) {
            session.setAttribute("user", u);

            if (u.getType() == 2) {
                System.out.println(u.getName() + " user is staff");
        //if(u.getName().equals("staff")){
                //user is staff

                //   sd.getAlllInitDataForStaff(u,session);//
                //RequestDispatcher requestdispatcher=request.getRequestDispatcher("/StaffView/index.jsp");
                if (u.getIsAdmin() == 1) {
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("Home.jsp");
                    requestdispatcher.forward(request, response);
                } else {
                    //is staff
                    System.out.println("inside STAFF");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("GetGroups");
                    requestdispatcher.forward(request, response);

                }
            } else if (u.getType() == 1) {

                //if(u.getName().equals("trainee")){
                System.out.println("is trainee");
                session.setAttribute("user", u);
                Lab lab = td.getAlllInitDataForTrinee(u, session);
                if (lab != null) {
                    session.setAttribute("labfound", 1);
                    session.setAttribute("lab", lab);
                    System.out.println("lab from session " + session.getAttribute("lab") + "  " + lab.getName());
                } else {
                    session.setAttribute("labfound", 0);
                    System.out.println("no labs");
                }

                RequestDispatcher requestdispatcher = request.getRequestDispatcher("/QueueServlet");
                requestdispatcher.forward(request, response);
                //user is student
                //session.setAttribute("user", u);
                //  td.getAlllInitDataForStaff(u,session);
                //

                List<User> users = new ArrayList<User>();
                User u1 = new User();
                u1.setName("sara");
                u1.setIdUser(1);
                u1.setPass("123");
                users.add(u1);

                User u2 = new User();
                u2.setName("heba");
                u2.setIdUser(2);
                u2.setPass("123");
                users.add(u2);

                User u3 = new User();
                u3.setName("raniaa");
                u3.setIdUser(3);
                u3.setPass("123");
                users.add(u3);

                //request.setAttribute("assistanceQueue", users);
                //request.setAttribute("deliveryQueue", users);
                //
//                RequestDispatcher requestdispatcher = request.getRequestDispatcher("/StudentView/StudentView.jsp");
//                requestdispatcher.forward(request, response);
            } else {
                //user not found
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("/index.jsp");
                requestdispatcher.forward(request, response);
            }
        }

            //get user for user_name=user  from db
        //if user !=null{
        //if role=1 --> user is trainee
        //set cookie 
        //and send redirect to trainee jsp
        //else if  role=2--> user is admin
        //set cookie or set user in session
        //and send redirect to admin.jsp
        //
//            if(userID.equals(user) && password.equals(pwd)){
//            
//            session.setAttribute("user", "Pankaj");
//            //setting session to expiry in 30 mins
//            session.setMaxInactiveInterval(30*60);
//            Cookie userName = new Cookie("user", user);
//            userName.setMaxAge(30*60);
//            response.addCookie(userName);
//            response.sendRedirect("LoginSuccess.jsp");
//        }else{
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//            PrintWriter out= response.getWriter();
//            out.println("<font color=red>Either user name or password is wrong.</font>");
//            rd.include(request, response);
        //      }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        getSession(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        getSession(request, response);
        // RequestDispatcher requestdispatcher=request.getRequestDispatcher("/login.jsp");
        // requestdispatcher.forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
