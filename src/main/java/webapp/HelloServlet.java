package webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Hello world " + req.getMethod());
        
        HttpSession session = req.getSession();
        if(session.getValue("name") == null){
            session.putValue("name", "Hello world session");
            resp.getWriter().append("No session");
        }else {
            resp.getWriter().append((String)session.getValue("name"));
        }
    }
    
}
