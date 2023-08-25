<%--
  Created by IntelliJ IDEA.
  User: eeve1
  Date: 07/08/2023
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <link rel="stylesheet" href="styles/style.css">
</head>x
<ul class="navbar">
  <li class="navbar"><a href="${pageContext.request.contextPath}/pageControllerServlet?page=home">Home</a></li>
  <li class="navbar"><a href="${pageContext.request.contextPath}/pageControllerServlet?page=contacts">Contatti</a></li>
  <li class="navbar"><a href="${pageContext.request.contextPath}/pageControllerServlet?page=simpatizzante">Simpatizzante</a></li>
  <li class="navbar"><a href="${pageContext.request.contextPath}/pageControllerServlet?page=aderente">Aderente</a></li>
  <li class="navbar"><a href="${pageContext.request.contextPath}/pageControllerServlet?page=amministratore">Amministratore</a></li>
  <li class="navbar"><a href="${pageContext.request.contextPath}/pageControllerServlet?page=login">Login</a></li>
  <li class="navbar"><a href="${pageContext.request.contextPath}/pageControllerServlet?page=sign-in">Sign-in</a></li>
</ul>
