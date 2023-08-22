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
            System.out.println("SERVLET INIZIALIZZATA\n");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean verifiedUser = new UserBean();
        verifiedUser = db.checkCredentials(connection, username, password);

        if(verifiedUser != null) {
            //login ha avuto successo

            //TODO: mettere informazioni utente in cookie/session

            //controllo il ruolo dell'utente e rimando alla pagina corrispondente
            switch(verifiedUser.getUserRole()) {
                case AMMINISTRATORE:
                    request.getRequestDispatcher("/WEB-INF/amministratore.jsp").forward(request, response);
                case ADERENTE:
                    request.getRequestDispatcher("/WEB-INF/aderente.jsp").forward(request, response);
                case SIMPATIZZANTE:
                    request.getRequestDispatcher("/WEB-INF/simpatizzante.jsp").forward(request, response);
            }
        } else {
            //login non ha avuto successo
            //rimando alla pagina di login
            request.setAttribute("errorMessage", "37: credenziali sbagliate o username inesistente");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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