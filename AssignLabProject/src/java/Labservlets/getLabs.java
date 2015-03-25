/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labservlets;

import Impl.CourseImpl;
import Impl.LabImpl;
import Interfaces.CourseInt;
import Interfaces.LabInt;
import Pojo.Course;
import Pojo.Lab;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JETS_ITI
 */
public class getLabs extends HttpServlet {

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
        response.setContentType("text/xml");
        String coursename = request.getParameter("coursename");

        CourseInt cObj = new CourseImpl();
        Course courseObj = new Course();
        courseObj.setName(coursename);

        // get course object which has name on request
        List courses = cObj.getCourseByName(courseObj);

        // get all active labs of this course
        LabInt labintObj = new LabImpl();
        List labsList = labintObj.getAllLabActive((Course)courses.get(0));

        PrintWriter out = response.getWriter();
        out.print("<labs>");
        for (int i = 0; i < labsList.size(); i++) {
            out.print("<Lab>");
            out.print("<ID>");
            out.print(((Lab) labsList.get(i)).getIdLab());
            out.print("</ID>");
            out.print("<labStart>");
            out.print(((Lab) labsList.get(i)).getStartDate());
            out.print("</labStart>");
            out.print("<labEnd>");
            out.print(((Lab) labsList.get(i)).getEndDate());
            out.print("</labEnd>");
            out.print("</Lab>");

        }
        out.print("<labs>");
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
