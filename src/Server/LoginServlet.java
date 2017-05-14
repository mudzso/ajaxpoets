package Server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mudzso on 2017.04.10..
 */
public class LoginServlet extends HttpServlet {

    private Map<String,String>users;

    @Override
    public void init() throws ServletException {
        users = new HashMap<>();
        users.put("Johndoe1","admin1");
        users.put("Johndoe2","admin2");
        users.put("Johndoe3","admin3");
        users.put("Johndoe4","admin4");
        users.put("Johndoe5","admin5");
        users.put("Johndoe6","admin6");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password;
        if(request.getParameterMap().containsKey("psw")){
            password =request.getParameter("psw");
            for (Map.Entry<String, String>entry:users.entrySet()) {
                if (entry.getValue().equals(password)){
                    HttpSession session = request.getSession();
                    session.setAttribute("name",entry.getKey());
                    session.setMaxInactiveInterval(30*60);
                    response.sendRedirect("Main.jsp");
                }else {

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
                    rd.include(request,response);

                }

            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
