<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.trackstore.entity.Track" %>
<%@ page import="uz.pdp.trackstore.entity.User" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<%@ page import="uz.pdp.trackstore.entity.enums.RoleName" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Tracks</title>
</head>
<body>
<center style="padding-top:25px">
    <div style="overflow-y: scroll">
        <%
            User user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
            List<Track> trackList = (List<Track>) session.getAttribute(AppConstants.PARAMETER_CLIENT_TRACKS_COMMAND);
            if (trackList != null) {
        %>
        <table class="table table-hover" style="text-align: center">
            <tr cellpadding="10" border="1" style="background-color: #ffffcc; font-size-adjust: initial">
                <th>Name</th>
                <th>Artist name</th>
                <th>Description</th>
                <th>Genre name</th>
                <th>Price</th>
                <th>Album name</th>
                <%
                    if (user.getRoleName().equals(RoleName.CLIENT.name())){
                    %>
                <th>Buy</th>
                <%
                }else {
                %>
                <th>Add Playlist</th>
                <%
                    }
                %>
            </tr>
            <%
                for (Track track : trackList) {

            %>
            <tr>
                <td><%=track.getName()%>
                </td>
                <td><%=track.getArtistName()%>
                </td>
                <td><%=track.getDescription()%>
                </td>
                <td><%=track.getGenreName()%>
                </td>
                <td><%=track.getPrice()%>
                </td>
                <td><%=track.getAlbumId().getName()%>
                </td>
                <td>
                    <%if (user.getRoleName().equals(RoleName.CLIENT.name())){
                    %>
                    <a href="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_CLIENT_BUY_TRACK}&${AppConstants.PARAMETER_TRACK_ID}=<%= track.getId()%>">Buy</a>
                <%}else {%>
                    <a href="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_CLIENT_START_ADD_TO_PLAYLIST}&${AppConstants.PARAMETER_TRACK_ID}=<%= track.getId()%>">Add to Playlist</a>
                    <%}%>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%

        } else {
        %>
        Track list is empty!
        <%
            }
        %>
    </div>
</center>
</body>
</html>
