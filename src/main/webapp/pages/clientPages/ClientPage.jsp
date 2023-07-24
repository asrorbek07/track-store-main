<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<html>
<head>
    <title>Welcome Client Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<% boolean b = true;%>
<div>
    <div style="width: 600px; margin-left: 10px">
        <form action="/controller?">
            <label for="commands"><h4><b>Menu:</b></h4></label>
            <select class="form-select w-50" name=${AppConstants.PARAMETER_COMMAND} id="commands">
                <option value=${AppConstants.PARAMETER_CLIENT_ALL_TRACKS_COMMAND}>All Tracks</option>
                <option value=${AppConstants.PARAMETER_CLIENT_TRACKS_COMMAND} selected={b}>My Tracks</option>
                <option value=${AppConstants.PARAMETER_CLIENT_ALL_REVIEW_COMMAND}>All Review</option>
                <option value=${AppConstants.PARAMETER_CLIENT_INFO_COMMAND}>My Info</option>
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
            <jsp:include page="<%=AppConstants.PAGE_ALL_TRACKS%>"/>
            <%
                        break;
                    case AppConstants.PARAMETER_CLIENT_TRACKS_COMMAND:
            %>
            <jsp:include page="<%=AppConstants.PAGE_CLIENT_TRACKS%>"/>
            <%
                    break;
                case AppConstants.PARAMETER_CLIENT_ALL_REVIEW_COMMAND:
            %>
            <jsp:include page="<%=AppConstants.PAGE_ALL_REVIEW%>"/>
            <%
                    break;
                case AppConstants.PARAMETER_CLIENT_INFO_COMMAND:
            %>
            <jsp:include page="<%=AppConstants.PAGE_CLIENT_INFO%>"/>
            <%
                    break;
                }
            %>
        </div>
    </center>
</div>
</body>
</html>
