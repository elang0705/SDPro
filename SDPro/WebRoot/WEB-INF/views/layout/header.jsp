<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
    String username = (String)request.getSession().getAttribute("USER_NAME");
%>
<style>
.nav-collapse .nav>li .dropdown-menu {
	margin: 0;
}

.nav-collapse .nav>li:hover .dropdown-menu {
	display: block;
}
</style>
<div class="navbar ">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> </a> <a
				class="brand" href="init"><img
				src="images/logo.png" width="111" height="30"
				alt="w3cschool logo" />
			</a>
			<div class="nav-collapse" style="float:right;">
				<ul class="nav" id="init_nav">
					<!-- li class="active"><a href="#">Home</a></li-->
					<li><a href="login">登录</a></li>
					<li><a href="register">注册</a></li>
					<li class="dropdown"><a href="#menu">个人中心</a>
						<ul class="dropdown-menu">
							<li><a href="myRequire?type=1">我发布的需求</a>
							</li>
							<li><a href="myRequire?type=2">我参与竞标的需求</a>
							</li>
							<li><a href="complete">完善个人信息</a>
							</li>
							<li><a href="qpInfo">个人基本信息</a>
							</li>
							
						</ul>
					</li>
					<li><a href="#contact">关于我们</a></li>
					<li><a href="<%=path%>/logout">退出</a></li>
					<li><a href="#">欢迎：<%=username %></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>