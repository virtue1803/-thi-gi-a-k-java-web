<%@ page import="dev.skyherobrine.giuaky_t4_t1315.services.impl.ExperienceService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 25-Oct-23
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển Thị Chi Tiết Các Ứng Viên Theo Role</title>
</head>
<style>
    table {
        width: 100%;
        text-align: center;
    }
</style>
<body>
    <form action="${pageContext.request.contextPath}/pas" method="post">
        <select name="select_roles">
            <option value="Administrator">Administrator</option>
            <option value="Staff">Staff</option>
            <option value="Manager">Manager</option>
            <option value="Executive">Executive</option>
        </select>
        <input type="submit" name="action" value="View Role">
    </form>
    <h1>Danh Sách Các Thành Viên Theo Role</h1>
    <table>
        <thead>
            <tr>
                <th>Họ tên</th>
                <th>Tên Công Ty</th>
                <th>Ngày Bắt Đầu</th>
                <th>Ngày Kết Thúc</th>
            </tr>
        </thead>
        <tbody>
            <%= request.getServletContext().getAttribute("list_candidates_by_role")%>
        </tbody>
    </table>
</body>
</html>
