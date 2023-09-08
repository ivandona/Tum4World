package it.unitn.disi.progetto.controllers;

import it.unitn.disi.progetto.models.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CookieController", value = "/cookieController")
public class CookieController {

    public static void addCookies(HttpServletRequest request, HttpServletResponse response, UserBean user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = user.getBirthdate().format(formatter);

        addCookieOrAttribute(request, response, "name", user.getName());
        addCookieOrAttribute(request, response, "surname", user.getSurname());
        addCookieOrAttribute(request, response, "email", user.getEmail());
        addCookieOrAttribute(request, response, "birthdate", formattedDate);
        addCookieOrAttribute(request, response, "phoneNumber", user.getPhoneNumber());
        addCookieOrAttribute(request, response, "userRole", returnUserRole(user));
        addCookieOrAttribute(request, response, "username", user.getUsername());
        addCookieOrAttribute(request, response, "password", user.getPassword());
    }

    /**
     * Controlla che i cookies siano stati accettati dall'utente
     *
     * @param request
     * @return true in caso il valore "cookie_accepted" sia true,
     *         false in caso il cookie non sia stato trovato (ovvero i cookies sono stati disabilitati dall'utente)
     */
    public static boolean checkAcceptedCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookies_accepted")) {
                    if (cookie.getValue().equals("true"))
                        return true;
                    break;
                }
            }
        }

        return false;
    }

    public static String returnUserRole(UserBean user) {
        String role = "";
        switch (user.getUserRole()) {
            case AMMINISTRATORE:
                role = "Amministratore";
                break;
            case ADERENTE:
                role = "Aderente";
                break;
            case SIMPATIZZANTE:
                role = "Simpatizzante";
                break;
        }

        return role;
    }

    /**
     * Funzione utilizzata per ritornare il valore di un qualsiasi cookie. Controlla automaticamente se i cookies sono
     * abilitati o meno, e si comporta di conseguenza.
     * @param request
     * @param something può essere qualsiasi dei campi inseriti dall'utente durante il sign in.
     * @return il value di something
     */
    public static String getSomething(HttpServletRequest request, String something) {
        // Se i cookies sono abilitati cerco il value di something nel vettore di cookies
        if (checkAcceptedCookies(request)) {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(something)) {
                        return cookie.getValue();
                    }
                }
            }
        }

        // In caso l'utente abbia disabilitato i cookies di terze parti, li cerco sulla session
        HttpSession session = request.getSession();

        return (String) session.getAttribute(something);
    }

    public static void addCookieOrAttribute(HttpServletRequest request, HttpServletResponse response, String name, String value) {
        if (checkAcceptedCookies(request)) {
            Cookie cookie = new Cookie(name, value);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute(name, value);
        }
    }

    /**
     * Funzione che permette di eliminare tutti i cookies in caso l'utente faccia il logout
     * @param request
     * @param response
     */
    public static void deleteAllCookiesAndAttributes(HttpServletRequest request, HttpServletResponse response) {
        if (checkAcceptedCookies(request)) {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("name") ||
                            cookie.getName().equals("surname") ||
                            cookie.getName().equals("email") ||
                            cookie.getName().equals("birthdate") ||
                            cookie.getName().equals("phoneNumber") ||
                            cookie.getName().equals("userRole") ||
                            cookie.getName().equals("username") ||
                            cookie.getName().equals("password")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
        } else {
            HttpSession session = request.getSession();
            session.removeAttribute("name");
            session.removeAttribute("surname");
            session.removeAttribute("email");
            session.removeAttribute("birthdate");
            session.removeAttribute("phoneNumber");
            session.removeAttribute("userRole");
            session.removeAttribute("username");
            session.removeAttribute("password");
            session.removeAttribute("errorMessage");
        }
    }
}
