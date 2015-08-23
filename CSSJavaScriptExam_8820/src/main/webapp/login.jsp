<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<script type="text/javascript" src="jquery-2.1.4.min.js"></script>
<link type="text/css" href="bootstrap.min.css" rel="stylesheet"></link>
<style type="text/css">
body{
	font-size: 20px;
	
}
p{
	padding-top:20px;
	padding-left:50px;
	font-size: 40px;
}
form{
	padding-top:60px;
}
table{
	background-color:white;
}
</style>

<script type="text/javascript">
	function check() {
		if(document.forms.loginForm.uname.value==""){
			alert("请输入用户名！");
			document.forms.loginForm.uname.focus();
			return false;
		}
		if(document.forms.loginForm.upwd.value==""){
			alert("请输入密码！");
			document.forms.loginForm.upwd.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body background="1.jpg">
<p><b>8820 李俊键</b></p>
	<form  action="<%=request.getContextPath()%>/LoginServlet" method="post" name="loginForm" onsubmit="return check();">
		<%if(request.getAttribute("return_uti")!=null){ %>
		<input type="hidden" name="return_uri" value="<%=request.getAttribute("return_uri") %>">
		<%} %>
		<table border="0" cellspacing="0" cellpadding="5" bordercolor="silver" align="center" width="500px">
			<tr>
				<td colspan="2" align="left" bgcolor="#E8E8E8">电影租赁系统</td>
			</tr>
			<tr>
				<td align="right">用户名</td>
				<td><input type="text" name="uname" width="100px"/></td>
			</tr>
			<tr>
				<td align="right">密码</td>
				<td><input type="password" name="upwd" width="100px"/></td>
			</tr>
			<tr>
				<td></td>
				<td align="left">
					<input type="submit" name="sumbit" value="登录"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>