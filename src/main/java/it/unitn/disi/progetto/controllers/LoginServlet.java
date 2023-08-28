package it.unitn.disi.progetto.controllers;

import it.unitn.disi.progetto.models.UserBean;
import it.unitn.disi.progetto.models.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:derby://localhost:1527/tum-db";
    private static final String DB_USERNAME = "APP";
    private static final String DB_PASSWORD = "password";
    UserDAO db = new UserDAO();
    Connection connection = null;

    public void init () {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username;
        String password;
        UserBean verifiedUser = null;
        String errorMessage;
        // Controllo se ho già le credenziali dell'utente nei cookies/session
        if (CookieController.getSomething(request, "username") != null
        && CookieController.getSomething(request, "password") != null) {
            username = CookieController.getSomething(request, "username");
            password = CookieController.getSomething(request, "password");
        } else {
            // Altrimenti prendo quelle dal form di login
            username = request.getParameter("username");
            password = request.getParameter("password");
        }

        if(username != "" && username != null && password != "" && password != null) {
            verifiedUser = db.checkCredentials(connection, username, password);
            errorMessage = "37: Username non esiste o credenziali sbagliate";
        } else {
            errorMessage = "";
        }


        if(verifiedUser != null) {
            //login ha avuto successo

            CookieController.addCookies(request, response, verifiedUser);
            System.out.println(verifiedUser.getUserRole());
            //controllo il ruolo dell'utente e rimando alla pagina corrispondente
            switch(verifiedUser.getUserRole()) {
                case AMMINISTRATORE:
                    request.getRequestDispatcher("/WEB-INF/amministratore.jsp").forward(request, response);
                    break;
                case ADERENTE:
                    request.getRequestDispatcher("/WEB-INF/aderente.jsp").forward(request, response);
                    break;
                case SIMPATIZZANTE:
                    request.getRequestDispatcher("/WEB-INF/simpatizzante.jsp").forward(request, response);
                    break;
            }
        } else {
            //login non ha avuto successo
            //rimando alla pagina di login
            request.getSession().setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void destroy() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
