<%@ page import="uz.pdp.trackstore.utills.AppConstants" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.trackstore.entity.Review" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Reviews</title>
</head>
<body>
<center style="padding-top:25px">
    <div style="overflow-y: scroll">
        <%

            List<Review> reviewList = (List<Review>) session.getAttribute(AppConstants.PARAMETER_CLIENT_ALL_REVIEW_COMMAND);
            if (reviewList != null) {
        %>
        <table class="table table-hover" style="text-align: center">
            <tr cellpadding="10" border="1" style="background-color: #ffffcc; font-size-adjust: initial">
                <th>Review</th>
                <th>Rate</th>
                <th>TrackName</th>
            </tr>
            <%
                for (Review review : reviewList) {

            %>
            <tr>
                <td><%=review.getReview()%>
                </td>
                <td><%=review.getRate()%>
                </td>
                <td><%=review.getTrackId().getName()%>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%

            } else {
        %>
        Review list is empty!
        <%
            }
        %>
    </div>
</center>
</body>
</html>
