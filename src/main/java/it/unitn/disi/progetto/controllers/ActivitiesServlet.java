package it.unitn.disi.progetto.controllers;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import it.unitn.disi.progetto.models.UserDAO;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static argo.jdom.JsonNodeFactories.*;

@WebServlet(name = "ActivitiesServlet", value = "/activitiesServlet")
public class ActivitiesServlet extends HttpServlet {
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

    // Metodo per controllare a quali attività è iscritto l'utente.
    // Ritorna un file .json
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean[] activities;
        String username = CookieController.getSomething(request, "username");
//        System.out.println(username);
        activities = db.getActivities(connection, username);
        if (activities != null) {
            JSONObject subscribedActivities = new JSONObject();
            subscribedActivities.put("activity_1", activities[0]);
            subscribedActivities.put("activity_2", activities[1]);
            subscribedActivities.put("activity_3", activities[2]);

//            System.out.println(subscribedActivities);

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(subscribedActivities);
            out.flush();
        } else {
            // Controllo lo stato della risposta
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    // Metodo per inserire/togliere l'iscrizione alle attività dal database
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = CookieController.getSomething(request,"username");

        Boolean activity_1 = Boolean.parseBoolean(request.getParameter("activity_1"));
        Boolean activity_2 = Boolean.parseBoolean(request.getParameter("activity_2"));
        Boolean activity_3 = Boolean.parseBoolean(request.getParameter("activity_3"));

        try {
            db.setActivities(connection, username, activity_1, activity_2, activity_3);

            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        request.getRequestDispatcher("/loginServlet").forward(request, response);
    }

    public void destroy() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
