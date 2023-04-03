<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>歸還DVD</title>
</head>
<body>
	<div><c:out value = "${msg }"/></div>
	<c:choose>
		<c:when test="${fn:length(dvds) > 0 }">
			<form action="/dvd/return" method="post">
				<table border="1">
					<tr>
						<th></th>
						<th>序号</th>
						<th>状态</th>
						<th>名称</th>
						<th>借出日期</th>
						<th>借出次数</th>
					</tr>
					<c:forEach var="i" begin="0" end="${fn:length(dvds)  - 1}" step="1">
						<tr>
							<td><input type="radio" name="dvdId"  value="${dvds[i].id }"></td>
							<td>${i+1}</td>
							<td>${dvds[i].state1 }</td>
							<td><c:out value="${dvds[i].name1}" /></td>
							<td>${dvds[i].date1}</td>
							<td>${dvds[i].count1}</td>
						</tr>
					</c:forEach>
				</table>
				<input type="submit" value="歸還" >
			</form>
		</c:when>
		<c:otherwise>
			<p>系統中沒有可歸還DVD，無法進行刪除操作</p>
		</c:otherwise>
	</c:choose>
	<a href="/dvd/Menu">返回menu</a>

</body>
</html>