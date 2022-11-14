package servlets;

import Utils.DBRecordsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class RecordsPoolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/views/recordsPool.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        if(Objects.equals(req.getParameter("form"), "form1")) {

            if (null != req.getParameter("delete")) {

                int id = Integer.parseInt(req.getParameter("delete"));
                DBRecordsService.deleteRecordById(id);
                resp.sendRedirect("/Diary/pool");

            } else if (null != req.getParameter("exit")) {

                session.invalidate();
                resp.sendRedirect("/Diary");

            } else {
                req.getRequestDispatcher("/views/recordsPool.jsp").forward(req, resp);
            }
        } else if (Objects.equals(req.getParameter("form"), "form2")) {
            int record_id  = Integer.parseInt(req.getParameter("record_id"));
            String text = req.getParameter("record");
            if(record_id > 0){
                if (DBRecordsService.updateRecordById(record_id, text) > 0) {
                    resp.sendRedirect("/Diary/pool");
                }
            } else {
                int id = (int) session.getAttribute("user_id");
                if (DBRecordsService.createRecord(id, text) > 0) {
                    resp.sendRedirect("/Diary/pool");
                } else {
                    resp.sendRedirect("/Diary/pool");
                }
            }
        }

    }
}
