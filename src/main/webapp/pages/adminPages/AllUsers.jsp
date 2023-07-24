<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.trackstore.entity.User" %>
<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<center style="padding-top:25px">
    <div style="overflow-y: scroll">
        <%
            List<User> userList = (List<User>) session.getAttribute(AppConstants.PARAMETER_ADMIN_ALL_USERS_COMMAND);
            if (userList != null) {
        %>
        <table class="table table-hover" style="text-align: center">
            <tr cellpadding="10" border="1" style="background-color: #ffffcc; font-size-adjust: initial">
                <th>Username</th>
                <th>Fullname</th>
                <th>Phone number</th>
                <th>Email</th>
                <th>Active</th>
                <th>ActivateOrBlock</th>
            </tr>
            <%
                for (User user : userList) {
            %>
            <tr>
                <td><%=user.getUserName()%>
                </td>
                <td><%=user.getFullName()%>
                </td>
                <td><%=user.getPhoneNumber()%>
                </td>
                <td><%=user.getEmail()%>
                </td>
                <td><%=user.isActive()?"Active":"Blocked"%>
                </td>
                <td>
                    <%
                        if (user.isActive()){
                    %>
                    <a href="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_ADMIN_BLOCK_OR_ACTIVATE_USER_COMMAND}&${AppConstants.PARAMETER_USER_ID}=<%= user.getId()%>">Block</a>
                    <%
                        } else {
                    %>
                    <a href="/controller?${AppConstants.PARAMETER_COMMAND}=${AppConstants.PARAMETER_ADMIN_BLOCK_OR_ACTIVATE_USER_COMMAND}&${AppConstants.PARAMETER_USER_ID}=<%= user.getId()%>">Activate</a>
                    <%
                        }
                    %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%

        } else {
        %>
        User list is empty!
        <%
            }
        %>
    </div>
</center>
</body>
</html>
