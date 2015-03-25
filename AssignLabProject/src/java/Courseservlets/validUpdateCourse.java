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
import Pojo.Department;
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
public class validUpdateCourse extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        String deptname = request.getParameter("AllDepart_Up");

        String selected_Course = request.getParameter("AllCourse");
        if (!name.trim().equals("") && !desc.trim().equals("") && !deptname.trim().equals("") && !selected_Course.trim().equals("")) {

            // get department obj from name
            DepartInt dObj = new DepartImpl();
            Department deprtObj = new Department();
            deprtObj.setName(deptname);
            List depts = dObj.getDepartByName(deprtObj);

            // set data on course object
            CourseInt cObj = new CourseImpl();
            Course courseObj = new Course();
            courseObj.setName(selected_Course);
            // get course id
            List courses = cObj.getCourseByName(courseObj);

            courseObj.setIdCourse(((Course) courses.get(0)).getIdCourse());
            courseObj.setName(name);
            courseObj.setDescription(desc);
            courseObj.setIsActive(0);
            courseObj.setDepartment((Department) depts.get(0));

            cObj.update(courseObj);
            request.setAttribute("SuccessOp", "Successful");
            RequestDispatcher dispatcher1 = request.getRequestDispatcher("/updateCourse.jsp");
            dispatcher1.forward(request, response);

        } else {
            response.sendRedirect("updateCourse.jsp");
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
