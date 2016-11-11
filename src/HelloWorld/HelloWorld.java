package HelloWorld;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Boo on 2016-11-11.
 */

public class HelloWorld extends HttpServlet {
    String[] testDB;
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, HTTPException{

        try {
           testDB = new DAO().jay();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("<HTML>");
        printWriter.println("<BODY>");
        printWriter.println("Hello World!!");
        printWriter.println(testDB[0] +testDB[1]+testDB[2]);
        printWriter.println("</BODY>");
        printWriter.println("</HTML>");
        printWriter.close();}
    }
}
