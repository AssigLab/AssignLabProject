/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupServlets;

import Impl.GroupImpl;
import Interfaces.GroupInt;
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
public class validateNameDeactivateGroup extends HttpServlet {

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
        String SelectName = request.getParameter("AllGroups");
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        GroupInt groupInt = new GroupImpl();
        if (!name.trim().equals("") && !desc.trim().equals("")) {
            Group group = new Group();
            // get id of group name
            group.setName(SelectName);
            List names = groupInt.getGroupByName(group);
            group.setIdGroup(((Group) names.get(0)).getIdGroup());
            group.setName(name);
            group.setDescription(desc);
            group.setIsActive(1);

            List l = groupInt.getGroupByName(group);
            if (l.size() > 0) {
                request.setAttribute("allactiveGroups", groupInt.getAllGroupActive());
                request.setAttribute("chName", "Name exist");
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("/deactivateGroup.jsp");
                dispatcher1.forward(request, response);
            } else {
                groupInt.deactivate(group);
                response.sendRedirect("SucessPage.jsp");
            }
        } else {
            response.sendRedirect("getAllGroups");
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
