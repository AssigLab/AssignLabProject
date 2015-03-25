/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Impl.LabImpl;
import Interfaces.LabInt;
import Pojo.Course;
import Pojo.Lab;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Muhammad Lupate
 */
public class GetLabs extends HttpServlet {

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
           
            String selectedCourse = request.getParameter("course");
            System.out.println(selectedCourse);

            Course course = new Course();
            course.setName(selectedCourse);

            //call whatever to retrive List of labs
            LabInt labInt = new LabImpl();
            List<Lab> labs = labInt.getAllLab(course);

            System.out.println(labs);

            request.getSession().setAttribute("labs", labs);

            RequestDispatcher requestDispatcher
                    = request.getRequestDispatcher("/StuffView/GetLabs.jsp");
            requestDispatcher.forward(request, response);

//            response.sendRedirect("/StaffSystem/StuffView/GetLabs.jsp");
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

    private ArrayList<String> getLabs(String selectedCourse) {
        ArrayList<String> list = new ArrayList<>();
        if (selectedCourse.equals("course1")) {
            list.add("lab1");
            list.add("lab2");
            list.add("lab3");
        }
        return list;
    }

}
