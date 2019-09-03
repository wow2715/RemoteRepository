<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' />
<meta charset="UTF-8">
<title>會員資料</title>
</head>
<body>
<p>&nbsp;</p>
<hr>
<div class='center' >
	<h1>會員資料</h1>
	<c:if test='${empty allMembers}'>
		查無會員資料<br>
	</c:if>
	<c:if test='${not empty allMembers}'>
		<c:forEach var='member' varStatus='vs' items='${allMembers}'>
			<c:if test ='${vs.first }'>
				<c:out value="<table border='1'>" escapeXml='false'/>
				<c:out value="<tr><td>帳號</td><td>會員名稱</td><td>密碼</td></tr>" escapeXml='false'/>
			</c:if>
			
			<tr>
				<td><a href='findMember.do?key=${member.pk}'>${member.id}</a></td>
				<td>${member.name}</td>
				<td>${member.pswd}</td>
			</tr>
			<c:if test ='${vs.last }'>
				<c:out value="</table>" escapeXml='false'/>
			</c:if>
		</c:forEach>
	</c:if>
<p/>
<a href='${pageContext.request.contextPath}/ch01/index.jsp'>回到會員管理</a>
</div>
</body>
</html>