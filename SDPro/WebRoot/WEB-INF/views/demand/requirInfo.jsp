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
<link href="scripts/thirds/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link href="scripts/thirds/dataTables/css/dataTables.bootstrap.css"
	rel="stylesheet">
<title>报名</title>
<script src="scripts/require.js" data-main="scripts/demandMain.js"></script>
</head>
<body>
<input type="hidden" id="type" value="${type}"/>
<input type="hidden" id="flag" value="${flag}"/>
<input type="hidden" id="rid" value="${rid}"/>
	<div class="container-fluid">		
		<div class="row-fluid">
			<span class="span2">
				<strong><span id="demand_type"></span></strong>
			</span>
			<span class="span10">
				<strong><span id="sign" style="color:red;"></span></strong>
			</span>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<table id="demand_myPublish" class="table table-striped table-bordered">
					
				</table>
			</div>
			
		</div>
	</div>
	    <!-- Button to trigger modal -->
   
     
    <!-- Modal -->
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <form class="form-horizontal " role="form"  enctype="multipart/form-data" method="post" action="upload">
	      <input type="hidden" name="fid" id="fid"/>
	      <input type="hidden" name="filetype" id="filetype"/>
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	        <h3 id="myModalLabel">文件上传</h3>
	      </div>
	      <div class="modal-body">
	      <!--  	<label class="control-label">Select File</label> -->
			<input id="input-1" type="file" class="file" name="file">
	      </div>
	      <div class="modal-footer">
	        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	        <button class="btn btn-primary" type="submit">上传</button>
	      </div>
      </form>
    </div>
</body>
</html>