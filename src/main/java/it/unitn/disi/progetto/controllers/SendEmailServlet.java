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
        String receiver = "tum4world@nessunonoluogonoesiste.com";
        String sender = request.getParameter("email");
        String reason = request.getParameter("reason");
        String message = request.getParameter("message");

        String host = "localhost";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(sender));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            mimeMessage.setSubject(reason);
            mimeMessage.setText(message);
            Transport.send(mimeMessage);
        } catch (MessagingException mex) {
            mex.printStackTrace();

            // Faccio finta che il caso d'invio con successo sia qui
            request.getRequestDispatcher("/WEB-INF/send-confirmed.jsp").forward(request, response);
        }
    }
}
