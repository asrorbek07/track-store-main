<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.trackstore.entity.Track" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Tracks</title>
</head>
<body>
<center style="padding-top:25px">
    <div style="overflow-y: scroll">
        <%
            List<Track> clientTracks = (List<Track>) session.getAttribute(AppConstants.PARAMETER_CLIENT_TRACKS_COMMAND);
            if (clientTracks != null) {
        %>
        <table class="table table-hover" style="text-align: center">
            <tr cellpadding="10" border="1" style="background-color: #ffffcc; font-size-adjust: initial">
                <th>Name</th>
                <th>Artist name</th>
                <th>Description</th>
                <th>Genre name</th>
                <th>Price</th>
                <th>Album name</th>
                <th>Review</th>
            </tr>
            <%
                for (Track clientTrack : clientTracks) {
            %>
            <tr>
                <td><%=clientTrack.getName()%>
                </td>
                <td><%=clientTrack.getArtistName()%>
                </td>
                <td><%=clientTrack.getDescription()%>
                </td>
                <td><%=clientTrack.getGenreName()%>
                </td>
                <td><%=clientTrack.getPrice()%>
                </td>
                <td><%=clientTrack.getAlbumId().getName()%>
                </td>
                <td>
                    <a href="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_CLIENT_ADD_REVIEW_COMMAND}&${AppConstants.PARAMETER_TRACK_ID}=<%= clientTrack.getId()%>">Add</a>
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
