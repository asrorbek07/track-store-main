<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<html>
<head>
    <title>Add Review</title>
</head>
<body>
<div style="text-align: center;">
    <h2>Add Review</h2>
    <form class="form-group"
          action="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_CLIENT_ADD_REVIEW_COMMAND}"
          method="post">
        <input type="hidden" value=<%=request.getParameter(AppConstants.PARAMETER_TRACK_ID)%> name="${AppConstants.PARAMETER_TRACK_ID}">
        <input type="text" placeholder="Enter review" name="${AppConstants.PARAMETER_REVIEW}">
        <input type="number" placeholder="Enter rate" name="${AppConstants.PARAMETER_RATE}">
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>
