<%@page import="com.hand.jdbc.Query"%>
<%@page import="com.hand.jdbc.MySQLConnection"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%
    Connection conn;int count=0;
	conn = MySQLConnection.getConnection();
	ResultSet rs=Query.CQuery(conn);
    %>
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
p a{
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
					<a href="index.jsp">Customer管理</a>
				</li>
				<li class="active">
					<a href="#">film设置</a>
				</li>		
			</ul>
		</div>
</div>
<div class="right">
<p><b>客户管理</b></p>
<div id="list">
客户列表<a href="new.jsp"><button>新建</button></a><br/>
<table style="width:100%;height: auto;text-align: center;margin: auto;" border="1px">
 	
    <tr>
        <td>操作</td>
        <td>First Name</td>
        <td >Last Name</td>
        <td >Address</td>
        <td >Email</td>
        <td >CustomerId</td>
        <td >LastUpdate</td>
    </tr>
   <%while(rs.next()){%>
    <tr>
    <td>
        <a href="delete.jsp?line=<%=rs.getInt(5)%>">删除</a>
            /
            <a href="update.jsp?line=<%=rs.getInt(5)%>">编辑</a>
        </td>
        <td><%=rs.getString(1) %></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
        <td><%=rs.getString(4) %></td>
        <td><%=rs.getInt(5) %></td>
        <td><%=rs.getDate(6) %></td>
        
        
    </tr>
    <%} %>
</table>
</div>
</div>


</div>
</body>
</html>