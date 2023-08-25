package it.unitn.disi.progetto.controllers;

import it.unitn.disi.progetto.models.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
     *         false in caso il cookie non sia stato trovato (aka, i cookies sono disabilitati dall'utente)
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
     * Funzione utilizzata per ritornare o l'username o il ruolo dell'utente. Controlla automaticamente se i cookies sono
     * abilitati o meno, e si comporta di conseguenza.
     * @param request
     * @param something può essere qualsiasi dei campi inseriti dall'utente durante il sign in
     * @return rispettivamente: lo username o il ruolo dell'utente
     */
    public static String getSomething(HttpServletRequest request, String something) {
        //Se i cookies sono abilitati lo cerco qui
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

        //In caso l'utente non volesse i cookies, li cerco sulla session
        HttpSession session = request.getSession();
        String somethingFromSession = (String) session.getAttribute(something);

        if (somethingFromSession == null) {
            System.out.println(something+" della session null");
        }

        return somethingFromSession;
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

}
