
import Pojo.User;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("AuthenticationFilter initialized");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::" + uri);
        System.out.println("uri : " + uri);
        HttpSession session = req.getSession(false);
        if (session == null) {
            System.out.println("   session is null ");
            //session = req.getSession(true);
            System.err.println("gddddddd");
            RequestDispatcher requestdispatcher = request.getRequestDispatcher("/index.jsp");
            requestdispatcher.forward(req, res);

        } else {
            //session not null
            System.out.println("   session is not null ");
            User u = (User) session.getAttribute("user");
            if (u == null) {
                //user not logged in
                System.err.println("hssssssssssss");
                RequestDispatcher requestdispatcher = request.getRequestDispatcher("/index.jsp");
                requestdispatcher.forward(req, res);
            } else {
                //user logged in 
                System.out.println("found user in session");
                System.out.println("user name :" + u.getName());
                System.out.println("user type :" + u.getType());
                System.out.println("is admin :" + u.getIsAdmin());
                int role = u.getType();

                if (uri.contains("/StudentView") || uri.contains("/UploadServlet")) {
                    //trainee
                    if (role == 1 ) {
                        chain.doFilter(request, response);
                        System.err.println("student");
                    } else {
                        System.err.println("not ");
                        RequestDispatcher requestdispatcher = request.getRequestDispatcher("/index.jsp");
                        requestdispatcher.forward(req, res);
                    }
                } else {
                    //staff
                    if (uri.contains("/StaffView")) {
                        if (role == 2 && u.getIsAdmin() == 0) {
                            chain.doFilter(request, response);
                        } else {
                            RequestDispatcher requestdispatcher = request.getRequestDispatcher("/index.jsp");
                            requestdispatcher.forward(req, res);
                        }

                    } else {
                        //admin
                        //if (uri.startsWith("/AdminView")) {
                        if (role == 2 && u.getIsAdmin() == 1) {
                            chain.doFilter(request, response);
                            System.err.println("jxxxxxxxxxx");
                        } else {
                            RequestDispatcher requestdispatcher = request.getRequestDispatcher("/index.jsp");
                            requestdispatcher.forward(req, res);
                        }
                    }

                }
            }
        }

    }
//        if(uri.equals("/AssignLabProject/login.jsp") || uri.equals("/AssignLabProject/LoginServlet")){
//        if(session==null){
//            System.out.println("   session is null ");
//            //session = req.getSession(true);
//            RequestDispatcher requestdispatcher = request.getRequestDispatcher("/login.jsp");
//            requestdispatcher.forward(req, res);
//            
//        }else{
//            //session not null
//            System.out.println("   session is not null ");
//            User u = (User) session.getAttribute("user");
//            if(u==null){
//                
//               // out.flush() ;
//                System.out.println("user is not in the session");
////              RequestDispatcher requestdispatcher = request.getRequestDispatcher("/LoginServlet");
////              requestdispatcher.forward(req, res);
//                chain.doFilter(request, response); 
//                
//            }else{
//                System.out.println("found user in session");
//                System.out.println("user name :"+u.getName());
//                System.out.println("user pass :"+u.getPass());
////              RequestDispatcher requestdispatcher = request.getRequestDispatcher("/LoginServlet");
////              requestdispatcher.forward(req, res);
//                // chain.doFilter(request, response); 
//            }
//        }
//        }else if(uri.contains("/AdminView")){
//        
//          // chain.doFilter(request, response);
//        }
    // chain.doFilter(request, response);   

//        if(session == null && !uri.endsWith("jsp") || uri.endsWith("LoginServlet")|| uri.endsWith("html")){
//            System.out.println("Unauthorized access request");
//            this.context.log("Unauthorized access request");
//             RequestDispatcher requestdispatcher=request.getRequestDispatcher("/login.jsp");
//             requestdispatcher.forward(request,response);
    //res.sendRedirect("login.jsp");
//        }else if(session != null){
//            User u=new User();
//            System.out.println("why Unauthorized access request ");
//            chain.doFilter(request, response);
//            
////            if(session.getAttribute("user")!=null){
////                u = (User) session.getAttribute("user");
////            System.out.println("why Unauthorized access request "+uri+"   "+u.getName());
////            // pass the request along the filter chain
////            chain.doFilter(request, response);
////            }else {
////                res.sendRedirect("login.jsp");
////            }
//        }else{
    //res.sendRedirect("login.jsp");
    // }
    //} 
    public void destroy() {
        //close any resources here
    }

}
