/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.trainee;

import Impl.QueueImpl;
import Interfaces.QueueInt;
import Pojo.Lab;
import Pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rania
 */
public class CancelAssistanceQueueRequest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
     QueueInt queueInt=new QueueImpl();

    public boolean cancelRequestInAssistanceQueue(User user,Lab lab){        
       // QueueDAO qd=new QueueDAO();
      //  return qd.getTraineeInDeliveryQueue(lab);
        
        
      boolean check= queueInt.cancelRequestInAssistanceQueue(user, lab);
        return check;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         boolean flag;
       
        User user=new User();
    //    user.setName("sara");
        user.setIdUser(3);
     //   user.setPass("123");
         Lab lab=new Lab();
    //    lab.setDescription("lab1");
      //  lab.setName("lab1");
        lab.setIdLab(1);
        flag=cancelRequestInAssistanceQueue(user, lab);
       // flag=true;
        if (flag==true)
        {
            System.out.println("Flag"); 
                 out.println(" request dao ");
        RequestDispatcher requestdispatcher=request.getRequestDispatcher("QueueServlet");
       System.out.println("done");
            out.println(" request dao ");
            requestdispatcher.forward(request,response);
                 out.println(" request dao ");
        }
        
        else {
            
                request.setAttribute("cantRequestAsssistance", "you arent in queue already"); 
                 RequestDispatcher requestdispatcher=request.getRequestDispatcher("QueueServlet");
                System.out.println("done");
            out.println(" request dao ");
            requestdispatcher.forward(request,response);
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
