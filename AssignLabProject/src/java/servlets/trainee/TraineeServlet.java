/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.trainee;

import DAO.GroupDAO;
import DAO.LabDAO;
import DAO.QueueDAO;
import Impl.NotificationImpl;
import Impl.QueueImpl;
import Interfaces.NotificationInt;
import Interfaces.QueueInt;
import Pojo.Group;
import Pojo.Lab;
import Pojo.Notification;
import Pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
public class TraineeServlet extends HttpServlet {

    QueueInt queueInt = new QueueImpl();
    NotificationInt notificationInt = new NotificationImpl();

    public List<User> getDeliveryQueueUser(Lab lab) {
        // QueueDAO qd=new QueueDAO();
        //  return qd.getTraineeInDeliveryQueue(lab);

        List users = queueInt.getTraineeInDeliveryQueue(lab);
        return users;
    }

    public List<User> getAssQueueUser(Lab lab) {

        List users = queueInt.getTraineeInAssistanceQueue(lab);
        return users;

    }

    public Notification getNotification(User user) {
        return notificationInt.getNotification(user);

    }

    public List<Group> getGroup(User user) {

        return queueInt.getUserGroups(user);

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
        PrintWriter out = response.getWriter();
        out.println(" request dao ");
        //get current user from session
        //  User u =new User();//from session
        //  LabDAO ld=new LabDAO();       
        //  Lab lab=ld.getCurrentActiveLab(u);
        //   List<User> deliveryUsers=getDeliveryQueueUser(u,lab);
        //   List<User> assUsers=getAssQueueUser(u,lab);
        //   List<Group> groups=getGroups(u);
        //set all as variable on session
        //forward on main Trainee jsp view  
        //from jsp  use foreach get all lists from session and display it in view 

        /////////////////////
       /* List<User> users=new ArrayList<User>();
         User u1=new User();
         u1.setName("sara");
         u1.setIdUser(1);
         u1.setPass("123");
         users.add(u1);
         */
        HttpSession session = request.getSession(true);
        //User user = new User();
//        user.setName("heba");
//        user.setIdUser(2);
//        user.setPass("123");
        /* users.add(u2);
       
         User u3=new User();
         u3.setName("raniaa");
         u3.setIdUser(3);
         u3.setPass("123");
         users.add(u3);
        
         User u4=new User();
         u3.setName("gehad");
         u3.setIdUser(5);
         u3.setPass("12367");
         users.add(u4);*/
        Lab lab;
        User user = (User) session.getAttribute("user");
        if ((Integer) session.getAttribute("labfound") == 1) {
            lab = (Lab) session.getAttribute("lab");//new Lab();
            List assistanceQueue = getAssQueueUser(lab);
            List deliveryQueue = getDeliveryQueueUser(lab);
            Notification notification = getNotification(user);

            if (notification != null) {
                request.setAttribute("notification", notification.getMessage());
            } else {
                request.setAttribute("notification", " ");
            }

            request.setAttribute("deliveryQueue", deliveryQueue);
            request.setAttribute("assistanceQueue", assistanceQueue);
        } else {
            lab = new Lab();
        }
        List groupList = getGroup(user);
        request.setAttribute("groupList", groupList);
        System.out.println(groupList.size());
      //  lab.setDescription("lab1");
        //   lab.setName("lab1");
        // lab.setIdLab(1);

        RequestDispatcher requestdispatcher = request.getRequestDispatcher("/view/StudentView/index.jsp");
        requestdispatcher.forward(request, response);

        //////////////////////////////
    }
}
