package it.unitn.disi.progetto;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;

public class GestioneCookies extends HttpServlet {

    protected String get_name_from_cookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie c : cookies) {
                String name = c.getName();
                // se il nome dell'utente corrisponde al nome presente nel cookie, allora riprendo il valore
                if (name.equals("name")) {
                    return c.getValue();
                }
            }
        }
        return null;
    }

    protected String get_first_iteration_from_cookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie c : cookies) {
                String first_iteration = c.getName();
                if (first_iteration.equals("first_iteration")) {
                    return c.getValue();
                }
            }
        }
        return null;
    }

    void set_first_iteration_to_cookie(HttpServletRequest request, HttpServletResponse response, String value) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie c : cookies) {
                String first_iteration = c.getName();
                if (first_iteration.equals("first_iteration")) {
                    c.setValue(value);
                    response.addCookie(c);
                }
            }
        }
    }

    protected String get_name_from_param(HttpServletRequest request) {
        String name = request.getParameter("name");
        return name;
    }

    protected String get_first_iteration_from_param(HttpServletRequest request) {
        String first_iteration = request.getParameter("first_iteration");
        return first_iteration;
    }

    // Methods for printing forms
    protected void print_name_form(PrintWriter out) {
        out.println("<form action=\"./input\" method = post>");
        out.println("<label for=\"name\">Come ti chiami?</label><br>");
        out.println("<input type=\"text\" id=\"name\" name=\"name\" required ><br><br>");
        out.println("<input type=\"submit\" value=\"Invia\">");
        out.println("</form>");
    }

    protected void print_continue_form(PrintWriter out, String name) {
        out.println("<form method = post>");
        out.println("<input type=\"hidden\" name=\"name\" value=\"" + name + "\"/>");
        out.println("<input type=\"hidden\" name=\"first_iteration\" value=\"false\"/>");
        out.println("<input type=\"submit\" formaction=\"./input\" value=\"Sì\">");
        out.println("<input type=\"submit\" formaction=\"./delete_cookies\" value=\"No\">");
        out.println("</form>");
    }

    protected void print_delete_cookies_form(PrintWriter out, String name) {
        out.println("<form action=\"./end\" method = post>");
        out.println("<input type=\"hidden\" name=\"name\" value=\"" + name + "\"/>");
        out.println("<label> Sì <input type = \"radio\" name = \"ds\" value = \"true\" required> </label>");
        out.println("<label> No <input type = \"radio\" name = \"ds\" value = \"false\"> </label><br><br>");
        out.println("<input type=\"submit\" value=\"Invia\">");
        out.println("</form>");
    }

    // Data processing
    protected String compute_operation(String op1, String op, String op2, String name) throws ParseException {
        String result = null;
        Number n1 = NumberFormat.getInstance().parse(op1);
        Number n2 = NumberFormat.getInstance().parse(op2);
        double res = 0;
        int err = 0;
        switch (op) {
            case "+":
                res = n1.doubleValue() + n2.doubleValue();
                break;
            case "-":
                res = n1.doubleValue() - n2.doubleValue();
                break;
            case "*":
                res = n1.doubleValue() * n2.doubleValue();
                break;
            case "/":
                if (n2.intValue() != 0)
                    res = n1.doubleValue() / n2.doubleValue();
                else
                    err = 1;
                break;
            default:
                err = 2;
        }
        switch (err) {
            case 0:
                result =  "Ottimo, " + name  + "! <br><br> Ecco il risultato:<br>" +
                        op1 +  " " + op + " "  + op2 + "  = " + res + "<br><br>";
                break;
            case 1:
                result =  "<b>Attenzione, " + name + ": divisione per zero!</b><br><br>";
                break;
            case 2:
                result = "<b>Attenzione, " + name + ": operazione non supportata</b><br><br>";
                break;
        }
        return result;
    }

    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process_request(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process_request(request, response);
    }

}

