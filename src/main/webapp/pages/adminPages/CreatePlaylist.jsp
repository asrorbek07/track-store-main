<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<html>
<head>
    <title>Create playlist</title>
</head>
<body>
<div style="text-align: center;">
    <h2>Create Playlist</h2>
    <form class="form-group"
          action="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_ADMIN_CREATE_PLAYLIST_COMMAND}"
          method="post">
        <input type="text" placeholder="Enter name" name="${AppConstants.PARAMETER_PLAYLIST_NAME}">
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>
