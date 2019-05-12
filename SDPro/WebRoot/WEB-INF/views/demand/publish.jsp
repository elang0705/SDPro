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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>需求发布</title>
<script src="scripts/require.js" data-main="scripts/demandMain.js"></script>
</head>
<body>
	<div class="container ">
    <div class="row">
        <div class="span9">

            <img src="images/fblc.PNG" width="100%" height="150" alt="" />
            <form class="form-horizontal " role="form"  enctype="multipart/form-data" method="post" action="publish">
                <fieldset>
                    <legend>发布需求</legend>
                <div class="form-group">
                    <label for="reqname" class="col-sm-2 control-label">标题</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="reqname" name="title"
                               placeholder="请输入需求名称">
                    </div>
                </div>
                </fieldset>
                    <fieldset>
                        <legend></legend>
                <div class="form-group">
                    <label for="category" class="col-sm-2 control-label">分类</label>
                    <div class="col-sm-10">
                        <select id="category" class="selectpicker show-tick form-control" name="category">
                            <option value="1">建筑</option>
                            <option value="2">结构</option>
                            <option value="3">给排水</option>
                            <option value="4">暖通</option>
                            <option value="5">电气</option>
                        </select>
                    </div>
                </div>
                    </fieldset>
                <fieldset>
                    <legend></legend>
                <div class="form-group">
                    <label for="categoryChild" class="col-sm-2 control-label">二级分类</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="categoryChild" name="categoryChild">
                    </div>
                </div>
                </fieldset>
                <fieldset>
                    <legend></legend>
                <div class="form-group">
                    <label for="describe" class="col-sm-2 control-label">描述</label>
                    <div class="col-sm-10">
                    	<textarea rows="3" class="input-xlarge"  name="describe" id="describe">                   	
                    	</textarea>
                    </div>
                </div>
                </fieldset>
                <fieldset>
                    <legend></legend>
                <div class="form-group">
                     <label for="endTime" class="col-md-2 control-label">报名截止时间</label>
                    <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-MM-dd" data-link-field="endTime" data-link-format="yyyy-mm-dd">
                        <input class="form-control" size="16" type="text" value="" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </div>
                    <input type="hidden" id="endTime" value="" name="endTime"/>
                </div>
                </fieldset>
                <fieldset>
                    <legend></legend>
                <div class="form-group">
                	 <label for="expectTime" class="col-md-2 control-label">预计完成时间</label>
                    <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-MM-dd" data-link-field="expectTime" data-link-format="yyyy-mm-dd">
                        <input class="form-control" size="16" type="text" value="" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </div>
                    <input type="hidden" id="expectTime" value="" name="expectTime"/>                    
                </div>
                </fieldset>
                <fieldset>
                    <legend></legend>
                <div class="form-group">
                    <label for="price" class="col-sm-2 control-label">金额</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="price" name="price"
                               placeholder="请输需求预算">
                    </div>
                </div>
                </fieldset>
                 <fieldset>
                    <legend></legend>
                <div class="form-group">
                    <label for="mobile" class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="mobile" name="mobile"
                               placeholder="请输入联系方式">
                    </div>
                </div>
                </fieldset>
                <fieldset>
                    <legend></legend>
                <div class="form-group">
                    <label for="file" class="col-sm-2">上传附件</label>
                    <div class="col-sm-10">
                        <input type="file"  name="file"  id="file">
                    </div>
                </div>
                </fieldset>
                <fieldset>

                <div class="form-group">
                    <label for="publish" class="col-sm-6"></label>
                    <div class="col-sm-6">
                        <button type="submit" id="publish" class="btn btn-primary">发布需求</button>
                    </div>
                </div>
                </fieldset>
            </form>
        </div>
        <div class="span3">
            <h3>公告栏</h3>
            <p>西安优活网上线了，这里有您梦寐以求的创业机会，有您的发财之道，有您的财富之旅，还在等什么，赶快来注册吧，开启你的追梦之旅，实现您的财富自由之路。</p>
            <div class="tabbable" id="tabs-969278">
                <ul class="nav nav-tabs">
                    <li><a href="#panel-19988" data-toggle="tab">接包明星榜</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane" id="panel-19988">
                        <p>I'm in Section 1.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>