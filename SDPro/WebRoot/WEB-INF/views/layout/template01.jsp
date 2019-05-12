<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="<%=path%>/css/common.css"/>
<link href="../../<%=path%>/scripts/thirds/bootstrap/css/bootstrap.min.css"	rel="stylesheet">
<style>
#content{margin:100px 20px 30px 20px}
</style>
</head>
<body>
<div id="header">
<tiles:insertAttribute name="top"/>
</div>
<div id="content">
<tiles:insertAttribute name="content"/>
</div>
<div id="footer">
<tiles:insertAttribute name="footer"/>
</div>


</body>
</html>