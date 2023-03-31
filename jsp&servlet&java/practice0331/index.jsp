<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそ</title>
</head>
<body>
<h4>ようこそ</h4>
<a href ="/Counter/Index?action=great">よいね</a>
<span>${count.great}人</span>
<a href ="/Counter/Index?action=notGreat" >よくないね</a>
<span>${count.notGreat}人</span>
</body>
</html>