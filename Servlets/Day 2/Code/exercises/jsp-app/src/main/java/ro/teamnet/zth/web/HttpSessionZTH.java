package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user on 7/13/2016.
 */
public class HttpSessionZTH extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String user = "";
        user = req.getParameter("username");
        String pass = "";
        pass = req.getParameter("password");
        HttpSession session = req.getSession();

        if(user.equals("admin") && pass.equals("admin")){

            resp.getWriter().write("Welcome back!\n" +
                    "Username: "+req.getParameter("user")+"\n"+"sesiune: "+session.getId());

        }
           else{
            req.getAttribute("username",user);
            req.getAttribute("session",session);
            resp.sendRedirect("views/loginFail.jsp");
        }



    }
}
