<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/11
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
      <form action="register" method="post">
          <table>
              <tr>
                  <td>id</td>
                  <td>
                      <INPUT type="text" name="id">
                  </td>
              </tr>
              <tr>
                  <td>name</td>
                  <td>
                      <INPUT type="text" name="name">
                  </td>
              </tr>
              <tr>
                  <td>email</td>
                  <td>
                      <INPUT type="text" name="email">
                  </td>
              </tr>
              <tr>
                  <td>age</td>
                  <td>
                      <INPUT type="text" name="age">
                  </td>
              </tr>
          </table>
          <input type="submit" value="注册">
      </form>
</body>
</html>
