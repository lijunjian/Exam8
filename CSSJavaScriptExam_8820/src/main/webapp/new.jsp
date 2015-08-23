<%@page import="com.hand.jdbc.Query"%>
<%@page import="com.hand.jdbc.MySQLConnection"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加</title>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<style type="text/css">
.all{
	height:800px;
	width:1000px;
	align:center;
}
.head{
	background-color:blue;
	width:100%;
	height：50px;
}
.left{
	width:150px;
	height:750px;
	float:left;
	background-color:antiquewhite;
	
}
.right{
	float:left;
	width:850px;
	height:750px;
}
p{
	padding-left:10px;
	font-size: 20px;
}
#admin{
	text-align:right;
}
ul li{
	list-style: none;
}
ul a{
	text-decoration: none;
}
</style>
</head>
<body>
<div class="all">
<div class="head">
<p id="logo"><b>8820 李俊键</b>

<a id="admin">
<%
String flag="";
Object obj=session.getAttribute("flag");

if(obj!=null){
	flag=obj.toString();
}
if(flag.equals("login_success")){
%>
<a href="<%= request.getContextPath()%>/LogoutServlet">退出</a>
<%}else{ %>
<a href="<%= request.getContextPath()%>/login.jsp">登录</a>
<%} %>
</a>
</p>
</div>
<div class="left">
		<div class="span3 col-sm-2 col-sm-offset-2">
			<ul class="nav nav-list">
				<li class="nav-header">
					<a href="index.jsp">增加Customer</a>
				</li>		
			</ul>
		</div>
</div>
<div class="right">
<p><b>创建Customer</b></p>
<div id="list">
<form  action="<%=request.getContextPath()%>/NewServlet" method="post" name="loginForm" onsubmit="return check();">
		<table border="0" cellspacing="0" cellpadding="5" bordercolor="silver" align="center" width="100%">
			<tr>
				<td colspan="2" align="left" bgcolor="#E8E8E8">基本信息</td>
			</tr>
			<tr>
				<td align="right">First Name<a style="color:red">*</a></td>
				<td><input type="text" name="firstname" width="100px"/></td>
			</tr>
			<tr>
				<td align="right">Last Name<a style="color:red">*</a></td>
				<td><input type="text" name="lastname" width="100px"/></td>
			</tr>
			<tr>
				<td align="right">Email</td>
				<td><input type="text" name="email" width="100px"/></td>
			</tr>
			<tr>
				<td align="right">Address<a style="color:red">*</a></td>
				<td><input type="password" name="address" width="100px"/></td>
			</tr>
			<tr>
				<td></td>
				<td align="left">
					<input type="submit" name="sumbit" value="新建"/>
					<a href="index.jsp"><button>取消</button></a>
				</td>
			</tr>
		</table>
	</form>
</div>
</div>


</div>
</body>
</html>