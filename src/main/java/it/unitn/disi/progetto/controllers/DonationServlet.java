package it.unitn.disi.progetto.controllers;

import it.unitn.disi.progetto.models.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

/*
|| Servlet per gestire login e registrazione
 */

@WebServlet(name = "DonationServlet", value = "/donationServlet")
public class DonationServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:derby://localhost:1527/tum-db";
    private static final String DB_USERNAME = "APP";
    private static final String DB_PASSWORD = "password";
    UserDAO db = new UserDAO();
    Connection connection = null;

    //creo connessione al db quando la servlet viene inizializzata
    //e la distruggo quando viene chiamato il metodo destroy()
    public void init () {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    //metodo chiamato per registrazione
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //prendo l'importo ricevuti dal form
        int importo = Integer.parseInt(request.getParameter("importo"));
        String username = CookieController.getSomething(request, "username");

        //prendo la data del momento in cui e avvenuta la donazione
        LocalDate currentDate = LocalDate.now();
        int giorno = currentDate.getDayOfMonth();
        int mese = currentDate.getMonthValue();
        int anno = currentDate.getYear();

        db.saveDonation(connection, username, importo, giorno, mese, anno);
        request.getRequestDispatcher("/WEB-INF/aderente.jsp").forward(request, response);
    }

    public void destroy() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
