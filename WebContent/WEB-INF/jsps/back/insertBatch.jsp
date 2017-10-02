<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InsertBatch</title>
<script type="text/javascript"
	src="<%=basePath%>resources/js/back/insert.js"></script>
</head>
<body>
	<h1>批量插入数据:</h1>
	<form action="<%=basePath%>InsertServlet.action" method="post">
		<table border="1" width="50%" id="table">
			<tr>
				<th>指令</th>
				<th>描述</th>
				<th>内容</th>
				<th>操作</th>
			</tr>

			<tr>
				<td><input type="text" name="command" value=""></td>
				<td><input type="text" name="description" value=""></td>
				<td><input type="text" name="content" value=""></td>
				<td><a href="javascript:;" onclick="deleteRow(this)">删除</a></td>
				<!--在删除按钮上添加点击事件  -->
			</tr>

			<tr>
				<td><input type="text" name="command" value=""></td>
				<td><input type="text" name="description" value=""></td>
				<td><input type="text" name="content" value=""></td>
				<td><a href="javascript:;" onclick="deleteRow(this)">删除</a></td>
				<!--在删除按钮上添加点击事件  -->
			</tr>

		</table>
		<input type="button" value="添加一行" onclick="addOne()" /><br/>
		<input type="submit" value="插入数据" name="submit" />
		<!--在添加按钮上添加点击事件  -->
	</form>
</body>
</html>