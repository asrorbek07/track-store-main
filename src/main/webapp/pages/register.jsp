<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>


<body>
<div style="text-align: center;">
    <h4>Sign-up</h4>
    <form class="form-group" action="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_REGISTER}"
          method="post">
        <input type="text" placeholder="Enter fullName" name="${AppConstants.PARAMETER_USER_FULL_NAME}">
        <input type="text" placeholder="Enter userName" name="${AppConstants.PARAMETER_USER_NAME}">
        <input type="email" placeholder="Enter email" name="${AppConstants.PARAMETER_USER_EMAIL}">
        <input type="text" placeholder="Enter phoneNumber" name="${AppConstants.PARAMETER_USER_PHONE_NUMBER}">
        <input type="text" placeholder="Enter password" name="${AppConstants.PARAMETER_USER_PASSWORD}">
        <button type="submit">Register</button>
    </form>

</div>
</body>
</html>
