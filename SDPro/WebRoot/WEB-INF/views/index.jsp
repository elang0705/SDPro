<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>基于bootstrup的响应式jQuery滚动新闻插件|DEMO_jQuery之家-自由分享jQuery、html5、css3的插件库</title>
<link href="scripts/thirds/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="scripts/thirds/bootstrap/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="scripts/thirds/bootstrap/css/default.css">
<link href="scripts/thirds/bootstrap/css/bootstrap.min.old.css"
	rel="stylesheet" type="text/css" />
<link href="scripts/thirds/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
<link href="scripts/thirds/bootstrap/css/site.css" rel="stylesheet"
	type="text/css" />
<script src="scripts/require.js" data-main="scripts/indexMain.js"></script>

</head>
<body>
	
	<div id="myCarousel" class="carousel slide">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img alt="" src="images/3.PNG"
					style="height: 300px;max-width: none;margin-left:-285px;" />
				<div class="carousel-caption">
					<h4>自行车</h4>
					<p>
						以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。</p>
				</div>
			</div>
			<div class="item">
				<img alt="" src="images/2.PNG"
					style="height: 300px;max-width: none;margin-left:-285px;" />
				<div class="carousel-caption">
					<h4>冲浪</h4>
					<p>
						冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。
					</p>
				</div>
			</div>
			<div class="item">
				<img alt="" src="images/1.PNG"
					style="height: 300px;max-width: none;margin-left:-285px;" />
				<div class="carousel-caption">
					<h4>棒球</h4>
					<p>棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。</p>
				</div>
			</div>
		</div>
		<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
	<div class="htmleaf-container">
		<div class="container mp30">
			<div class="row">
				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-list-alt"></span><b>最新需求</b>
							<a class="btn btn-primary right" style="float:right" href="myRequire?type=3">我要报名</a>							
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12">
									<ul class="demand_new">
										<c:forEach items="${newlist}" var="demand" varStatus="vs">
										 	<li class="news-item">
										 		<table cellpadding="4">
													<tr>
														<td style="width:10%">
															<s:property value="#vs.index+1"/>  
														</td>
														<td style="width:30%">${demand.title}</td>
														<td style="width:30%">${demand.price}</td>
														<td style="width:30%">${demand.creDate}</td>
													</tr>
												</table>
										 	</li>
									     </c:forEach>	
									</ul>
								</div>
							</div>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-list-alt"></span><b>热门需求</b>
							<a class="btn btn-primary right" style="float:right" href="pb">我要发包</a> 
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12">			
													
									<ul class="demand_hot">
										<c:forEach items="${hotlist}" var="demand" varStatus="vs">
										 	<li class="news-item">
										 		<table cellpadding="4">													<tr>
														<td style="width:10%">
															<s:property value="#vs.index+1"/>  
														</td>
														<td style="width:30%">${demand.title}</td>
														<td style="width:30%">${demand.price}</td>
														<td style="width:30%">${demand.creDate}</td>
													</tr>
												</table>
										 	</li>
									     </c:forEach>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-list-alt"></span><b>公告栏</b>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12">
									<ul id="news">
										<li class="news-item">Curabitur porttitor ante eget
											hendrerit adipiscing. Maecenas at magna accumsan, rhoncus
											neque id, fringilla dolor. <a href="#">Read more...</a></li>
										<li class="news-item">Curabitur porttitor ante eget
											hendrerit adipiscing. Maecenas at magna accumsan, rhoncus
											neque id, fringilla dolor. <a href="#">Read more...</a></li>
										<li class="news-item">Praesent ornare nisl lorem, ut
											condimentum lectus gravida ut. Ut velit nunc, vehicula
											volutpat laoreet vel, consequat eu mauris. <a href="#">Read
												more...</a></li>
										<li class="news-item">Nunc ultrices tortor eu massa
											placerat posuere. Vivamus viverra sagittis nunc. Nunc et
											imperdiet magna. Mauris sed eros nulla. <a href="#">Read
												more...</a></li>
										<li class="news-item">Morbi sodales tellus sit amet leo
											congue bibendum. Ut non mauris eu neque fermentum pharetra. <a
											href="#">Read more...</a></li>
										<li class="news-item">In pharetra suscipit orci sed
											viverra. Praesent at sollicitudin tortor, id sagittis magna.
											Fusce massa sem, bibendum id. <a href="#">Read more...</a>
										</li>
										<li class="news-item">Maecenas nec ligula sed est
											suscipit aliquet sed eget ipsum. Suspendisse id auctor nibh.
											Ut porttitor volutpat augue, non sodales odio dignissi id. <a
											href="#">Read more...</a></li>
										<li class="news-item">Onec bibendum consectetur diam, nec
											euismod urna venenatis eget. Cras consequat convallis leo. <a
											href="#">Read more...</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
			</div>
		</div>		
	</div>	
</body>
</html>