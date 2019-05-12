<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link href="<%=path%>/css/common.css" />
<link
	href="scripts/thirds/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="scripts/require.js" data-main="scripts/registerMain.js"></script>
</head>
<body>
	<form class="form-horizontal" id="zhuce_validate"  name="zhuce_validate" method="post" action="addUser">
		<fieldset>
			<legend>用户注册</legend>
			<div class="control-group">
				<label class="control-label" for="input01">用户类型</label> 
				<div class="controls">
					<input type="radio" name="type" id="type01" value="1" checked>个人
					<input type="radio"	name="type" id="type02" value="2">团队
					<input type="radio" name="type" id="type03"	value="3">企业
				</div>
				
			</div>
			<div class="control-group">
				<label class="control-label" for="input01">用户名</label>
				<div class="controls">
					<input type="text" class="input-xlarge" name="username" id="username">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">密码</label>
				<div class="controls">
					<input type="password" name="pwd" id="pwd" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">确认密码</label>
				<div class="controls">
					<input type="password" name="pwd2" id="pwd2" />
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="input01">手机号</label>
				<div class="controls">
					<input type="text" class="input-xlarge" name="phone" id="phone">
				</div>
			</div>
			<div class="form-actions">
				<input type="submit" value="提交" class="btn btn-primary">
			</div>
		</fieldset>
	</form>
</body>
</html>