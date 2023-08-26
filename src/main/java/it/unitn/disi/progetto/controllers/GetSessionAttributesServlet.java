package it.unitn.disi.progetto.controllers;

import static argo.jdom.JsonNodeFactories.*;
import argo.jdom.JsonNode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetSessionAttributesServlet", value = "/getSessionAttributesServlet")
public class GetSessionAttributesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do come parametro false per evitare di creare una nuova sessione
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Metto gli attributi della sessione in un json
            JsonNode attributes = object(
                    field("name", string((String) session.getAttribute("name"))),
                    field("surname", string((String) session.getAttribute("surname"))),
                    field("email", string((String) session.getAttribute("email"))),
                    field("birthdate", string((String) session.getAttribute("birthdate"))),
                    field("phoneNumber", string((String) session.getAttribute("phoneNumber"))),
                    field("userRole", string((String) session.getAttribute("userRole"))),
                    field("username", string((String) session.getAttribute("username"))),
                    field("password", string((String) session.getAttribute("password")))
            );

            response.setContentType("application/json");
            response.getWriter().write(attributes.toString());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
