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

  <form action="/testFormat" method="post">

    <br>
    name: <input type="text" name="lastName" value="zhangsan"/>
    <br>
    email:<input type="text" name="email" value="zhangsan@163.com" />
    <br>
    gender:<input type="text" name="gender" value="12">
    <br>
    birth:<input type="text" name="birth" >
    <br>
    salary:<input type="text" name="salary" >
    <br>

    <input type="submit" value="Submit">

  </form>
  <br><br>
  <form action="/testconversion" method="post">
    <input type="text" name="employee">
    <input type="submit" name="Submit">
  </form>

  <a href="/emps">获取所有的员工信息</a>
  <br><br>
  <a href="/mvc/testRedirect"> testRedirect</a>
  <br><br>

  <form action="/mvc/testModelAttribute" method="post">
    <input type="hidden" name="flag" value="1">
    <br>
    name: <input type="text" name="name" value="zhangsan"/>
    <br>
    email:<input type="text" name="email" value="zhangsan@163.com" />
    <br>
    age:<input type="text" name="age" value="12">
    <br>
    <input type="submit" value="Submit">

  </form>

  <br><br>

  <a href="/mvc/testMap"> testMap</a>
  <br><br>

  <a href="/mvc/testModelAndView"> testModelAndView</a>
  <br><br>
  <a href="/mvc/testrequestparam/?city=tangshan"> testRquestParam</a>
  <br/>
  <br/>

  <a href="/mvc/testparam/zhangsan">testparam</a>
  </body>
</html>
