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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JETS_ITI
 */
public class validAddCourse extends HttpServlet {

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
        String desc = request.getParameter("description");
        String deptname = request.getParameter("AllDepart");
        String [] labs=request.getParameterValues("labs");
        if (!name.trim().equals("") && !desc.trim().equals("") && !deptname.trim().equals("")) {

            PrintWriter out = response.getWriter();

            // get department obj from name
            DepartInt dObj = new DepartImpl();
            Department deprtObj = new Department();
            deprtObj.setName(deptname);
            List depts = dObj.getDepartByName(deprtObj);

            HashSet allLabs=new HashSet();
            for(int i=0;i<labs.length;i++){
                StringTokenizer f=new StringTokenizer(labs[i], ",");
                ArrayList<String> splitting=new ArrayList<>();
                while(f.hasMoreTokens()){
                    splitting.add(f.nextToken());
                }
                Lab labObj=new Lab();
                DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date d2 = df2.parse(splitting.get(0).trim()+":00");
                    labObj.setStartDate(d2);
                    d2 = df2.parse(splitting.get(1).trim()+":00");
                    labObj.setEndDate(d2);
                    
                    labObj.setName("lab"+i+1);
                    labObj.setDescription("");
                    labObj.setEnableUpload(0);
                    labObj.setUploadEndDate(d2);
                    allLabs.add(labObj);
                } catch (ParseException ex) {
                    Logger.getLogger(validAddCourse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // set data on course object
            CourseInt cObj = new CourseImpl();
            Course courseObj = new Course();
            courseObj.setName(name);
            courseObj.setDescription(desc);
            courseObj.setIsActive(0);
            courseObj.setDepartment((Department) depts.get(0));
            courseObj.setLabs(allLabs);
            
            // check course name is duplicate
            List courses = cObj.getCourseByName(courseObj);
            if (courses.size() > 0) {
                System.out.println("HHHHH22");
                request.setAttribute("chName", "Name exist");
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("/AddCourse.jsp");
                dispatcher1.forward(request, response);
            } else {
                cObj.create(courseObj);
                response.sendRedirect("SucessPage.jsp");
            }

        } else {
            System.out.println("HHHHH444");
            response.sendRedirect("AddCourse.jsp");
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
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        if(!name.trim().equals("")){
        CourseInt cObj = new CourseImpl();
            Course courseObj = new Course();
            courseObj.setName(name);
            // check course name is duplicate
            List courses = cObj.getCourseByName(courseObj);
            if(courses.size()>0){
                out.println("Name exist");
            }
            else{
                out.println("");
            }
        }
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
