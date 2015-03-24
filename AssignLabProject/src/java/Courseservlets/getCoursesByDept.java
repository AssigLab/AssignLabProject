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
import Pojo.Lab;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JETS_ITI
 */
public class getCoursesByDept extends HttpServlet {

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
        String departname = request.getParameter("deptname");
        // get department obj from name
        DepartInt dObj = new DepartImpl();
        Department deprtObj = new Department();
        deprtObj.setName(departname);
        List depts = dObj.getDepartByName(deprtObj);
        System.out.println("dept name="+((Department) depts.get(0)).getName());
        CourseInt cObj = new CourseImpl();
        List courses = cObj.getAllActiveCourses((Department) depts.get(0));
        System.out.println("course size="+courses.size());
        PrintWriter out = response.getWriter();
        out.print("<courses>");
        for (int i = 0; i < courses.size(); i++) {
            out.print("<course>");
            out.print("<c_name>");
            out.print(((Course) courses.get(i)).getName());
            out.print("</c_name>");
            out.print("<c_description>");
            out.print(((Course) courses.get(i)).getDescription());
            out.print("</c_description>");
            // get all labs
            out.print("<all_labs>");
            Set labs = ((Course) courses.get(i)).getLabs();
            // create an iterator
            Iterator iterator = labs.iterator();

            // check values
            while (iterator.hasNext()) {
                Lab Obj = (Lab) iterator.next();
                out.print("<lab>");
                out.print("<labID>");
                out.print(Obj.getIdLab());
                out.print("</labID>");
                out.print("<labName>");
                out.print(Obj.getName());
                out.print("</labName>");
                out.print("<labStart>");
                out.print(Obj.getStartDate());
                out.print("</labStart>");
                out.print("<labEnd>");
                out.print(Obj.getEndDate());
                out.print("</labEnd>");
                out.print("</lab>");
            }

            out.print("</all_labs>");
            out.print("</course>");

        }
        out.print("</courses>");
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
