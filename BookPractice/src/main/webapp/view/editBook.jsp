<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="teal">
	${message}
	<br>
	<br> Edit Book/Author
	<form action="editBookServlet" method="post">
		ID: <input type="text" name="id" value=${bookData.id}><br> Name: <input
			type="text" name="name" value=${bookData.name}><br> Author:
		<input type="text" name="author" value=${bookData.author}><br>
		Password: <input type="password" name="password" value=${bookData.password}><br>
		<input type="submit" value="Edit">
	</form>
</body>
</html>