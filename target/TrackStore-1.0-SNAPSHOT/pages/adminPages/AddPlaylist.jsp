<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<%@ page import="uz.pdp.trackstore.service.TrackService" %>
<%@ page import="uz.pdp.trackstore.service.impl.TrackServiceImpl" %>
<%@ page import="uz.pdp.trackstore.entity.Track" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.trackstore.entity.Playlist" %>
<%@ page import="java.util.UUID" %>
<html>
<head>
    <title>Add playlist</title>
</head>
<body>
<div style="text-align: center;">
    <h2>Add Playlist</h2>
    <%
        List<Playlist> playlists = (List<Playlist>) session.getAttribute(AppConstants.PARAMETER_CLIENT_ALL_PLAYLIST_COMMAND);
        Track currentTrack = (Track) session.getAttribute(AppConstants.PARAMETER_TRACK_ID);
    %>
    <form class="form-group"
          action="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_ADMIN_ADD_PLAYLIST_COMMAND}"
          method="post">
        <input type="text" value="<%=currentTrack.getName()%>" disabled>
        <select name=${AppConstants.PARAMETER_PLAYLIST_ID}>
            <%
                for (Playlist playlist : playlists) {
            %>
            <option value=<%=playlist.getId()%>><%=playlist.getName()%>
            </option>
            <%
                }
            %>
        </select>
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>
