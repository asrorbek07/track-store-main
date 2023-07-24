<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<html>
<head>
    <title>Welcome Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<% boolean b = true;%>
<div style="padding: 10px">
    <div style="width: 600px; margin-left: 10px">
        <form action="/controller?">
            <label for="commands"><h4><b>Menu:</b></h4></label>
            <select class="form-select w-50" name=${AppConstants.PARAMETER_COMMAND} id="commands">
                <option value=${AppConstants.PARAMETER_CLIENT_ALL_TRACKS_COMMAND}>All Tracks</option>
                <option value=${AppConstants.PARAMETER_ADMIN_ADD_ALBUM_COMMAND}>Add Album</option>
                <option value=${AppConstants.PARAMETER_ADMIN_CREATE_PLAYLIST_COMMAND}>Create Playlist</option>
                <option value=${AppConstants.PARAMETER_ADMIN_ADD_TRACK_COMMAND}>Add Track</option>
                <option value=${AppConstants.PARAMETER_ADMIN_ALL_USERS_COMMAND} selected={b}>All Users</option>
            </select>
            <br>
            <input type="submit" value="Choose">
        </form>
    </div>

    <center style="padding-top:25px">
        <div>
            <%
                String command;
                if (request.getParameter(AppConstants.PARAMETER_COMMAND) == null) {
                    command = (String) request.getSession().getAttribute(AppConstants.PARAMETER_COMMAND);
                } else {
                    command = request.getParameter("command");
                }

                switch (command) {
                    case AppConstants.PARAMETER_CLIENT_ALL_TRACKS_COMMAND:
            %>
            <jsp:include page="AllTracks.jsp"/>
            <%
                    break;
                case AppConstants.PARAMETER_ADMIN_ALL_USERS_COMMAND:
            %>
            <jsp:include page="<%=AppConstants.PAGE_ALL_USERS%>"/>
            <%
                        break;
                }
            %>
        </div>
    </center>
</div>
</body>
</html>
