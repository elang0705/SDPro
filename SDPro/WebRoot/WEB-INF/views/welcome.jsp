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

<title>My JSP 'welcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<script type="text/javascript">
		function countDown(secs, surl) {
			var jumpTo = document.getElementById('jumpTo');
			jumpTo.innerHTML = secs;
			if (--secs > 0) {
				setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
			} else {
				location.href = surl;
				-ma
			}
		}
	</script>
</head>

<body>
	<h1>${flag}</h1>
	<a href="init"><span id="jumpTo">5</span>秒后系统会自动跳转，也可点击本处直接跳</a>
	<script type="text/javascript">
		countDown(3, 'init');
	</script>

</body>
</html>
