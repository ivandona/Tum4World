package it.unitn.disi.progetto.controllers;

import it.unitn.disi.progetto.models.UserBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CookieController", value = "/cookieController")
public class CookieController {

    public static void addCookies(HttpServletRequest request, HttpServletResponse response, String username, UserBean user) {
        if (checkAcceptedCookies(request)) {
            Cookie cookieUsername = new Cookie("username", username);
            cookieUsername.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookieUsername);

            Cookie cookieRole = new Cookie("role", returnUserRole(user));
            cookieRole.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookieRole);

            System.out.println(username);
            System.out.println(returnUserRole(user));
        } else {
            //In caso l'utente non volesse i cookies, mi salvo tutto sulla session (?)
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            session.setAttribute("role", returnUserRole(user));


            System.out.println("Session" + username);
            System.out.println("Session" + returnUserRole(user));
        }
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

    //something = username
    //something = role

    /**
     * Funzione utilizzata per ritornare o l'username o il ruolo dell'utente. Controlla automaticamente se i cookies sono
     * abilitati o meno, e si comporta di conseguenza.
     * @param request
     * @param something può essere o "username" o "role"
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
}
