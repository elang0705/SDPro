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
<link href="scripts/thirds/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<title>编辑信息</title>
<script src="scripts/require.js" data-main="scripts/indexMain.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="col-md-6 validation-grids widget-shadow"
					data-example-id="basic-forms">
					<div class="form-title">
						<h4>编辑账户信息</h4>
					</div>
					<div class="form-body">					
						<form data-toggle="validator" id="editPersonInfo"  name="editPersonInfo" method="post" action="modifyP">
							<input type="hidden" name="pid" value="${pInfo.pid}"/>
							<input type="hidden" name="phone" value="${pInfo.phone}"/>
							<div class="form-group">
								<span class="help-block with-errors">真实姓名：</span>
								<input
									type="text" class="form-control" id="realName" name="realName" value="${pInfo.realName}"
									placeholder="姓名" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">昵称：</span> <input
									type="text" class="form-control" id="nickname" name="nickname" value="${pInfo.nickname}"
									placeholder="昵称" required>
							</div>
							<div class="form-group has-feedback">
								<span class="help-block with-errors">电子邮箱：</span> <input
									type="email" class="form-control" id="email" name="email"
									placeholder="Email" value="${pInfo.email}"
									data-error="Bruh, that email address is invalid" required>
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								
							</div>
							<div class="form-group">
								<span class="help-block with-errors">性别：</span>
								<div class="radio">
									<label> <input type="radio" name="sex" id="sex01" value="1" required>
										男 </label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="sex" id="sex02" value="2" required>
										女 </label>
								</div>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">身份证号：</span> <input
									type="text" class="form-control" name="identity" id="identity" value="${pInfo.identity}"
									placeholder="身份证号" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">出生日期：</span> <input
									type="text" class="form-control" id="birthday" name="birthday" value="${pInfo.birthday}"
									placeholder="出生日期" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">QQ：</span> <input
									type="text" class="form-control" id="qq" name="qq" value="${pInfo.qq}"
									placeholder="姓名" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">微信号：</span> <input
									type="text" class="form-control" id="weixin" name="weixin" value="${pInfo.weixin}"
									placeholder="姓名" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">参加工作时间：</span> <input
									type="text" class="form-control" id="workTime" name="workTime" value="${pInfo.workTime}"
									placeholder="参加工作时间" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">常住地：</span> <input
									type="text" class="form-control" id="address" name="address" value="${pInfo.address}"
									placeholder="常住地" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">学历：</span> <input
									type="text" class="form-control" id="education" name="education" value="${pInfo.education}"
									placeholder="学历" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">毕业院校：</span> <input
									type="text" class="form-control" id="university" value="${pInfo.university}"
									name="university" placeholder="毕业院校" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">专业：</span> <input
									type="text" class="form-control" id="major" name="major" value="${pInfo.major}"
									placeholder="专业" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">职业：</span> <input
									type="text" class="form-control" id="professional" value="${pInfo.professional}"
									name="professional" placeholder="职业" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">接包意向：</span> <input
									type="text" class="form-control" id="intention" value="${pInfo.intention}"
									name="intention" placeholder="接包意向" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">自我介绍：</span> <input
									type="text" class="form-control" id="perIntroduce" value="${pInfo.perIntroduce}"
									name="perIntroduce" placeholder="自我介绍" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">项目案例：</span> <input
									type="text" class="form-control" id="projectCase" value="${pInfo.projectCase}"
									name="projectCase" placeholder="项目案例" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">职业资格证：</span> <input
									type="text" class="form-control" id="workCertificate" value="${pInfo.workCertificate}"
									name="workCertificate" placeholder="职业资格证" required>
							</div>
							<div class="form-group">
								<span class="help-block with-errors">高级职位：</span> <input
									type="text" class="form-control" id="level" name="level" value="${pInfo.level}"
									placeholder="高级职位" required>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary disabled">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>