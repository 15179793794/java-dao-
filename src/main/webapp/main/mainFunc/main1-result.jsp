<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴仁杨
  Date: 2020/9/26
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>输出连接信息</title>
</head>
<body>

<c:if test="${empty sessionScope.name}">
    <%
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    %>>
</c:if>
<table border="black">
    <tr>
        <th>序号</th>
        <th>键</th>
        <th>值</th>
    </tr>
    <c:forEach items="${requestScope.connInfo}" var="i" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${i.key}</td>
            <td>${i.value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
