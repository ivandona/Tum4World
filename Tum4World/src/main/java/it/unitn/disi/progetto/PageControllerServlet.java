package it.unitn.disi.progetto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PageControllerServlet", value = "/pageControllerServlet")
public class PageControllerServlet extends HttpServlet {

    boolean first = true;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cookies
        //Compare ogni volta che vai in una pagina DA SISTEMARE
        GestioneCookies c = new GestioneCookies();  //??
        if (first) {
            first = false;
            String name = c.get_name_from_cookie(request);

            if (name != null)
                //Se trovo il nome faccio cose
                request.getRequestDispatcher("./input").forward(request, response);
            else {
                //Se non vi è il cookie, ti chiedo il nome
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println("Ciao! <br><br>");
                    c.print_name_form(out);
                }
            }
        } else {
            //PER CANCELLARE I COOKIES, SOLO TESTING
            request.getRequestDispatcher("./delete_cookies").forward(request, response);
        }
        //Fine cookies

        String page = request.getParameter("page"); // Get the requested page parameter

        switch (page) {
            case "home":
                request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
                break;
            case "simpatizzante":
                request.getRequestDispatcher("/WEB-INF/simpatizzante.jsp").forward(request, response);
                break;
            case "aderente":
                request.getRequestDispatcher("/WEB-INF/aderente.jsp").forward(request, response);
                break;
            case "admin":
                request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
                break;
            case "info-cookie":
                request.getRequestDispatcher("/WEB-INF/info-cookie.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/page?page=index");
        }
    }
}
