<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增界面</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/InsertServlet" method="post" name="loginForm">

		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">新增电影</td>
			</tr>
			<tr>
				<td>title：</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr> 
				<td>description：</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>language：</td>
				<td><input type="radio" name="language"  value="1"/>English</td>
				<td><input type="radio" name="language" value="2"/>Italian</td>
				<td><input type="radio" name="language" value="3"/>Japanese</td>
				<td><input type="radio" name="language" value="4"/>Mandarin</td>
				<td><input type="radio" name="language" value="5"/>French</td>
				<td><input type="radio" name="language" value="6"/>German</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="sumbit" value="增加" onclick="return check(this);" />
				 	<input type="reset" name="reset" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>