String name = request.getParameter("name");
String email = request.getParameter("email");

request.setAttribute("name", name);
request.setAttribute("email", email);

response.sendRedirect("Confirmation.jsp");