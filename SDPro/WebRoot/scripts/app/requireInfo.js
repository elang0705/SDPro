define([ "jquery", "validate", "dataTables", "bootstrap","bootstrap-datetimepicker" ],function($) {
	$('.form_date').datetimepicker({
		language : 'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});
			var zero = "0";
			var oneCode = "1";
			var twoCode = "2";
			var threeCode = "3";
			var table;
			var type = $('#type').val();
			var flag = $('#flag').val();
			var rid =  $('#rid').val();		
			var param = [];
			var titles;
			if ("1" == type) {// 我发布的需求
				titles = [ {
					"bVisible" : false,
					"aTargets" : [ 0 ],
					"title" : "需求ID",
					"data" : "rid"
				}, {
					"bVisible" : true,
					"aTargets" : [ 1 ],
					"title" : "需求名称",
					"data" : "title"
				}, {
					"bVisible" : true,
					"aTargets" : [ 2 ],
					"title" : "需求价格",
					"data" : "price"
				}, {
					"bVisible" : true,
					"aTargets" : [ 3 ],
					"title" : "需求状态",
					"data" : "state"
				}, {
					"bVisible" : true,
					"aTargets" : [ 4 ],
					"title" : "需求创建时间",
					"data" : "creDate"
				}, {
					"bVisible" : false,
					"aTargets" : [ 5 ],
					"title" : "创建人",
					"data" : "userId"
				}, {
					"bVisible" : true,
					"aTargets" : [ 9 ],
					"title" : "操作",
					"data" : "todo"
				}, {
					"bVisible" : true,
					"aTargets" : [ 6 ],
					"title" : "是否传过合同",
					"data" : "rid"
				},{
					"bVisible" : true,
					"aTargets" : [ 7 ],
					"title" : "是否上传作品",
					"data" : "rid"
				},{
					"bVisible" : true,
					"aTargets" : [ 8 ],
					"title" : "是否确定人员",
					"data" : "rid"
				}];
			} else if ("2" == type) {// 我参与竞标的需求
				titles = [ {
					"bVisible" : false,
					"aTargets" : [ 0 ],
					"title" : "需求ID",
					"data" : "rid"
				}, {
					"bVisible" : true,
					"aTargets" : [ 1 ],
					"title" : "需求名称",
					"data" : "title"
				}, {
					"bVisible" : true,
					"aTargets" : [ 2 ],
					"title" : "需求价格",
					"data" : "price"
				}, {
					"bVisible" : true,
					"aTargets" : [ 3 ],
					"title" : "需求状态",
					"data" : "state"
				}, {
					"bVisible" : true,
					"aTargets" : [ 4 ],
					"title" : "需求创建时间",
					"data" : "creDate"
				}, {
					"bVisible" : false,
					"aTargets" : [ 5 ],
					"title" : "创建人",
					"data" : "userId"
				}, {
					"bVisible" : true,
					"aTargets" : [ 7 ],
					"title" : "操作",
					"data" : "todo"
				}, {
					"bVisible" : true,
					"aTargets" : [ 6 ],
					"title" : "是否传过合同",
					"data" : "rid"
				},{
					"bVisible" : false,
					"aTargets" : [ 8 ],
					"title" : "是否上传作品",
					"data" : "rid"
				},{
					"bVisible" : false,
					"aTargets" : [ 9 ],
					"title" : "是否确定人员",
					"data" : "rid"
				}];
			} else if ("3" == type) {// 可报名的需求
				titles = [ {
					"bVisible" : false,
					"aTargets" : [ 0 ],
					"title" : "需求ID",
					"data" : "rid"
				}, {
					"bVisible" : true,
					"aTargets" : [ 1 ],
					"title" : "需求名称",
					"data" : "title"
				}, {
					"bVisible" : true,
					"aTargets" : [ 2 ],
					"title" : "需求价格",
					"data" : "price"
				}, {
					"bVisible" : false,
					"aTargets" : [ 3 ],
					"title" : "需求状态",
					"data" : "state"
				}, {
					"bVisible" : true,
					"aTargets" : [ 4 ],
					"title" : "需求创建时间",
					"data" : "creDate"
				}, {
					"bVisible" : false,
					"aTargets" : [ 5 ],
					"title" : "创建人",
					"data" : "userId"
				}, {
					"bVisible" : true,
					"aTargets" : [ 6 ],
					"title" : "操作",
					"data" : "todo"
				}, {
					"bVisible" : false,
					"aTargets" : [ 7 ],
					"title" : "是否传过合同",
					"data" : "rid"
				},{
					"bVisible" : false,
					"aTargets" : [ 8 ],
					"title" : "是否上传作品",
					"data" : "rid"
				},{
					"bVisible" : false,
					"aTargets" : [ 9 ],
					"title" : "是否确定人员",
					"data" : "rid"
				}];
			} else {// 默认显示为我发布的需求
				titles = [ {
					"bVisible" : false,
					"aTargets" : [ 0 ],
					"title" : "需求ID",
					"data" : "rid"
				}, {
					"bVisible" : false,
					"aTargets" : [ 1 ],
					"title" : "接收需求表ID",
					"data" : "aid"
				}, {
					"bVisible" : true,
					"aTargets" : [ 2 ],
					"title" : "需求名称",
					"data" : "title"
				}, {
					"bVisible" : true,
					"aTargets" : [ 3 ],
					"title" : "竞标者姓名",
					"data" : "realName"
				}, {
					"bVisible" : true,
					"aTargets" : [ 4 ],
					"title" : "竞标者电话",
					"data" : "phone"
				}, {
					"bVisible" : true,
					"aTargets" : [ 5 ],
					"title" : "竞标者报价",
					"data" : "offerPrice"
				}, {
					"bVisible" : true,
					"aTargets" : [ 6 ],
					"title" : "开发周期",
					"data" : "period"
				}, {
					"bVisible" : true,
					"aTargets" : [ 7 ],
					"title" : "竞标者承诺",
					"data" : "promise"
				},{
					"bVisible" : true,
					"aTargets" : [ 8 ],
					"title" : "操作",
					"data" : "todo"
				},{
					"bVisible" : false,
					"aTargets" : [ 7 ],
					"title" : "是否传过合同",
					"data" : "rid"
				},{
					"bVisible" : false,
					"aTargets" : [ 8 ],
					"title" : "是否上传作品",
					"data" : "rid"
				},{
					"bVisible" : false,
					"aTargets" : [ 9 ],
					"title" : "是否确定人员",
					"data" : "rid"
				}];
			}
			param.push(type);
			$(function() {
				if (oneCode == type) {
					$('#demand_type').text("我发布的需求");
				} else if (twoCode == type) {
					$('#demand_type').text("我参与竞标的需求");
				} else if (threeCode == type){
					$('#demand_type').text("可报名的需求列表");
					param.push(oneCode);
				}else{
					$('#demand_type').text("参与竞标的成员列表");
					param.push(rid);
					
				}				
				table = $('#demand_myPublish')
						.DataTable(
								{
									pageLength : 10,// 首次加载的数据条数
									"pagingType" : "full_numbers",
									scrollY : "200px",
									scrollCollapse : true,
									processing : true,// 载入数据的时候是否显示“载入中”
									ordering : false,// 排序操作在服务端进行，所以可以关了。
									searching : false,
									paging : true,
									"lengthMenu" : [ [ 10, 20, 30, -1 ],
											[ 10, 20, 30, "所有" ] ],
									"aoColumnDefs" : titles,
									ajax : {
										"Headers" : {
											"Accept" : "application/json",
											"Content-Type" : "application/json"
										},
										contentType : 'application/json',
										url : "data",
										type : "post",
										dataType : "json",
										dataSrc : "data",
										data : function(args) {
											$.extend(args, {
												"searchParam" : param
											});
											return JSON.stringify(args);
										}
									},
									serverSide : true,// 分页，取数据等等的都放到服务端去
									"createdRow" : function(row, data,dataIndex) {
										$.each($(row).find("td"),function(i, n) {											
															if (type == 1) {
																if("true" == flag){
																	$('#sign').text("恭喜你，发布成功！");
																}
																if (i == 2) {																	
																	if (data.state == oneCode) {
																		$(n).text("报名中");																				
																	} else if (data.state == twoCode) {
																		$(n).text("开发中");																		
																	} else if (data.state == threeCode) {
																		$(n).text("验收中");
																	} else {
																		$(n).text("已结项");
																	}
																}else if(i == 7){	
																	if(data.isSure == zero && data.state == oneCode){ //代表刚上传完需求，还没有人参与竞标
																		$(n).text('无');
																	}else if(data.isSure == oneCode && data.state == oneCode){//代表已经有人参与竞标，但还未确定人选
																		$(n).html('<input class="btn bt-sm btn-success radius" type="button" value="查看竞标者"  onclick="queryPersons('+data.rid+');" />');
																	}else if(data.isSure == twoCode && data.state == twoCode && data.isUploadPact == zero){//代表已经确定人选，但此人还未签订合同进行上传
																		$(n).text('无');
																	}else if(data.isSure == twoCode && data.state == twoCode && data.isUploadPact == oneCode && data.isUploadWorks == zero){//开发者已经上传合同，但未上传作品
																		$(n).html('<input class="btn bt-sm btn-success radius" type="button" value="查看签订合同" onclick="queryPact('+data.rid+');" />');
																	}else if(data.state == threeCode){
																		$(n).html('<input class="btn bt-sm btn-success radius" type="button" value="查看作品" onclick="queryWorks('+data.rid+');" /><input class="btn bt-sm btn-success radius" type="button" value="确认收货" onclick="sureWorks('+data.rid+');" />');
																	}else{
																		$(n).text("已结项");
																	}		
																}else if(i == 4){
																	if(data.isUploadPact == '1'){
																		$(n).text("已上传");
																	}else{
																		$(n).text("未上传");
																	}
																
																}else if(i == 5){
																	if(data.isUploadWorks == '1'){
																		$(n).text("已上传");
																	}else{
																		$(n).text("未上传");
																	}
																}else if(i == 6){
																	if(data.isSure == '2'){
																		$(n).text("人员已确定");
																	}else if(data.isSure == '1'){
																		$(n).text("已有人参与竞标");
																	}else{
																		$(n).text("还没有人参与竞标");
																	}
																}
															} else if (type == 2) {																
																if (i == 2) {
																	if (data.state == oneCode) {
																		$(n).text("报名中");
																		if("true" == flag){
																			$('#sign').text("恭喜你，报名成功！");
																		}
																	} else if (data.state == twoCode) {
																		$(n).text("开发中");
																	} else if (data.state == threeCode) {
																		$(n).text("验收中");
																	} else {
																		$(n).text("已结项");
																	}
																}else if(i == 5){
																	if(data.state == twoCode){	
																		if(data.isUploadPact == 1){
																			 $(n).html('<input data-toggle="modal"  data-target="#myModal"  class="btn bt-sm btn-success radius" type="button" value="上传作品" onclick="uploadWorks('+data.rid+',3'+')" />');
																		}else{
																			 $(n).html('<input data-toggle="modal"  data-target="#myModal"  class="btn bt-sm btn-success radius" type="button" value="上传合同附件" onclick="uploadPact('+data.rid+',2'+')" />');
																		}
																	}else{
																		$(n).text("无");
																	}																	
																}else if(i == 4){
																	if(data.isUploadPact == 1){
																		$(n).text("已上传");
																	}else{
																		$(n).text("未上传");
																	}
																	
																}																
															} else if (type == 3) {
																if (i == 3) {
																	$(n).html('<a href="#" onclick="baoming('+data.rid+',\''+data.title+'\');">报名</a>');
																}
															} else {
																if (i == 6) {
																	$(n).html('<a href="#" onclick="surePerson('+data.rid+',\''+data.aid+'\');">确定人员</a>');
																}
															}

														});

									},
									language : {
										"lengthMenu" : "_MENU_ 条记录每页",
										paginate : {// 分页的样式内容。
											previous : "上一页",
											next : "下一页",
											first : "第一页",
											last : "最后"
										},

										zeroRecords : "没有找到记录",// table
																// tbody内容为空时，tbody的内容。
										// 下面三者构成了总体的左下角的内容。
										info : "总共_PAGES_ 页，显示第_START_ 到第 _END_ ",// 左下角的信息显示，大写的词为关键字。
										infoEmpty : "0条记录",// 筛选为空时左下角的显示。
										infoFiltered : ""// 筛选之后的左下角筛选提示，
									}

								});
			});			
			
		});
//报名竞标需求
function baoming(rid,title) {	
	window.location.href="bm?rid="+rid+"&title="+title;
}
function queryPersons(rid){
	window.location.href="mid?rid="+rid;
}
//确定接包人
function surePerson(rid,aid){
	if(window.confirm('你确定要选择此人接此需求吗？')){
		window.location.href="mState?rid="+rid+"&state=2"+"&aid="+aid+"&isUploadPact=0&isUploadWorks=0&isSure=2";
        return true;
     }else{
        return false;
    }
}

//查看合同附件
function queryPact(rid){
	window.location.href = "download?type=2&rid="+rid;
}
//查看作品附件
function queryWorks(rid){
	window.location.href = "download?type=3&rid="+rid;
}
//确认作品
function sureWorks(rid){
	if(window.confirm('你是否认可合作方的作品？')){
		window.location.href="mState?rid="+rid+"&state=4"+"&isUploadPact=1&isUploadWorks=1&isSure=2";
        return true;
     }else{
        return false;
    }
}
//上传合同附件
function uploadPact(rid,fileType){
	$('#fid').val(rid);
	$('#filetype').val(fileType);
}
//上传作品
function uploadWorks(rid,fileType){		
	$('#fid').val(rid);
	$('#filetype').val(fileType);
}
