<%@ page import="dev.skyherobrine.giuaky_t4_t1315.services.impl.CandidateService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 25-Oct-23
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển Thị Chi Tiết Các Ứng Viên Sử Dụng Giấy Phép</title>
</head>
<style>
    table {
        width: 100%;
        text-align: center;
    }
</style>
<body>
<table>
    <thead>
    <tr>
        <th>Mã Ứng Viên</th>
        <th>Tên Ứng Viên</th>
        <th>Email</th>
        <th>Số Điện Thoại</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <%= new CandidateService().getDataRowsTableWithUsingMail() %>
    </tbody>
</table>
</body>
</html>
