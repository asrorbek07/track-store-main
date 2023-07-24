<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<html>
<head>
    <title>Add album</title>
</head>
<body>
<div style="text-align: center;">
    <h2>Add Album</h2>
    <form class="form-group"
          action="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_ADMIN_ADD_ALBUM_COMMAND}"
          method="post">
        <input type="text" placeholder="Enter name" name="${AppConstants.PARAMETER_ALBUM_NAME}">
        <button type="submit">Add Album</button>
    </form>

</div>
</body>
</html>
