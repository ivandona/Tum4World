package it.unitn.disi.progetto.controllers;

import it.unitn.disi.progetto.models.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "AdminStuff", value = "/adminStuff")
public class AdminStuff extends HttpServlet {
    private static final String DB_URL = "jdbc:derby://localhost:1527/tum-db";
    private static final String DB_USERNAME = "APP";
    private static final String DB_PASSWORD = "password";
    UserDAO db = new UserDAO();
    Connection connection = null;

    //creo connessione al db quando la servlet viene inizializzata
    //e la distruggo quando viene chiamato il metodo destroy()
    public void init() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("SERVLET INIZIALIZZATA\n");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String role = request.getParameter("role");

        // Collegamento al database (si suppone che tu abbia già configurato la connessione al tuo database)
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Esegui una query per recuperare i dati dal database
            stmt = connection.createStatement();

            if (role.equals("simpatizzante")) {
                rs = stmt.executeQuery("SELECT * FROM USERS WHERE USER_ROLE = 'SIMPATIZZANTE'");
            } else if(role.equals("aderente")) {
                rs = stmt.executeQuery("SELECT * FROM USERS WHERE USER_ROLE = 'ADERENTE'");
            } else if(role.equals("all")) {
                rs = stmt.executeQuery("SELECT * FROM USERS");
            }

            // Costruisci la tabella HTML
            out.println("<table>");
            out.println("<tr><th>Nome</th>" +
                    "<th>Cognome</th>" +
                    "<th>Email</th>" +
                    "<th>Data di nascita</th>" +
                    "<th>Numero di telefono</th>" +
                    "<th>Ruolo</th>" +
                    "<th>Username</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i <= 7; i++) {
                    out.println("<td>" + rs.getString(i) + "</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Chiudi le risorse
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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