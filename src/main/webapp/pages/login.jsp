<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<div class="form-group" style="text-align: center;">
    <h4>Sign-in</h4>
    <form action="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_LOGIN}" method="post">
        <label>
            <input type="text" placeholder="Enter userName" name="${AppConstants.PARAMETER_USER_NAME}">
        </label>
        <label>
            <input type="text" placeholder="Enter password" name="${AppConstants.PARAMETER_USER_PASSWORD}">
        </label>
        <button TYPE="submit">Login</button>
    </form>

</div>
</body>
</html>
