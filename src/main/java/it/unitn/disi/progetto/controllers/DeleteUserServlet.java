package it.unitn.disi.progetto.controllers;

import it.unitn.disi.progetto.models.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "DeleteUserServlet", value = "/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = CookieController.getSomething(request, "username");
        try {
            db.deleteUser(connection, username);
            request.getRequestDispatcher("/logoutServlet").forward(request, response);
        }
        catch (Exception e){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
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
