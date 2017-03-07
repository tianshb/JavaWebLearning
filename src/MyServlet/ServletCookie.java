package MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
/**
 * Created by CrowHawk on 17/3/7.
 */
@WebServlet(name = "ServletCookie")
public class ServletCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html; charset = UTF-8");
        PrintWriter out = response.getWriter();
        Cookie [] cookies = request.getCookies();
        if(cookies == null){
            out.write("这是您第首次访问本站！");
        }
        else {
            out.write("您上次的访问时间是：");
            for(Cookie cookie: cookies){
                if (cookie.getName().equals("LastLoginTime")){
                    Long timeLong = Long.parseLong(cookie.getValue());
                    Date date = new Date(timeLong);
                    out.write(DateFormat.getDateInstance().format(date));
                }
            }
        }
        Cookie cookie = new Cookie("LastLoginTime", System.currentTimeMillis() + "");
        response.addCookie(cookie);
    }
}
