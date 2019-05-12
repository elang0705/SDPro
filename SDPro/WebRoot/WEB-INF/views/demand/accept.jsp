<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'accept.jsp' starting page</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="scripts/thirds/bootstrap/css/bootstrap.css"
	rel="stylesheet">
</head>

<body>
	<div class="container-fluid ">
		<div class="row-fluid">
			<span class="span2">
				<strong>${title}</strong>
			</span>
		</div>
		<div class="row-fluid">
			<div class="span12">				
				<form class="form-horizontal " role="form"	 method="post" action="apply">
				    <input type="hidden" id="rid" name="rid" value="${rid}"/>
				    <input type="hidden" id="uid" name="uid" value="${uid}"/>
					<fieldset>
						<legend>需求报价</legend>
						<div class="form-group">
							<label for="offerPrice" class="col-sm-2 control-label">报价</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="offerPrice"
									name="offerPrice" placeholder="请输入你的报价">
							</div>
						</div>
					</fieldset>					
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label for="period" class="col-sm-2 control-label">周期</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="period"
									name="period">
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label for="promise" class="col-sm-2 control-label">承诺服务</label>
							<div class="col-sm-10">
								<textarea rows="3" cols="10" name="promise" id="promise">                   	
                    	</textarea>
							</div>
						</div>
					</fieldset>	
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label for="address" class="col-sm-2 control-label">地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="address" name="address"
									placeholder="请输入地址">
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label for="progress" class="col-sm-2 control-label">预估进度</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="progress"
									name="progress" placeholder="请输入进度">
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label for="risk" class="col-sm-2">风险</label>
							<div class="col-sm-10">
								<input type="text" name="risk" id="risk">
							</div>
						</div>
					</fieldset>
					<fieldset>

						<div class="form-group">
							<label for="join" class="col-sm-6"></label>
							<div class="col-sm-6">
								<button type="submit" id="join" class="btn btn-primary">提交</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
