import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookie extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        request.getSession();
        putCooky("color", "red", request, response);
        putCooky("radius", "5.5", request, response);
        putCooky("count", "2", request, response);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("<p>Cookies were sent</p><a href='index.html'>Back</a>");

    }

    private void putCooky(String name, String value, HttpServletRequest request, HttpServletResponse response){
        Cookie aCookie = new Cookie(name, value);
        aCookie.setPath(request.getContextPath() + "/");
        aCookie.setMaxAge(60*60*24*2); //sec*min*hrs*days
        response.addCookie(aCookie);
    }

    @Override
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}


