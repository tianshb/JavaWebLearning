<%--
  Created by IntelliJ IDEA.
  User: CrowHawk
  Date: 17/3/8
  Time: 下午4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="/ErrorPage/error.jsp" language="java"  %>
<html>
<head>
    <title>测试page指令的errorPage属性</title>
</head>
<body>
    <%
        int i = 1/0;
    %>
</body>
</html>
