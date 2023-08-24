package it.unitn.disi.progetto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PageControllerServlet", value = "/pageControllerServlet")
public class PageControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            default:
                response.sendRedirect(request.getContextPath() + "/page?page=index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
