package servlets;

import Utils.DBUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(!DBUserService.isLoginUsed(login)){
            if(DBUserService.createUser(login,password)>0){
            resp.sendRedirect("/Diary/authorization");
            }else {
             req.setAttribute("check","userError");
             req.getRequestDispatcher("/views/registration.jsp").forward(req,resp);
            }
        } else {
            req.setAttribute("check", "loginError");
            req.getRequestDispatcher("/views/registration.jsp").forward(req,resp);


        }



    }
}
