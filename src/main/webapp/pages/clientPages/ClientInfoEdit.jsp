<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<%@ page import="uz.pdp.trackstore.entity.User" %>
<html>
<head>
    <title>Client info edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<div style="text-align: center;">
    <h4>Client info edit</h4>
    <%
        User user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
    %>
    <form class="form-group" action="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_CLIENT_INFO_EDIT_COMMAND}"
          method="post">
        <input type="text" placeholder="Enter fullName" name="${AppConstants.PARAMETER_USER_FULL_NAME}" value="<%=user.getFullName()%>">
        <input type="text" placeholder="Enter userName" name="${AppConstants.PARAMETER_USER_NAME}" value="<%=user.getUserName()%>">
        <input type="email" placeholder="Enter email" name="${AppConstants.PARAMETER_USER_EMAIL}" value="<%=user.getEmail()%>">
        <input type="text" placeholder="Enter phoneNumber" name="${AppConstants.PARAMETER_USER_PHONE_NUMBER}" value="<%=user.getPhoneNumber()%>">
        <input type="text" placeholder="Enter password" name="${AppConstants.PARAMETER_USER_PASSWORD}" value="<%=user.getPassword()%>">
        <button type="submit">Edit</button>
    </form>

</div>
</body>
</html>
