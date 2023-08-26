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

        String button_pressed = request.getParameter("button_pressed");

        ResultSet rs = null;
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

            switch (button_pressed) {
                case "first":
                    showAllUsers(stmt, rs, out);
                    break;
                case "second":
                    showAllSimpatizzanti(stmt, rs, out);
                    break;
                case "third":
                    showAllAderenti(stmt, rs, out);
                    break;
                case "fourth":
                    showAllVisits(stmt, rs, out);
                    break;
                case "fifth":
                    showAllDonations(stmt, rs, out);
                    break;
            }
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page_name = request.getParameter("page_name");

        ResultSet rs = null;
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

            if (page_name.equals("set_to_0")) {
                setAllVisitsTo0(stmt, rs);
            } else {
                updateDatabaseWithVisits(stmt, rs, page_name);
            }
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

    public void showAllVisits(Statement stmt, ResultSet rs, PrintWriter out) {

    }

    public void showAllDonations(Statement stmt, ResultSet rs, PrintWriter out) {

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
            //Prendo in input la pagina e aggiorno il valore sul contatore della pagina indicata
            stmt.executeUpdate("UPDATE VISITS SET TOTALE = VISITS.TOTALE + 1");

            String updateColumn = "UPDATE VISITS SET "+page_name+" = VISITS."+page_name+" + 1";
            stmt.executeUpdate(updateColumn);

//            switch (page_name) {
//                case "home":
//                    rs = stmt.executeQuery("UPDATE VISITS SET HOME = VISITS.HOME + 1");
//                    break;
//                case "chi_siamo":
//                    rs = stmt.executeQuery("UPDATE VISITS SET CHI_SIAMO = VISITS.CHI_SIAMO + 1");
//                    break;
//                case "attivita":
//                    rs = stmt.executeQuery("UPDATE VISITS SET ATTIVITA = VISITS.ATTIVITA + 1");
//                    break;
//                case "attivita1":
//                    rs = stmt.executeQuery("UPDATE VISITS SET ATTIVITA1 = VISITS.ATTIVITA1 + 1");
//                    break;
//                case "attivita2":
//                    rs = stmt.executeQuery("UPDATE VISITS SET ATTIVITA2 = VISITS.ATTIVITA2 + 1");
//                    break;
//                case "attivita3":
//                    rs = stmt.executeQuery("UPDATE VISITS SET ATTIVITA3 = VISITS.ATTIVITA3 + 1");
//                    break;
//                case "contatti":
//                    rs = stmt.executeQuery("UPDATE VISITS SET CONTATTI = VISITS.CONTATTI + 1");
//                    break;
//                case "invio_confermato":
//                    rs = stmt.executeQuery("UPDATE VISITS SET INVIO_CONFERMATO = VISITS.INVIO_CONFERMATO + 1");
//                    break;
//                case "sign_in":
//                    rs = stmt.executeQuery("UPDATE VISITS SET SIGN_IN = VISITS.SIGN_IN + 1");
//                    break;
//                case "registrazione_confermata":
//                    rs = stmt.executeQuery("UPDATE VISITS SET REGISTRAZIONE_CONFERMATA = VISITS.REGISTRAZIONE_CONFERMATA + 1");
//                    break;
//                case "login":
//                    rs = stmt.executeQuery("UPDATE VISITS SET LOGIN = VISITS.LOGIN + 1");
//                    break;
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAllVisitsTo0(Statement stmt, ResultSet rs) {
        try {
            String set_to_0 = "UPDATE VISITS SET TOTALE=0," +
                    "HOME=0," +
                    "CHI_SIAMO=0," +
                    "ATTIVITA=0," +
                    "ATTIVITA1=0," +
                    "ATTIVITA2=0," +
                    "ATTIVITA3=0," +
                    "CONTATTI=0," +
                    "SIGN_IN=0," +
                    "LOGIN=0";
            stmt.executeUpdate(set_to_0);
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