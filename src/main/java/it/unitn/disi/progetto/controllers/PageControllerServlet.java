package it.unitn.disi.progetto.controllers;

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
            case "amministratore":
                request.getRequestDispatcher("/WEB-INF/amministratore.jsp").forward(request, response);
                break;
            case "info-cookie":
                request.getRequestDispatcher("/WEB-INF/info-cookie.jsp").forward(request, response);
                break;
            case "login":
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                break;
            case "sign-in":
                request.getRequestDispatcher("/WEB-INF/sign-in.jsp").forward(request, response);
                break;
            case "contacts":
                request.getRequestDispatcher("/WEB-INF/contacts.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/page?page=index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
