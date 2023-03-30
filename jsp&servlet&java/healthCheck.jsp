<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
<form action="/HealthCheakWeb/Check" method="post">
	<table>
	<tr><th>スッキリ健康診断</th></tr>
	<tr><td>身長：<input type = "text" name = height >(cm)</td></tr>
	<tr><td>体重：<input type = "text" name = weight >(kg)</td></tr>
	<tr><td><input type = "submit" value ="診斷"></td></tr>
	</table>
</form>
</body>
</html>