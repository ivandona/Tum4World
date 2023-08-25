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
        if (CookieController.getSomething(req, "username") == null) {
            // Se l'utente non è loggato, rimando alla pagina di login
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        // Altrimenti faccio passare la richiesta
        chain.doFilter(request, response);
    }
}
