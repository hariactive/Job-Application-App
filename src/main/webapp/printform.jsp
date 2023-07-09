<!-- Confirmation.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
  <title>Confirmation Page</title>
</head>
<body>
  <h1>Confirmation Page</h1>

  <p><strong>Name:</strong> <%= request.getParameter("name") %></p>
  <p><strong>Email:</strong> <%= request.getParameter("email") %></p>
  <!-- Display other form fields as needed -->
  
  <p><a href="javascript:window.print();">Print this page</a></p>
</body>
</html>
