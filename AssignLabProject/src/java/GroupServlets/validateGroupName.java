/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupServlets;

import Impl.*;
import Interfaces.*;
import Pojo.Department;
import Pojo.Group;
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
 * @author it
 */
public class validateGroupName extends HttpServlet {

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
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        if (!name.trim().equals("") && !desc.trim().equals("")) {
            System.out.println("name and desc");
            PrintWriter out = response.getWriter();
            GroupInt groupint=new GroupImpl();
            Group group = new Group(name, desc, 0);

            /*List groups = null;
            groups = groupint.ge(group);
            if (groups.size() > 0) {
                System.out.println("found");
                request.setAttribute("chName", "Name exist");
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("/createGroup.jsp");
                dispatcher1.forward(request, response);
            } else {*/
                group.setName(name);
                group.setDescription(desc);
                group.setIsActive(0);
                groupint.create(group);
                response.sendRedirect("Group.jsp");
            //}

        } else {
            System.out.println("Missing Param");
            response.sendRedirect("createGroup.jsp");
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
