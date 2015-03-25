/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Userservlets;

import Impl.DepartImpl;
import Impl.StaffImpl;
import Interfaces.DepartInt;
import Interfaces.UserInt;
import Pojo.Department;
import Pojo.User;
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
public class validUpdateUser extends HttpServlet {

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
        
        String selectEmail=request.getParameter("names");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String AllDepart=request.getParameter("AllDepart_Up");
        String role=request.getParameter("role_up");
        System.out.println("role="+role);
        String intake=request.getParameter("InputIntake");
        
        User Obj=new User();
        
        UserInt userint=new StaffImpl();
        System.out.println("emmm="+selectEmail);
        Obj.setEmail(selectEmail);
        List users=userint.GetUserByName(Obj);
        System.out.println("siiii="+users.size());
        Department deptObj=new Department();
        deptObj.setName(AllDepart);
        DepartInt deptInt=new DepartImpl();
        Obj.setIdUser(((User)users.get(0)).getIdUser());
        Obj.setDepartment((Department)(deptInt.getDepartByName(deptObj)).get(0));
        Obj.setName(name);
        Obj.setEmail(email);
        if(role.equals("admin")) Obj.setIsAdmin(1);
        else Obj.setIsAdmin(0);
        Obj.setOnline(1);
        Obj.setPass("12345678");
        Obj.setPosition("");
        if(role.equals("staff") || role.equals("admin")){
            Obj.setType(2);
            Obj.setIntake(0);
        }
        else {
            Obj.setType(1);
            Obj.setIntake(Integer.parseInt(intake));
        }

        userint.update(Obj);
        request.setAttribute("SuccessOp", "Successful");
        RequestDispatcher dispatcher1 = request.getRequestDispatcher("/UpdateUser.jsp");
        dispatcher1.forward(request, response);
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
