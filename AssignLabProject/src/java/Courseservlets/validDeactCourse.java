/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Courseservlets;

import Impl.CourseImpl;
import Impl.DepartImpl;
import Interfaces.CourseInt;
import Interfaces.DepartInt;
import Pojo.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JETS_ITI
 */
public class validDeactCourse extends HttpServlet {

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
        DepartInt Obj = new DepartImpl();
        String SelectName = request.getParameter("AllCourse");
        CourseInt cObj = new CourseImpl();
        if (!SelectName.trim().equals("")) {
            Course courseObj = new Course();
            // get id of department name
            courseObj.setName(SelectName);
            List names = cObj.getCourseByName(courseObj);
            courseObj = (Course) names.get(0);
            courseObj.setIsActive(1);
            if (names.size() > 0) {
                System.out.println("HJJJJUYY");
                cObj.update(courseObj);
                request.setAttribute("SuccessOp", "Successful");
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("/deactiveCourse.jsp");
                dispatcher1.forward(request, response);
            } else {
                request.setAttribute("allactiveDepart", Obj.GetAllDepartActive());
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("/deactiveCourse.jsp");
                dispatcher1.forward(request, response);
            }
        } else {
            response.sendRedirect("beforeDeactCourse");
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
