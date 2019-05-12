<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
<title>模板一</title>

<link rel="stylesheet" href="scripts/thirds/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="scripts/thirds/bootstrap/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="scripts/thirds/bootstrap/css/unicorn.login.css" />
<script src="scripts/require.js" data-main="scripts/loginMain.js"></script>
</head>
</head>
<div id="logo">
	<img src="images/logo.png" alt="" />
</div>
<div id="loginbox">
	<form id="loginform" class="form-vertical" action="userLogin" method="post">
		<p><span style="color:red;font-size: 18px;">${sign}</span>	</p>
		<div class="control-group">
			<div class="controls">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-user"></i> </span><input
						type="text" name="username" placeholder="Username" />
				</div>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-lock"></i> </span><input
						type="password" name="pwd" placeholder="Password" />
				</div>
			</div>
		</div>
		<div class="form-actions">
			<span class="pull-left"><a href="#" class="flip-link"
				id="to-recover">忘记密码?</a> </span> <span class="pull-right"><input
				type="submit" class="btn btn-inverse" value="Login" /> </span>
		</div>
	</form>
	<form id="recoverform" action="#" class="form-vertical">
		<p>忘记密码</p>
		<div class="control-group">
			<div class="controls">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-envelope"></i> </span><input
						type="text" placeholder="E-mail address" />
				</div>
			</div>
		</div>
		<div class="form-actions">
			<span class="pull-left"><a href="#" class="flip-link"
				id="to-login">&lt; Back to login</a> </span> <span class="pull-right"><input
				type="submit" class="btn btn-inverse" value="Recover" /> </span>
		</div>
	</form>
	
</div>