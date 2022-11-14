package servlets;

import Utils.DBUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/authorization.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if ((login != null) && (password != null)){
            int id = DBUserService.logIn(login,password);
            if(id > 0){
                HttpSession session = req.getSession();
                session.setAttribute("user_id", id);
                resp.sendRedirect("/Diary/pool");
            } else {
                req.setAttribute("check", "loginError");
                req.getRequestDispatcher("/views/authorization.jsp").forward(req,resp);
            }
        } else {
            req.getRequestDispatcher("/views/authorization.jsp").forward(req,resp);
        }
    }
}
