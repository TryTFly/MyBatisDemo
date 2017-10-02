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
<title>Insert</title>
</head>
<body>
	<h1>新增数据表信息:</h1>
	<form action="<%=basePath%>InsertServlet.action" method="post">
		<table>
			<tr>
				<td>command:</td>
				<td><input type="text" name="command"></td>
			</tr>
			<tr>
				<td>description:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>content:</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>