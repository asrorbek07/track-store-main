<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login or Register</title>
</head>
<body>
<center>
    <div style="text-align: center; background: #a0efdf; width: 400px; height: 200px" >
        <h1>Login or Register</h1>
        <br/>
        <a href="controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_LOGIN}">Sign-in</a>
        <br>
        <br>
        <a href="controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_REGISTER}">Sign-up</a>
    </div>
</center>
</body>
</html>