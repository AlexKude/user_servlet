<%--
  Created by IntelliJ IDEA.
  User: Main Server
  Date: 14.12.2016
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Account</title>
</head>
<body>

<center>
    <form action="<%=request.getContextPath()%>/users" method="post">
        <p><h3>USER ACCOUNT FORM</h3></p>
        <p>Enter your Login :</p>
        <p>Please write only figures and letters.Length: from 4 to 10</p>
        <p><input type="text" name="login"/></p>
        <p>Enter your Family name:</p>
        <p>Please write letters only. Capintal letter first. For example: Johnson</p>
        <p><input type="text" name="surname"/></p>
        <p>Enter your First name: </p>
        <p>Please write letters only. Capintal letter first. For example: John</p>
        <p><input type="text" name="name"/></p>
        <p>Enter your Age:</p>
        <p>Digits only please</p>
        <p><input type="text" name="age"/></p>
        <p>Enter your Phone number: </p>
        <p>Please write as per sample:(305)748-37-53</p>
        <p><input type="text" name="phone"/></p>
        <p>Enter your E-Mail:</p>
        <p>Please write as per sample:test@hotmail.com</p>
        <p><input type="text" name="email"/></p>
        <p>Enter your Address:</p>
        <p><input type="text" name="address"/></p>
        <p>Enter your Password:</p>
        <p>Please write only figures and letters.Length: from 4 to 10</p>
        <p><input type="text" name="password1"/></p>
        <p>Re-Enter your Password:</p>
        <p><input type="text" name="password2"/></p>
        <p>Enter Service Provider Pin Code:</p>
        <p><input type="text" name="pin"/></p>
        <p><input type="submit" value="CREATE ACCOUNT"/></p>
    </form>
</center>

</body>
</html>
