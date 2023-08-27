<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
  <link rel="stylesheet" href="styles/hf.css">
  <title>Header</title>
</head>
<body>
<div class="page-container">
  <div class="content_wrap">
    <header>
      <div class="intestazione">TUM4WORLD</div>

      <nav class="navbar">
        <ul class="nav_lista">
          <li> <a href="${pageContext.request.contextPath}/publicPageController?page=homepage_pubblica"> Home Page </a> </li>
          <li> <a href="${pageContext.request.contextPath}/publicPageController?page=chi_siamo"> Chi siamo </a> </li>
          <li> <a href="${pageContext.request.contextPath}/publicPageController?page=attivita"> Attività </a> </li>
          <li> <a href="${pageContext.request.contextPath}/publicPageController?page=contatti"> Contatti </a> </li>
          <li> <a href="${pageContext.request.contextPath}/publicPageController?page=sign-in"> Sign-in </a> </li>
          <li> <a href="${pageContext.request.contextPath}/loginServlet"> Login </a> </li>
          <li> <a href="${pageContext.request.contextPath}/logoutServlet"> Logout </a> </li>
        </ul>
      </nav>
    </header>
</body>
</html>
