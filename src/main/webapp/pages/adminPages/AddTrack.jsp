<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<%@ page import="uz.pdp.trackstore.service.AlbumService" %>
<%@ page import="uz.pdp.trackstore.service.impl.AlbumServiceImpl" %>
<%@ page import="uz.pdp.trackstore.entity.Album" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Add track</title>
</head>
<body>
<div style="text-align: center;">
    <h2>Add Track</h2>
    <form class="form-group"
          action="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_ADMIN_ADD_TRACK_COMMAND}"
          method="post">
        <input type="text" placeholder="Enter name" name="${AppConstants.PARAMETER_TRACK_NAME}">
        <input type="text" placeholder="Enter astistName" name="${AppConstants.PARAMETER_TRACK_ARTIST_NAME}">
        <input type="text" placeholder="Enter description" name="${AppConstants.PARAMETER_TRACK_DESCRIPTION}">
        <input type="text" placeholder="Enter genreName" name="${AppConstants.PARAMETER_TRACK_GENRE_NAME}">
        <input type="number" placeholder="Enter price" name="${AppConstants.PARAMETER_TRACK_PRICE}">
        <select name=${AppConstants.PARAMETER_TRACK_ALBUM_ID}>
            <%
                AlbumService albumService = AlbumServiceImpl.getInstance();
                List<Album> albumList = albumService.findAll();
                for (Album album : albumList) {
            %>
            <option value=<%=album.getId()%>><%=album.getName()%>
            </option>
            <%
                }
            %>
        </select>
        <button type="submit">Register</button>
    </form>

</div>
</body>
</html>
