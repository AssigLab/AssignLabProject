/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.StaffDAO;
import DAO.TraineeDAO;
import Pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
public class checklogging extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        if (session.isNew()) {

            System.out.println("new session");
            RequestDispatcher requestdispatcher = request.getRequestDispatcher("/login.jsp");
            requestdispatcher.forward(request, response);
        } else {
            System.out.println("old session");
            User u = new User();
        //Check if this is new comer on your web page.
            // get request parameters for userID and password
            u = (User) session.getAttribute("user");
            System.out.println(u);

            StaffDAO sd = new StaffDAO();
            //u=sd.SelectOneActive(u);
            if (u.getName() != null) {

                if (u.getName().equals("staff")) {
                    //user is staff
                    session.setAttribute("user", u);
                   // sd.getAlllInitDataForStaff(u, session);//

                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("/AdminView/index.jsp");
                    requestdispatcher.forward(request, response);
                } else {
                    TraineeDAO td = new TraineeDAO();
           // u=td.SelectOneActive(u);
                    //if(u!=null){
                    if (u.getName().equals("trainee")) {
                        //user is student
                        session.setAttribute("user", u);
//                        td.getAlllInitDataForStaff(u, session);//
                        RequestDispatcher requestdispatcher = request.getRequestDispatcher("/StudentView/index.jsp");
                        requestdispatcher.forward(request, response);
                    } else {
                        //user not found
                        RequestDispatcher requestdispatcher = request.getRequestDispatcher("/login.jsp");
                        requestdispatcher.forward(request, response);
                    }
                }
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
