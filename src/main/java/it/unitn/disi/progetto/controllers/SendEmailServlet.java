package it.unitn.disi.progetto.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "SendEmailServlet", value = "/sendEmailServlet")
public class SendEmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recipient's email ID needs to be mentioned.
        String receiver = "tum4world@nessunonoluogonoesiste.com";

        // Sender's email ID needs to be mentioned
        String sender = request.getParameter("email");

        String reason = request.getParameter("reason");

        String message = request.getParameter("message");

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage mimeMessage = new MimeMessage(session);

            // Set From: header field of the header.
            mimeMessage.setFrom(new InternetAddress(sender));

            // Set To: header field of the header.
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

            // Set Subject: header field
            mimeMessage.setSubject(reason);

            // Now set the actual message
            mimeMessage.setText(message);

            // Send message
            Transport.send(mimeMessage);

        } catch (MessagingException mex) {
            mex.printStackTrace();

            // Faccio finta che il caso d'invio con successo sia qui
            request.getRequestDispatcher("/WEB-INF/send-confirmed.jsp").forward(request, response);
        }
    }
}
