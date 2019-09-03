<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' />
<meta charset="UTF-8">
<title>新增會員資料</title>
</head>
<body>
<p>&nbsp;</p>
<hr>
<div class='center'>
<H1>新增會員資料</H1>
<form  action='insertMember.do'  method='POST'  >
帳號:<input type='text'      name='id'   value='${param.id}'> <br> 
<font color='red' size='-3'>${error.id}</font><br><br>

密碼:<input type='password'  name='pswd' value='${param.pswd}'><br>
<font color='red' size='-3'>${error.pswd}</font><br><br>

姓名:<input type='text'      name='name' value='${param.name}'><br>
<font color='red' size='-3'>${error.name}</font><br><br>

<input type='submit'      name='name' value='提交' >
<input type='reset'      name='name' value='還原' ><br><br>	


<a href='${pageContext.request.contextPath}/ch01/index.jsp'>回到會員管理</a>
</form>
</div>
</body>
</html>