/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.trainee;

import Impl.QueueImpl;
import Interfaces.QueueInt;
import Pojo.Lab;
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
 * @author rania
 */
public class CancelDeliveryQueueRequest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    QueueInt queueInt = new QueueImpl();

    public int cancelRequestIndeliveryQueue(User user, Lab lab) {
       // QueueDAO qd=new QueueDAO();
        //  return qd.getTraineeInDeliveryQueue(lab);

        int check = queueInt.cancelRequestIndeliveryQueue(user, lab);
        return check;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int flag;

        HttpSession session = request.getSession(true);
        Lab lab;
        User user = (User) session.getAttribute("user");

        if ((Integer) session.getAttribute("labfound") == 1) {
            lab = (Lab) session.getAttribute("lab");//new Lab()
            flag = cancelRequestIndeliveryQueue(user, lab);
            // flag=true;
            if (flag == 2) {
                System.out.println("Flag");
                out.println(" request dao ");
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("QueueServlet");
                System.out.println("done");
                out.println(" request dao ");
                requestdispatcher.forward(request, response);
                out.println(" request dao ");
            } else if (flag == 3) {

                request.setAttribute("cantRequestDelivery", "you arent in queue already");
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("QueueServlet");
                System.out.println("done");
                out.println(" request dao ");
                requestdispatcher.forward(request, response);
            } else if (flag == 1) {

                request.setAttribute("cantRequestDelivery", "sry lab is closed");
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("QueueServlet");
                System.out.println("done");
                out.println(" request dao ");
                requestdispatcher.forward(request, response);
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
