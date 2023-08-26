package it.unitn.disi.progetto.controllers;

import argo.jdom.JsonNode;
import it.unitn.disi.progetto.models.UserDAO;
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

    //creo connessione al db quando la servlet viene inizializzata
    //e la distruggo quando viene chiamato il metodo destroy()
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean[] activities = new Boolean[3];
        String username = CookieController.getSomething(request, "username");
        activities = db.getActivities(connection, username);
        if (activities != null) {
            JsonNode subscribedActivities = object(
                field("activity_1", booleanNode(activities[0])),
                field("activity_2", booleanNode(activities[1])),
                field("activity_3", booleanNode(activities[2]))
            );
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(subscribedActivities);
            out.flush();
        }else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = CookieController.getSomething(request,"username");
        String[] parameters = new String[3];
        Boolean activity_1 = Boolean.parseBoolean(request.getParameter("activity_1"));
        Boolean activity_2 = Boolean.parseBoolean(request.getParameter("activity_2"));
        Boolean activity_3 = Boolean.parseBoolean(request.getParameter("activity_3"));
        System.out.println(activity_1);
        System.out.println(activity_2);
        System.out.println(activity_3);
        System.out.println(request.getParameter("activity_1"));

        try {
            db.setActivities(connection, username, activity_1, activity_2, activity_3);

            System.out.println("Iscrizione/disiscrizione attività gestita");
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
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
