package servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Record;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static Utils.DBRecordsService.getRecordObjectById;

public class RecordGettingServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger("logger ");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.info("id parameter is " + req.getParameter("id"));
        if (null != req.getParameter("id")) {
            int recordId = Integer.parseInt(req.getParameter("id"));
            if (recordId > 0) {
                Record record = getRecordObjectById(recordId);
                GsonBuilder builder = new GsonBuilder();
                builder.setPrettyPrinting();
                Gson gson = builder.create();

                String jsonRecord = gson.toJson(record);
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                out.print(jsonRecord);
                out.flush();
            }
        }
    }
}
