<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="apply_box">
<h1>Your Application has been saved.
<%=request.getAttribute("Message") %>
</h1>
</div>
</div>
</body>
</html>