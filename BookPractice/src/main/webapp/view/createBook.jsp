<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}<br><br>
Create Book/Author
<form action="createBookServlet" method="post">

Name: <input type="text" name="name"><br> 
Author: <input type="text" name="author"><br> 
Password: <input type="password" name="password"><br> 
<input type="submit">
</form>
</body>
</html>