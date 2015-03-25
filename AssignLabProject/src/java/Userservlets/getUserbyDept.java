/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Userservlets;

import Impl.CourseImpl;
import Impl.DepartImpl;
import Impl.StaffImpl;
import Impl.TraineeImpl;
import Interfaces.CourseInt;
import Interfaces.DepartInt;
import Interfaces.UserInt;
import Pojo.Course;
import Pojo.Department;
import Pojo.Lab;
import Pojo.User;
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
public class getUserbyDept extends HttpServlet {

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
        String type = request.getParameter("type");
        // get department obj from name
        DepartInt dObj = new DepartImpl();
        Department deprtObj = new Department();
        deprtObj.setName(departname);
        List depts = dObj.getDepartByName(deprtObj);

        UserInt cObj=null;
        if(type.trim().equals("admin") || type.trim().equals("staff"))  cObj = new StaffImpl();
        else cObj = new TraineeImpl();
        
        List users = cObj.GetAllUserDepartActive((Department) depts.get(0));
        System.out.println("Length="+users.size());
        PrintWriter out = response.getWriter();
        out.print("<users>");
        for (int i = 0; i < users.size(); i++) {
            out.print("<user>");
            out.print("<c_name>");
            out.print(((User) users.get(i)).getName());
            out.print("</c_name>");
            out.print("<pass>");
            out.print(((User) users.get(i)).getPass());
            out.print("</pass>");
            out.print("<email>");
            out.print(((User) users.get(i)).getEmail());
            out.print("</email>");
            out.print("<intake>");
            out.print(((User) users.get(i)).getIntake());
            out.print("</intake>");
            out.print("<isadmin>");
            out.print(((User) users.get(i)).getIsAdmin());
            out.print("</isadmin>");
            out.print("</user>");
        }
        out.print("</users>");
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
