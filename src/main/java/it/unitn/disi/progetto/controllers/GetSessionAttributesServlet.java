package it.unitn.disi.progetto.controllers;

import static argo.jdom.JsonNodeFactories.*;
import argo.jdom.JsonNode;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetSessionAttributesServlet", value = "/getSessionAttributesServlet")
public class GetSessionAttributesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do come parametro false per evitare di creare una nuova sessione
        HttpSession session = request.getSession();
        if (session != null) {
            // Metto gli attributi della sessione in un json
            JSONObject attributes = new JSONObject();
            attributes.put("name", session.getAttribute("name"));
            attributes.put("surname", session.getAttribute("surname"));
            attributes.put("email", session.getAttribute("email"));
            attributes.put("birthdate", session.getAttribute("birthdate"));
            attributes.put("phoneNumber", session.getAttribute("phoneNumber"));
            attributes.put("userRole", session.getAttribute("userRole"));
            attributes.put("username", session.getAttribute("username"));
            attributes.put("password", session.getAttribute("password"));
            System.out.println(attributes);
            System.out.println("Costruendo json per getSessionAttributesServlet");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(attributes);
            out.flush();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
