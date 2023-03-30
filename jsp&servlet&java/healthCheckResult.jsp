<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断結果</title>
</head>
<body>
	<table>
	<tr><th>スッキリ健康診断結果</th></tr>
	<tr><td>身長：${user.height }</td></tr>
	<tr><td>体重：${user.weight }</td></tr>
	<tr><td>BMI：${user.BMI }</td></tr>
	<tr><td>体型：${user.health}</td></tr>
	</table>
</body>
</html>