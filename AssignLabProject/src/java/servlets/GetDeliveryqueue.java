/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.LabDAO;
import Pojo.Lab;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;

/**
 *
 * @author Muhammad Lupate
 */
public class GetDeliveryqueue extends HttpServlet {

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

            String selectedLab = request.getParameter("lab");
            System.out.println("selected Lab: " + selectedLab);

            Lab labName = new Lab();
            labName.setName(selectedLab);

            Lab lab = new LabDAO().getLabByName(labName);

            System.out.println(lab.getName());

//            request.getSession().setAttribute("delivery", list);
            request.getSession().setAttribute("lab", lab);
//            request.setAttribute("lab", selectedLab);

//            RequestDispatcher requestDispatcher
//                    = request.getRequestDispatcher("/StuffView/viewQueue.jsp");
//            requestDispatcher.forward(request, response);
            response.sendRedirect("/StaffSystem/StuffView/viewQueue.jsp");

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

    private ArrayList<String> getDeliveryQueue(String selectedLab) {
        ArrayList<String> list = new ArrayList<>();
        if (selectedLab.equals("lab1")) {
            list.add("Muhammad");
            list.add("Mahmoud");
            list.add("Mahmoud");
            list.add("Mahmoud");

        }
        return list;
    }

}
