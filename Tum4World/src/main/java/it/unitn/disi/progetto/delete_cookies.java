package it.unitn.disi.progetto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "delete_cookies", value = "/delete_cookies")
public class delete_cookies extends GestioneCookies {

    @Override
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = get_name_from_cookie(request);
        if (name == null) {
            name = get_name_from_param(request);
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("Elimino i cookie?<br>");
            print_delete_cookies_form(out, name);
        }
    }

}
