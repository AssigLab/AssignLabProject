/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Impl.CourseImpl;
import Interfaces.CourseInt;
import Pojo.Course;
import Pojo.Group;
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
public class GetCourses extends HttpServlet {

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

            String selectedGroup = request.getParameter("dept");

            System.out.println("from GETCourses " + selectedGroup);

            Group group = new Group();
            group.setName(selectedGroup);

            //call whatever to retrive List of Courses
            CourseInt courseInt = new CourseImpl();
            List<Course> courses = courseInt.getAllCoursesAssignedToGroup(group);

            System.out.println(courses);

            request.getSession().setAttribute("courses", courses);

            RequestDispatcher requestDispatcher
                    = request.getRequestDispatcher("/StuffView/GetCourses.jsp");
            requestDispatcher.forward(request, response);

//            response.sendRedirect("/StaffSystem/StuffView/GetCourses.jsp");
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

    private ArrayList<String> getCourses(String selectedDept) {
        ArrayList<String> list = new ArrayList<>();
        if (selectedDept.equals("dept1")) {
            list.add("course1");
            list.add("course2");
            list.add("course3");
        }
        return list;
    }

}
