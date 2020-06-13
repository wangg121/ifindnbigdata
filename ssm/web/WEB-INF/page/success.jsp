<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 2020/6/3
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>success</h1>
  time:${requestScope.get("time")}
  <br><br>

  name:${requestScope.get("name")}

  <br>
  abc:${requestScope.abc}
  <br>
  mx:${requestScope.mx}
  </body>
</html>
