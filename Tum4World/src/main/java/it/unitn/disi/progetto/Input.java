package it.unitn.disi.progetto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "input", value = "/input")
public class Input extends GestioneCookies {

    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg;
        boolean new_user = false;
        boolean first = false;

        String namec = get_name_from_cookie(request);
        if (namec == null) {
            //Se non trovo il cookie ne creo uno nuovo
            String namep = get_name_from_param(request);
            new_user = true;

            //SE NON LO TROVO SIGNIFICA CHE HA RIFIUTATO I COOKIES, GUARDA VIDEO VARNI

            Cookie new_cookie = new Cookie("name", namep);
            new_cookie.setMaxAge(60*60*24*365);
            response.addCookie(new_cookie);
            namec=namep;

        }

        String first_iteration = get_first_iteration_from_cookie(request);
        if (first_iteration == null) {
            first_iteration = get_first_iteration_from_param(request);

            first = true;
            Cookie first_iteration_cookie = new Cookie("first_iteration", "false");
            first_iteration_cookie.setMaxAge(60 * 3);
            response.addCookie(first_iteration_cookie);

        }
        else {
            //Controllo che sia il primo accesso
            if (first_iteration.equals("true")) {
                first = true;
                set_first_iteration_to_cookie(request, response,"false");
            }
            else first = false;
        }

        if (new_user && first)
            msg = "<b>Piacere di conoscerti, " + namec + "!</b><br><br> Facciamo una operazione: <br><br>";
        else if (!new_user && first)
            msg = "<b>Bentornato, " + namec + "!</b><br><br> Facciamo una operazione: <br><br>";
        else
            msg = "<b>Andiamo avanti, " + namec + "!<b><br><br> Inserisci i nuovi dati: <br><br>";

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(msg);
        }
    }

}
