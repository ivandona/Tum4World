package it.unitn.disi.progetto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PublicPageController", value = "/publicPageController")
public class PublicPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); // Get the requested page parameter

        switch (page) {
            case "chi_siamo":
                request.getRequestDispatcher("/WEB-INF/chi_siamo.jsp").forward(request, response);
                break;
            case "attivita":
                request.getRequestDispatcher("/WEB-INF/attivita.jsp").forward(request, response);
                break;
            case "contatti":
                request.getRequestDispatcher("/WEB-INF/contatti.jsp").forward(request, response);
                break;
            case "sign_in":
                request.getRequestDispatcher("/WEB-INF/sign_in.jsp").forward(request, response);
                break;
            case "login":
                request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
                break;
            case "attivita1":
                request.getRequestDispatcher("/WEB-INF/attivita1.jsp").forward(request, response);
                break;
            case "attivita2":
                request.getRequestDispatcher("/WEB-INF/attivita2.jsp").forward(request, response);
                break;
            case "attivita3":
                request.getRequestDispatcher("/WEB-INF/attivita3.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/page?page=index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
