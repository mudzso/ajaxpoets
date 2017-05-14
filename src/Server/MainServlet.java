package Server;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mudzso on 2017.04.10..
 */
@WebServlet(name = "Server.MainServlet",urlPatterns = "/MainServlet")

public class MainServlet extends HttpServlet {

    private List<Poem> poems;

    public MainServlet() {
        poems = new ArrayList<>();
    }

    @Override
    public void init() throws ServletException {
        poems.add(new Poem("Calceuss assimilant in rusticus berolinum!","JSon1",1992,"Johndoe1"));
        poems.add(new Poem("Glos de primus tus, demitto buxum!","JSon2",1992,"Johndoe1"));
        poems.add(new Poem("Sunt poetaes talem clemens, azureus devirginatoes.","JSon3",1992,"Johndoe1"));
        poems.add(new Poem("Pol, a bene barcas.","JSon4",1992,"Johndoe4"));
        poems.add(new Poem("Trabem solite ducunt ad rusticus hilotae.","JSon5",1992,"Johndoe5"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Poem result = null;
        for (Poem poem:poems
             ) {
            if (poem.getTitle().equals(request.getParameter("title")))result = poem;

        }

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("utf-8");
        out.append(result.getText());
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Poem>result = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json");
        String name = (String)request.getSession().getAttribute("name");
        for (Poem poem:poems) {
            if (poem.getPoet().equals(name)){
                result.add(poem);

            }

        }
        objectMapper.writeValue(response.getOutputStream(),result);


    }
}
