<%@page import="com.hand.action.LoginAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.Connection,java.sql.DriverManager,java.sql.Statement,java.sql.ResultSet,java.sql.SQLException"%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<link href="bootstrap.min.css" rel="stylesheet">
<style>
.page-header {
	padding-bottom: 9px;
	margin: 0px 0 20px;
	border-bottom: 1px solid boilywood;
	background-color: #3fc2ea;
}

.btn-primary {
	height: 20px;
	font-size: 10px;
}

hr {
	padding: 0px;
	margin: 0px;
}

a {
	color: write
}
</style>
<title>主界面</title>
</head>
<body>
	<div class="page-header">
		<div class="col-xs-4">8820 李俊键</div>
		<div class="col-xs-offset-10">
			<a href="logout.jsp"><%=session.getAttribute("username")%></a>
		</div>

	</div>
	<div class="container-fluid">


		<div id="navbar" class="navbar-collapse collapse col-xs-2">
			<ul class="nav nav-pills nav-stacked">

				<li role="presentation" class="active"><a href="#">Customer管理</a></li>
				<li role="presentation"><a href="FilmIndex.jsp">Film设置</a></li>

			</ul>

		</div>
		<!--/.左侧导航 -->

		<div class="left col-xs-10">
			<div class="col-xs-10">
				<h3>客户管理</h3>
			</div>
		</div>
		<div class="left col-xs-10">
			<hr />
			<div class="col-xs-10">
				客户列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
					class="btn btn-info"><a href="add.jsp">新建</a></label>
			</div>
			<!-- 表格-->
			<table
				class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr>
						<td><strong>操作</strong></td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Address</td>
						<td>Email</td>
						<td>CustomerId</td>
						<td>LastUpdate</td>
				</thead>
				<tbody>
					<%
						ResultSet rs = null;
						String sql = "select customer.first_name,customer.last_name,address.address,customer.email,customer.customer_id,customer.last_update from customer,address where customer.address_id = address.address_id";
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
							Statement st = conn.createStatement();
							rs = st.executeQuery(sql);
							while (rs.next()) {
					%>

					<tr>
						<td><button type="button" class="btn btn-info"
								data-toggle="modal" data-target="#editModal">编辑</button>/
							<button type="button" class="btn btn-info" data-toggle="modal"
								data-target="#delModal">删除</button></td>
						<td><%=rs.getString(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><%=rs.getString(3)%></td>
						<td><%=rs.getString(4)%></td>
						<td><%=rs.getInt(5)%></td>
						<td><%=rs.getString(6)%></td>
					</tr>
					<%
						}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					%>
				</tbody>
			</table>
			<!--分页-->
			<nav class="col-xs-offset-8">

				<ul class="pagination" id="pages">
					<li><a href="#" aria-label="Previous" id="priw"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#" class="pager">1</a></li>
					<li><a href="#" class="pager">2</a></li>
					<li><a href="#" class="pager">3</a></li>
					<li><a href="#" class="pager">4</a></li>
					<li><a href="#" class="pager">5</a></li>
					<li><a href="#" aria-label="Next" id="next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>
