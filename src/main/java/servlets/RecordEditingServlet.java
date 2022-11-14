package servlets;

import Utils.DBRecordsService;
import Utils.DBUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RecordEditingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/views/editingRecord.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String text = new String( req.getParameter("record").getBytes(), StandardCharsets.UTF_8);
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String text = req.getParameter("record");

        if(text != null){
            boolean isUpdating = (boolean) session.getAttribute("isUpdating");
            if(isUpdating == true){

                int record_id = (int) session.getAttribute("updatingId");
                if (DBRecordsService.updateRecordById(record_id, text) > 0) {
                    resp.sendRedirect("/Diary/pool");
                }
            } else {
                int id = (int) session.getAttribute("user_id");
                if (DBRecordsService.createRecord(id, text) > 0) {
                    resp.sendRedirect("/Diary/pool");
                } else {
                    req.setAttribute("check", "InsertError");
                    req.getRequestDispatcher("/views/editingRecord.jsp").forward(req, resp);

                }
            }
        } else{
            req.getRequestDispatcher("/views/editingRecord.jsp").forward(req, resp);
        }
    }
}
