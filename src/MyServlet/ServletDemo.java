package MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by CrowHawk on 17/2/28.
 */
@WebServlet(name = "ServletDemo")
public class ServletDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   /*     PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>servlet test</title></head>");
        out.println("<body>hello TestServlet</body>");
        out.println("</html>");*/
    /*    response.setHeader("Content-type", "text/html; charset = UTF-8");
        String data = "姐姐";
        OutputStream out = response.getOutputStream();
        out.write(data.getBytes("UTF-8"));*/
        downloadFileByOutputStream(response);
    }


    private void downloadFileByOutputStream(HttpServletResponse response)
            throws FileNotFoundException, IOException {//通过Response下载文件
        String realPath = this.getServletContext().getRealPath("/Downloads/a.jpg");
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
        response.setHeader("content-disposition", "attachment; filename=" + fileName);
        InputStream in = new FileInputStream(realPath);
        int length = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = response.getOutputStream();
        while((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }
        in.close();

    }
}