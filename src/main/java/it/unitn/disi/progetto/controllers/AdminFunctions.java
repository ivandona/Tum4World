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
import java.time.LocalDate;
import java.util.Arrays;
import org.json.JSONArray;

@WebServlet(name = "AdminFunctions", value = "/adminFunctions")
public class AdminFunctions extends HttpServlet {
    private static final String DB_URL = "jdbc:derby://localhost:1527/tum-db";
    private static final String DB_USERNAME = "APP";
    private static final String DB_PASSWORD = "password";
    UserDAO db = new UserDAO();
    Connection connection = null;

    // Creo la connessione al database quando la servlet viene inizializzata
    // e la distruggo quando viene chiamato il metodo destroy()
    public void init() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String button_pressed = request.getParameter("button_pressed");

        ResultSet rs = null;
        Statement stmt;

        try {
            stmt = connection.createStatement();

            // In base al pulsante premuto nella pagina 'amministratore' viene svolta l'azione corrispondente
            switch (button_pressed) {
                case "users":
                    showAllUsers(stmt, rs, out);
                    break;
                case "simpatizzanti":
                    showAllSimpatizzanti(stmt, rs, out);
                    break;
                case "aderenti":
                    showAllAderenti(stmt, rs, out);
                    break;
                    // Per queste ultime due casistiche, il risultato viene salvato su un array JSON per essere poi
                    // mostrato sul grafico.
                case "visits":
                    int[] siteVisits = showAllVisits(stmt, rs, out);
                    response.setContentType("application/json");
                    JSONArray siteVisitsArray = new JSONArray(siteVisits);
                    out.write(siteVisitsArray.toString());
                    break;
                case "donations":
                    int[] donazioni_mensili = showAllDonations(connection, rs, out);
                    response.setContentType("application/json");
                    JSONArray array_donazioni = new JSONArray(donazioni_mensili);
                    out.write(array_donazioni.toString());
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // La doPost viene chiamata solamente quando è necessario mettere mano al database delle visite
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page_name = request.getParameter("page_name");

        ResultSet rs = null;
        Statement stmt;

        try {
            stmt = connection.createStatement();

            if (page_name.equals("set_to_0")) {
                setAllVisitsTo0(stmt, rs);
            } else {
                updateDatabaseWithVisits(stmt, rs, page_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllUsers(Statement stmt, ResultSet rs, PrintWriter out) {
        try {
            rs = stmt.executeQuery("SELECT * FROM USERS");
            createTableForThreeButtons(out, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void showAllSimpatizzanti(Statement stmt, ResultSet rs, PrintWriter out) {
        try {
            rs = stmt.executeQuery("SELECT * FROM USERS WHERE USER_ROLE = 'SIMPATIZZANTE'");
            createTableForThreeButtons(out, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllAderenti(Statement stmt, ResultSet rs, PrintWriter out) {
        try {
            rs = stmt.executeQuery("SELECT * FROM USERS WHERE USER_ROLE = 'ADERENTE'");
            createTableForThreeButtons(out, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ritorna un array contenente le varie visite al sito
    public int[] showAllVisits(Statement stmt, ResultSet rs, PrintWriter out) {
        int[] visits = new int[12];
        Arrays.fill(visits, 0);

        try {
            String query = "SELECT * FROM VISITS"; // Seleziona tutte le colonne
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                for (int i = 0; i < visits.length; i++) {
                    visits[i] = rs.getInt(i + 1); // Assegna il valore della colonna corrente all'array
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visits;
    }

    // Ritorna un array contenente le donazioni effettuate nei vari mesi
    public int[] showAllDonations(Connection connection, ResultSet rs, PrintWriter out) {
        int[] tot_mesi = new int[12];
        for (int i = 0; i < 12; i++) {
            tot_mesi[i] = 0;
        }
        LocalDate dataOdierna = LocalDate.now();
        int mese = dataOdierna.getMonthValue();
        int anno = dataOdierna.getYear();

        try {
            String query = "SELECT VALUE_DONATION, DONATION_MONTH FROM DONATIONS WHERE DONATION_YEAR = ? AND DONATION_MONTH <= ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, anno);
            statement.setInt(2, mese);

            rs = statement.executeQuery();
            while (rs.next()){
                int current_donation = rs.getInt("VALUE_DONATION");
                int current_month = rs.getInt("DONATION_MONTH");
                tot_mesi[current_month-1] += current_donation;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tot_mesi;
    }

    public void createTableForThreeButtons(PrintWriter out, ResultSet rs) {
        try {
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
        }
    }

    public void updateDatabaseWithVisits(Statement stmt, ResultSet rs, String page_name) {
        try {
            stmt.executeUpdate("UPDATE VISITS SET TOTALE = VISITS.TOTALE + 1");

            //Prendo in input la pagina e aggiorno il valore sul contatore della pagina indicata
            String updateColumn = "UPDATE VISITS SET "+page_name+" = VISITS."+page_name+" + 1";
            stmt.executeUpdate(updateColumn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAllVisitsTo0(Statement stmt, ResultSet rs) {
        try {
            String setTo0 = "UPDATE VISITS SET TOTALE=0," +
                    "HOME=0," +
                    "CHI_SIAMO=0," +
                    "ATTIVITA=0," +
                    "ATTIVITA1=0," +
                    "ATTIVITA2=0," +
                    "ATTIVITA3=0," +
                    "CONTATTI=0," +
                    "SIGN_IN=0," +
                    "LOGIN=0," +
                    "SIMPATIZZANTE=0," +
                    "ADERENTE=0";
            stmt.executeUpdate(setTo0);
        } catch (SQLException e) {
            e.printStackTrace();
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