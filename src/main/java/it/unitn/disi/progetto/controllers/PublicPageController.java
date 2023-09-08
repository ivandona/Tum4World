package it.unitn.disi.progetto.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*
|| Servlet per gestire il trasferimento dell'utente tra le pagine
 */

@WebServlet(name = "PublicPageController", value = "/publicPageController")
public class PublicPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");
        String url = "/WEB-INF/" + page + ".jsp";

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
