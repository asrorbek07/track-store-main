<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<%@ page import="uz.pdp.trackstore.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Info</title>
</head>
<body>
<h2>Client Info</h2>
<%
    User user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
%>
<p>Username = <%=user.getUserName()%></p>
<p>Fullname = <%=user.getFullName()%></p>
<p>Password = <%=user.getPassword()%></p>
<p>Phone number = <%=user.getPhoneNumber()%></p>
<p>Email = <%=user.getEmail()%></p>
<p>Status = <%=user.isActive()?"Active":"Blocked"%></p>
<a href="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_CLIENT_INFO_EDIT_COMMAND}">Edit</a>
</body>
</html>
