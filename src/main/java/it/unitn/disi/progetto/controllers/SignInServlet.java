package it.unitn.disi.progetto.controllers;

import it.unitn.disi.progetto.models.UserBean;
import it.unitn.disi.progetto.models.UserDAO;
import it.unitn.disi.progetto.models.UserRole;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
|| Servlet per gestire login e registrazione
 */

@WebServlet(name = "SignInServlet", value = "/signInServlet")
public class SignInServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:derby://localhost:1527/tum-db";
    private static final String DB_USERNAME = "APP";
    private static final String DB_PASSWORD = "password";
    UserDAO db = new UserDAO();
    Connection connection = null;

    // Creo la connessione al database quando la servlet viene inizializzata
    // e la distruggo quando viene chiamato il metodo destroy()
    public void init () {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    // Metodo chiamato per la registrazione
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Prendo i parametri ricevuti dal form
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String birthdateString = request.getParameter("birthdate");
        String phoneNumber = request.getParameter("phoneNumber");
        String userRoleString = request.getParameter("userRole");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Di default, un nuovo utente non è iscritto a nessuna attività
        Boolean activity_1 = false;
        Boolean activity_2 = false;
        Boolean activity_3 = false;


        // Converto la data da String a LocalDate
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(birthdateString);

        // Converto userRoleString da String a UserRole
        UserRole userRole = null;
        switch(userRoleString) {
            case "SIMPATIZZANTE":
                userRole = UserRole.SIMPATIZZANTE;
                break;
            case "ADERENTE":
                userRole = UserRole.ADERENTE;
            // Non c'è il case AMMINISTRATORE perché non posso registrarmi come admin dal sito
        }

        UserBean user = new UserBean(name, surname, email, birthdate, phoneNumber, userRole,
                username, password, activity_1, activity_2, activity_3);

        if(db.isUsernameTaken(connection, username)) {
            // L'username è già preso
            request.setAttribute("errorMessage", "37: username già preso");
            request.getRequestDispatcher("/WEB-INF/sign-in.jsp").forward(request, response);
        } else {
            // Inserisco i cookies
            CookieController.addCookies(request, response, user);

            // L'username è stato appena creato, non esiste nel database, quindi registrazione confermata
            db.saveUser(connection, user); //registro le informazioni dell'utente nel database
            request.getRequestDispatcher("/WEB-INF/sign-in-confirmed.jsp").forward(request, response);
        }
    }

    public void destroy() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
