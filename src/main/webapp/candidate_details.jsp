<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26-Oct-23
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông Tin Chi Tiết Của Candidate</title>
</head>
<body>
    <h3>Thông Tin Chi Tiết</h3>
    <%= request.getServletContext().getAttribute("candidate_details") %>
</body>
</html>
