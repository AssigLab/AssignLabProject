/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Impl.GroupImpl;
import Interfaces.GroupInt;
import Pojo.Group;
import Pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Muhammad Lupate
 */
public class GetGroups extends HttpServlet {

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
        System.out.println("getGroup");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            //get the userObj from the session ..
            User user = (User) session.getAttribute("user");
            System.out.println(user.getName());
//                    new User();
//            user.setIdUser(1);
//            user.setName("Muhammad Edmerdash");
            if (user != null) {
                System.out.println("user is not null in get group");
                GroupInt groupInt;
                List<Group> groups;
                groupInt = new GroupImpl();
                groups = groupInt.getUserGroup(user);
                System.out.println("groups length "+groups.size());
                request.getSession().setAttribute("user", user);

                System.out.println(groups);
                                
                request.getSession().setAttribute("groups", groups);

                RequestDispatcher requestDispatcher
                        = request.getRequestDispatcher("StuffView/GetDepartments.jsp");
                requestDispatcher.forward(request, response);
//            response.sendRedirect("/StaffSystem/StuffView/GetDepartments.jsp");
            } else {
                System.out.println("user is null in get group");
                RequestDispatcher requestDispatcher
                        = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request, response);
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
        processRequest(request, response);
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
