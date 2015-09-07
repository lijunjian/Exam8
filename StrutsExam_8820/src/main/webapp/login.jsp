<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link type="text/css" href="bootstrap.min.css" rel="stylesheet"></link>
<style type="text/css">
body {
	font-size: 20px;
}

p {
	padding-top: 20px;
	padding-left: 50px;
	font-size: 40px;
}

form {
	padding-top: 60px;
}
</style>

</head>
<body background="1.jpg">
	<p>
		<b>8820 李俊键</b>
	</p>
	<s:form name="loginForm" action="login" style="padding-left: 200px;"
		onsubmit="return check();">
		<s:label>电影租赁管理系统</s:label>
		<br />
		<s:label>用户名</s:label>
		<s:textfield name="username" size="20" />
		<br />
		<s:label>&nbsp;&nbsp;&nbsp;&nbsp;密码</s:label>
		<s:textfield name="password" size="20" />
		<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<s:submit value="登录" align="center" />
	</s:form>
</body>
<script type="text/javascript">
	function check() {
		if (document.forms.loginForm.username.value == "") {
			alert("请输入用户名！");
			document.forms.loginForm.username.focus();
			return false;
		} else if (document.forms.loginForm.password.value == "") {
			alert("请输入密码！");
			document.forms.loginForm.password.focus();
			return false;
		} else {
			<%request.getSession().setAttribute("username", "Admin");%>
			return true;
		}
	}
</script>
</html>