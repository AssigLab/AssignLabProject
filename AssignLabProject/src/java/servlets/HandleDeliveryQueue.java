/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Impl.QueueImpl;
import Impl.TraineeImpl;
import Interfaces.QueueInt;
import Interfaces.UserInt;
import Pojo.Lab;
import Pojo.User;
import Pojo.UserDelivery;
import Pojo.UserDeliveryId;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Muhammad Lupate
 */
public class HandleDeliveryQueue extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            String userName = request.getParameter("hidden");

            User user = new User();
            user.setName(userName);

            UserInt ui = new TraineeImpl();
            User userRet = ui.getUserByName(user);

            System.out.println(userRet.getIdUser());

            QueueInt int1 = new QueueImpl();

            if (request.getParameter("pick") != null) {
                //first Servlet
               //int1.updateDeliveryQueue(userRet);

            } else if (request.getParameter("dequeue") != null) {
                //second    
               // int1.updateDeliveryQueue_dequeue(userRet);
            }
//            RequestDispatcher requestDispatcher
//                    = request.getRequestDispatcher("/StuffView/viewQueue.jsp");
//            requestDispatcher.forward(request, response);
            response.sendRedirect("StuffView/viewQueue.jsp");
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
