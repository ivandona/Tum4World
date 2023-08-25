package it.unitn.disi.progetto.controllers;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
|| Filtro che controlla che l'utente sia loggato
 */
@WebFilter(filterName = "AccessFilter")
public class AccessFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String page = req.getParameter("page");
        if ("amministratore".equals(page) || "aderente".equals(page) || "simpatizzante".equals(page)) {
            // Se l'utente sta provando ad accedere una pagina privata,
            // giro la richiesta a servlet di login
            req.getRequestDispatcher("/loginServlet");
        }
        // Altrimenti faccio passare la richiesta
        chain.doFilter(request, response);
    }
}
