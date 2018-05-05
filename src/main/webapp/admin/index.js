//登录用户信息全局变量
var gId = 0;//id
var gUserName = "";//用户名
var SESSIONID = sessionStorage.sessionId;//sessionId

var DefaultNum = 10;// dataTable默认展示条数
// dataTable展示信息
var LengthMenu = "每页显示 _MENU_ 条记录";
var ZeroRecords = "没有符合条件的记录";
var InfoEmpty = "暂无数据";
var Processing = "<img src='./../img/loading.gif'/>加载中...";
var Infos = "当前第 _START_ 到 _END_ 条，共 _TOTAL_ 条";
var InfoFiltered = "(从 _MAX_ 条记录中过滤)";
var FirstPage = "首页";
var Previous = "前一页";
var NextPage = "后一页";
var LastPage = "尾页";
var SelectItems = "选中%d行";
var SelectOne = "选中1行"

// Ajax共用参数
var LOGINURL = "./login.html";

$(function() {
	$.ajaxSetup({
		complete : function(XMLHttpRequest, textStatus) {
			if (XMLHttpRequest.responseText == "sessionTimeOut") {
				window.location.replace(LOGINURL);
			}
		}
	});
	
	if (sessionStorage.userInfo == undefined)
		window.location.replace(LOGINURL);
	else {// 全局变量赋值
		userInfo = JSON.parse(sessionStorage.userInfo);
		"null" == userInfo.adminId ? gId = "" : gId = userInfo.adminId;
		"null" == userInfo.username ? gUserName = "" : gUserName = userInfo.username;
		SESSIONID = userInfo.userSessionId;
		$("#showName").html(" " + gUserName + " ");
	}
	$.getMenuInfo();
	$.loadURL("area.html", "首页");
});
//获取菜单
$.getMenuInfo = function() {
	var menu;
	menu = '<div class="sidebar-nav navbar-collapse" id="sidebar"><ul class="nav" id="side-menu"><li><a href="#1" onclick="$.loadURL(\'./area.html\',\'首页\')" data-toggle="collapse"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 首页</a><ul id="1" class="nav nav-second-level collapse secondmenu" style="height: 0px;"></ul></li><li><a href="#2" onclick="$.loadURL(\'./member/index.html\',\'会员管理\')" data-toggle="collapse"><span class="glyphicon glyphicon-cutlery" aria-hidden="true"></span> 会员管理</a><ul id="2" class="nav nav-second-level collapse secondmenu" style="height: 0px;"></ul></li><li><a href="#3" onclick="$.loadURL(\'./pay/index.html\',\'充值记录\')" data-toggle="collapse"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 充值记录</a><ul id="3" class="nav nav-second-level collapse secondmenu" style="height: 0px;"></ul></li><li><a href="#4" onclick="$.loadURL(\'./shenhe/index.html\',\'审核\')" data-toggle="collapse"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span> 审核</a><ul id="4" class="nav nav-second-level collapse secondmenu" style="height: 0px;"></ul></li></ul></div>';
	$("#sidebar").html(menu);
}

// 调整footer位置
$.changeDivHeight = function() {
	setTimeout(function() {
		$.adjustHeight();
	}, 200);
};
$.adjustHeight = function() {
	$("#footer").css("position", "absolute");
	var areaHeight = $("#htContain").height();//网页htContain正文全文高度
	var windowHeight = $(window).height();//可视窗口高度，不包括浏览器顶部工具栏
	if (windowHeight > areaHeight + 50) {
		$("#footer").css("top", windowHeight - 45);
	} else
		$("#footer").css("top", areaHeight + 100);
};

// 设置dataTable默认展示条数
$.setDefaultNum = function() {
	var windowHeight = $(window).height();
	var headerHeight = $("#headerArea").height() + $("#menuTitleDiv").height();
	var footerHieght = $("#footer").height();
	var midHeight = windowHeight - headerHeight - footerHieght;
	defaultNum = parseInt(midHeight / 40) - 2;
};

// 退出
$.logoutCheck = function() {
	swal({
		  title: "确定退出吗？",
		  type: "warning",
		  showCancelButton: true,
		  cancelButtonText: "取消",
		  confirmButtonClass: "btn-danger",
		  confirmButtonText: "确定",
		  closeOnConfirm: false
		},
		function(){
			$.logoutNow();
		});
};
// 用户注销
$.logoutNow = function() {
	sessionStorage.removeItem("userInfo");
	window.location.replace(LOGINURL);
};

// 点击菜单加载页面
$.loadURL = function(url, navigation) {
	$('#area').load(url);
	$("#menuTitle").html(navigation);
	$("#menuTitleDiv").show();
	$("#responsive").show();
	$.changeDivHeight();
};

// 自定义信息提示框
// content:内容
// alertType: 1绿色(成功) 2蓝色(信息) 3黄色(警告) 4红色(失败)
$.alert = function(content, alertType) {
	if (alertType == 1) {
		swal(content, "", "success");
	} else if (alertType == 2) {
		swal(content, "", "info");
	} else if (alertType == 3) {
		swal(content, "", "warning");
	} else {
		swal(content, "", "error");
	}
};

//时间戳转换时间
function timetrans(time){
    var date = new Date(time);//如果date为13位不需要乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
    var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    var s = (date.getSeconds() <10 ? '0' + date.getSeconds() : date.getSeconds());
    return Y+M+D+h+m+s;
}