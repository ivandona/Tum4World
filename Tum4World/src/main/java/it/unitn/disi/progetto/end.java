package it.unitn.disi.progetto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "end", value = "/end")
public class end extends GestioneCookies {

    @Override
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = get_name_from_cookie(request);
        if (name == null) {
            name = get_name_from_param(request);
        }
        String ds = request.getParameter("ds");
        if (ds.equals("true")) {
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        else
            set_first_iteration_to_cookie(request, response,"true");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<b>Alla prossima, " + name + "!!!</b>");
        }
    }

}

