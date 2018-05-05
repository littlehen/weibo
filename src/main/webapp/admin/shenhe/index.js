var dataTD;
var rowNum = 1;
$(document).ready(function(){
    dataTD=$("#mainDataTable").DataTable({
        ajax : {
            url : SERVERURL + "wb_shenhe/get",
            type : "POST",
            data :function(s){
                s.search = $('#mainDataTable').DataTable().search(this.value);
                s.sessionId = SESSIONID;
    			s.userDevice = 'web';
            }
        },
        columns: [{
            data : "userId",
            render : function(data, type, row, meta) {
                var idname = "checkbox" + (parseInt(meta.row) + 1);
                return "<input type='checkbox' value='" + data + "' id='" + idname + "'>";
            }
        },{
            data : "userId",
            width: "3%",
        },{
            data : "cname",
            width: "14%",
        },{
            data : "userId",
            width: "20%",
            render : function(data, type, row, meta) {
            	if(0 == row.functionsIsFinish)
            		return "<button class='btn btn-default btn-xs' onclick='$.shenhegongnengModal(" + row.userId + ")'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>审核</button>"
            	else
            		return '';
            }
        },{
            data : "userId",
            width: "20%",
            render : function(data, type, row, meta) {
            	if(0 == row.weiboIsFinish)
            		return "<button class='btn btn-default btn-xs' onclick='$.shenheWeiboModal(" + row.userId + ")'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>审核</button>"
            	else
            		return '';
            }
        },{
            data : "userId",
            width: "20%",
            render : function(data, type, row, meta) {
            	if(0 == row.contentIsFinish)
            		return "<button class='btn btn-default btn-xs' onclick='$.shenhePinglunModal(" + row.userId + ")'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>审核</button>"
            	else
                	return '';
            }
        },{
            data : "userId",
            width: "20%",
            render : function(data, type, row, meta) {
            	if(0 == row.zanIsFinish)
            		return "<button class='btn btn-default btn-xs' onclick='$.shenheZanModal(" + row.userId + ")'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>审核</button>"
            	else
                	return '';
            }
        } ],
        dom : "<'row'<'col-md-3'B>>t<'row'<'col-md-3'l><'col-md-3'><'#mainToolbar.col-md-6'>r>t<'row'<'col-md-3'i><'col-md-9'p>>",
        initComplete: function () {
            // 更改工具栏按钮的样式
            $("#mainToolbar").empty();
            var strToolBar = "<input type='text'class='form-control' style='width: 250px' name='searchText' placeholder='微信昵称' value=''> <button class='btn btn-default btn-sm' onclick='$(this).searchDT()'><span class='glyphicon glyphicon-search' aria-hidden='true'></span> 搜索</button></div>";
            $("#mainToolbar").append(strToolBar);
        },
        buttons :[{
            text : "<span class='glyphicon glyphicon-refresh' aria-hidden='true'></span> 刷新",
            className : 'btn-refresh',
            action : function(e, dt, node, config) {
                dt.ajax.reload();
                $("#headCheckbox").attr("checked", false);
            }
        } ],
        processing : true,//是否显示加载中提示
        serverSide : true,//是否从服务器获取数据
        ordering : false,
        autoFill : true,
        displayLength : DefaultNum,//默认每页显示的页数
        lengthMenu : [ [ 1, 5, 15, 20, 50, 100, 150, -1 ], [ 1, 5, 15, 20, 50, 100, 150, "All" ] ],
        language : {
            lengthMenu : LengthMenu,
            zeroRecords : ZeroRecords,
            infoEmpty : InfoEmpty,
            processing : Processing,
            info : Infos,
            infoFiltered : InfoFiltered,
            paginate : {
                first : FirstPage,
                previous : Previous,
                next : NextPage,
                last : LastPage
            },
            buttons: {
                selectItem : SelectItems
            },
            select:{
                rows:{
                    _ : SelectItems,
                    1 : SelectOne
                }
            }
        },
        drawCallback : function() {//每次表格调用完成时调用
            rowNum = 1;
            $('[data-toggle="popover"]').popover({
                trigger: 'hover ',
            });
        },
        rowCallback : function(row, data, displayIndex) {
            $(row).addClass('domrow');
            $('td:eq(1)', row).html($("#mainDataTable").dataTable().fnSettings()._iDisplayStart + rowNum++);
            return row;
        }
    });
});


$("#headCheckbox").change(function() {
    $("input[id^='checkbox']").prop("checked", $("#headCheckbox").is(':checked'));
});

$.fn.searchDT = function () {
    var searchContext = $("input[name='searchText']").val();
    dataTD.search(searchContext).draw();
};

$.showModal = function(name,text) {
    $("#" + name + "ModalLabel").text(text);
    $("#" + name + "Modal").modal({
        backdrop : 'static',
        keyboard : false,
        show : true
    });
};

//模态框关闭
$.closeModal = function (name) {
    $("#" + name + "Modal").modal('hide');
    dataTD.ajax.reload(null, false);
};




var dataTDpl;
var rowNumpl = 1;
$.shenhegongnengModal=function(data){
	$.showModal("shenhegongneng", "审核功能设置");
	
	$.ajax({
        url : SERVERURL + "wb_shenhe/getwbmain",
        type : "POST",
        data : {
        	userId : data,
        	sessionId : SESSIONID,
			userDevice : 'web'
        },
        dataType : 'json',
        success : function(msg) {
            if (msg != null && typeof (msg) != "undefined") {
                if (msg.isSuccess == true) {
                	var data = msg.data;
                	$("#mainzhanghaogn").empty().html(data.username);
                	$("#mainmimagn").empty().html(data.password);
                	
                } else {
                	$.alert('系统错误！', 4);
                }
            } else {
                $.alert('系统错误！', 4);
            }
        },
        error : function(msg) {
            $.alert("系统错误！", 4);
        }
    });
	
	
	if (dataTDpl != null)
		dataTDpl.destroy();
	dataTDpl=$("#mainDataTablegn").DataTable({
        ajax : {
            url : SERVERURL + "wb_shenhe/getgn",
            type : "POST",
            data :function(s){
            	s.search = $('#mainDataTablegn').DataTable().search(this.value),
            	s.userId = data,
                s.sessionId = SESSIONID;
    			s.userDevice = 'web';
            }
        },
        columns: [{
            data : "fid",
            width: "5%",
        },{
            data : "plZhushou",
            width: "10%",
            render : function(data, type, row, meta) {
            	if(data == 1)
            		return '开';
            	else
            		return '关';
            }
        },{
            data : "bcfPl",
            width: "10%",
            render : function(data, type, row, meta) {
            	if(data == 1)
            		return '开';
            	else
            		return '关';
            }
        },{
            data : "yp",
            width: "10%",
        },{
            data : "jx",
            width: "10%",
        },{
            data : "hd",
            width: "10%",
        },{
            data : "sy",
            width: "10%",
        },{
            data : "yz",
            width: "25%",
        },{
            data : "fid",
            width: "10%",
            render : function(data, type, row, meta) {
            	return "<button class='btn btn-default btn-xs' onclick='$.shenhegnModalYN(" + data + ",1)'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>通过</button>"
            	+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button class='btn btn-default btn-xs' onclick='$.shenhegnModalYN(" + data + ",2)'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>驳回</button>"
            }
        } ],
        dom : "<'row'<'col-md-3'B>>t<'row'<'col-md-3'l><'col-md-3'><'#mainToolbar.col-md-6'>r>t<'row'<'col-md-3'i><'col-md-9'p>>",
        initComplete: function () {
            // 更改工具栏按钮的样式
            $("#mainToolbar").empty();
            var strToolBar = "";
            $("#mainToolbar").append(strToolBar);
        },
        buttons :[{
            text : "<span class='glyphicon glyphicon-refresh' aria-hidden='true'></span> 刷新",
            className : 'btn-refresh',
            action : function(e, dt, node, config) {
                dt.ajax.reload();
            }
        } ],
        processing : true,//是否显示加载中提示
        serverSide : true,//是否从服务器获取数据
        ordering : false,
        autoFill : true,
        displayLength : DefaultNum,//默认每页显示的页数
        lengthMenu : [ [ 1, 5, 15, 20, 50, 100, 150, -1 ], [ 1, 5, 15, 20, 50, 100, 150, "All" ] ],
        language : {
            lengthMenu : LengthMenu,
            zeroRecords : ZeroRecords,
            infoEmpty : InfoEmpty,
            processing : Processing,
            info : Infos,
            infoFiltered : InfoFiltered,
            paginate : {
                first : FirstPage,
                previous : Previous,
                next : NextPage,
                last : LastPage
            },
            buttons: {
                selectItem : SelectItems
            },
            select:{
                rows:{
                    _ : SelectItems,
                    1 : SelectOne
                }
            }
        },
        drawCallback : function() {//每次表格调用完成时调用
            rowNumpl = 1;
            $('[data-toggle="popover"]').popover({
                trigger: 'hover ',
            });
        }
    });
}

$.shenhegnModalYN = function (fid, status) {
	var ttt;
	if(status == 1)
		ttt = "通过";
	else if(status == 2)
		ttt = "驳回";
	else;
    swal({
            title:  '确定' + ttt + '吗?',
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "取消",
            confirmButtonClass: "btn-danger",
            confirmButtonText: "确定",
            closeOnConfirm: false
        },
        function(){
            $.shenhegnModalYNGo(fid, status);
        });
}
$.shenhegnModalYNGo=function(fid, status){
    $.ajax({
        url : SERVERURL + "wb_shenhe/getgnShenhe",
        type : "POST",
        data : {
        	id : fid,
        	status : status,
        	sessionId : SESSIONID,
			userDevice : 'web'
		},
        dataType : 'json',
        success : function(msg) {
            if (msg != null && typeof (msg) != "undefined") {
                if (msg.isSuccess == true) {
                    $.alert("成功！", 1);
                    dataTDpl.ajax.reload(null, false);
                } else {
                    $.alert("失败！", 4);
                }
            } else {
                $.alert('系统错误！', 4);
            }
        },
        error : function(msg) {
            $.alert("系统错误！", 4);
        }
    });
}





var dataTDwb;
var rowNumwb = 1;
$.shenheWeiboModal=function(data){
	$.showModal("shenheWeibo", "审核微博");
	
	$.ajax({
        url : SERVERURL + "wb_shenhe/getwbmain",
        type : "POST",
        data : {
        	userId : data,
        	sessionId : SESSIONID,
			userDevice : 'web'
        },
        dataType : 'json',
        success : function(msg) {
            if (msg != null && typeof (msg) != "undefined") {
                if (msg.isSuccess == true) {
                	var data = msg.data;
                	$("#mainzhanghaowb").empty().html(data.username);
                	$("#mainmimawb").empty().html(data.password);
                	
                } else {
                	$.alert('系统错误！', 4);
                }
            } else {
                $.alert('系统错误！', 4);
            }
        },
        error : function(msg) {
            $.alert("系统错误！", 4);
        }
    });
	
	
	if (dataTDwb != null)
		dataTDwb.destroy();
	dataTDwb=$("#mainDataTablewb").DataTable({
        ajax : {
            url : SERVERURL + "wb_shenhe/getwb",
            type : "POST",
            data :function(s){
            	s.search = $('#mainDataTablewb').DataTable().search(this.value),
            	s.userId = data,
                s.sessionId = SESSIONID;
    			s.userDevice = 'web';
            }
        },
        columns: [{
            data : "weiboId",
            width: "10%",
        },{
            data : "isMain",
            width: "10%",
            render : function(data, type, row, meta) {
            	if(data == 1)
            		return '主号';
            	else
            		return '辅号';
            }
        },{
            data : "username",
            width: "25%",
        },{
            data : "password",
            width: "25%",
        },{
            data : "weiboId",
            width: "30%",
            render : function(data, type, row, meta) {
            	return "<button class='btn btn-default btn-xs' onclick='$.shenheweiboModalYN(" + data + ",1)'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>通过</button>"
            	+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button class='btn btn-default btn-xs' onclick='$.shenheweiboModalYN(" + data + ",2)'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>驳回</button>"
            }
        } ],
        dom : "<'row'<'col-md-3'B>>t<'row'<'col-md-3'l><'col-md-3'><'#mainToolbar.col-md-6'>r>t<'row'<'col-md-3'i><'col-md-9'p>>",
        initComplete: function () {
            // 更改工具栏按钮的样式
            $("#mainToolbar").empty();
            var strToolBar = "";
            $("#mainToolbar").append(strToolBar);
        },
        buttons :[{
            text : "<span class='glyphicon glyphicon-refresh' aria-hidden='true'></span> 刷新",
            className : 'btn-refresh',
            action : function(e, dt, node, config) {
                dt.ajax.reload();
            }
        } ],
        processing : true,//是否显示加载中提示
        serverSide : true,//是否从服务器获取数据
        ordering : false,
        autoFill : true,
        displayLength : DefaultNum,//默认每页显示的页数
        lengthMenu : [ [ 1, 5, 15, 20, 50, 100, 150, -1 ], [ 1, 5, 15, 20, 50, 100, 150, "All" ] ],
        language : {
            lengthMenu : LengthMenu,
            zeroRecords : ZeroRecords,
            infoEmpty : InfoEmpty,
            processing : Processing,
            info : Infos,
            infoFiltered : InfoFiltered,
            paginate : {
                first : FirstPage,
                previous : Previous,
                next : NextPage,
                last : LastPage
            },
            buttons: {
                selectItem : SelectItems
            },
            select:{
                rows:{
                    _ : SelectItems,
                    1 : SelectOne
                }
            }
        },
        drawCallback : function() {//每次表格调用完成时调用
            rowNumwb = 1;
            $('[data-toggle="popover"]').popover({
                trigger: 'hover ',
            });
        }
    });
}

$.shenheweiboModalYN = function (weiboId, status) {
	var ttt;
	if(status == 1)
		ttt = "通过";
	else if(status == 2)
		ttt = "驳回";
	else;
    swal({
            title:  '确定' + ttt + '吗?',
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "取消",
            confirmButtonClass: "btn-danger",
            confirmButtonText: "确定",
            closeOnConfirm: false
        },
        function(){
            $.shenheweiboModalYNGo(weiboId, status);
        });
}
$.shenheweiboModalYNGo=function(weiboId, status){
    $.ajax({
        url : SERVERURL + "wb_shenhe/getwbShenhe",
        type : "POST",
        data : {
        	id : weiboId,
        	status : status,
        	sessionId : SESSIONID,
			userDevice : 'web'
		},
        dataType : 'json',
        success : function(msg) {
            if (msg != null && typeof (msg) != "undefined") {
                if (msg.isSuccess == true) {
                    $.alert("成功！", 1);
                    dataTDwb.ajax.reload(null, false);
                } else {
                    $.alert("失败！", 4);
                }
            } else {
                $.alert('系统错误！', 4);
            }
        },
        error : function(msg) {
            $.alert("系统错误！", 4);
        }
    });
}





var dataTDz;
var rowNumz = 1;
$.shenheZanModal=function(data){
	$.showModal("shenheZan", "审核赞");
	
	$.ajax({
        url : SERVERURL + "wb_shenhe/getwbmain",
        type : "POST",
        data : {
        	userId : data,
        	sessionId : SESSIONID,
			userDevice : 'web'
        },
        dataType : 'json',
        success : function(msg) {
            if (msg != null && typeof (msg) != "undefined") {
                if (msg.isSuccess == true) {
                	var data = msg.data;
                	$("#mainzhanghaoz").empty().html(data.username);
                	$("#mainmimaz").empty().html(data.password);
                	
                } else {
                	$.alert('系统错误！', 4);
                }
            } else {
                $.alert('系统错误！', 4);
            }
        },
        error : function(msg) {
            $.alert("系统错误！", 4);
        }
    });
	
	
	if (dataTDz != null)
		dataTDz.destroy();
	dataTDz=$("#mainDataTablez").DataTable({
        ajax : {
            url : SERVERURL + "wb_shenhe/getz",
            type : "POST",
            data :function(s){
            	s.search = $('#mainDataTablez').DataTable().search(this.value),
            	s.userId = data,
                s.sessionId = SESSIONID;
    			s.userDevice = 'web';
            }
        },
        columns: [{
            data : "contentKeyId",
            width: "10%",
        },{
            data : "keyword",
            width: "35%",
        },{
            data : "zanNumber",
            width: "25%",
        },{
            data : "contentKeyId",
            width: "30%",
            render : function(data, type, row, meta) {
            	return "<button class='btn btn-default btn-xs' onclick='$.shenhezanModalYN(" + data + ",1)'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>通过</button>"
            	+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button class='btn btn-default btn-xs' onclick='$.shenhezanModalYN(" + data + ",2)'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>驳回</button>"
            }
        } ],
        dom : "<'row'<'col-md-3'B>>t<'row'<'col-md-3'l><'col-md-3'><'#mainToolbar.col-md-6'>r>t<'row'<'col-md-3'i><'col-md-9'p>>",
        initComplete: function () {
            // 更改工具栏按钮的样式
            $("#mainToolbar").empty();
            var strToolBar = "";
            $("#mainToolbar").append(strToolBar);
        },
        buttons :[{
            text : "<span class='glyphicon glyphicon-refresh' aria-hidden='true'></span> 刷新",
            className : 'btn-refresh',
            action : function(e, dt, node, config) {
                dt.ajax.reload();
            }
        } ],
        processing : true,//是否显示加载中提示
        serverSide : true,//是否从服务器获取数据
        ordering : false,
        autoFill : true,
        displayLength : DefaultNum,//默认每页显示的页数
        lengthMenu : [ [ 1, 5, 15, 20, 50, 100, 150, -1 ], [ 1, 5, 15, 20, 50, 100, 150, "All" ] ],
        language : {
            lengthMenu : LengthMenu,
            zeroRecords : ZeroRecords,
            infoEmpty : InfoEmpty,
            processing : Processing,
            info : Infos,
            infoFiltered : InfoFiltered,
            paginate : {
                first : FirstPage,
                previous : Previous,
                next : NextPage,
                last : LastPage
            },
            buttons: {
                selectItem : SelectItems
            },
            select:{
                rows:{
                    _ : SelectItems,
                    1 : SelectOne
                }
            }
        },
        drawCallback : function() {//每次表格调用完成时调用
            rowNumz = 1;
            $('[data-toggle="popover"]').popover({
                trigger: 'hover ',
            });
        }
    });
}

$.shenhezanModalYN = function (contentKeyId, status) {
	var ttt;
	if(status == 1)
		ttt = "通过";
	else if(status == 2)
		ttt = "驳回";
	else;
    swal({
            title:  '确定' + ttt + '吗?',
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "取消",
            confirmButtonClass: "btn-danger",
            confirmButtonText: "确定",
            closeOnConfirm: false
        },
        function(){
            $.shenhezanModalYNGo(contentKeyId, status);
        });
}
$.shenhezanModalYNGo=function(contentKeyId, status){
    $.ajax({
        url : SERVERURL + "wb_shenhe/getzShenhe",
        type : "POST",
        data : {
        	id : contentKeyId,
        	status : status,
        	sessionId : SESSIONID,
			userDevice : 'web'
		},
        dataType : 'json',
        success : function(msg) {
            if (msg != null && typeof (msg) != "undefined") {
                if (msg.isSuccess == true) {
                    $.alert("成功！", 1);
                    dataTDz.ajax.reload(null, false);
                } else {
                    $.alert("失败！", 4);
                }
            } else {
                $.alert('系统错误！', 4);
            }
        },
        error : function(msg) {
            $.alert("系统错误！", 4);
        }
    });
}




var dataTDpl;
var rowNumpl = 1;
$.shenhePinglunModal=function(data){
	$.showModal("shenhePinglun", "审核评论");
	
	$.ajax({
        url : SERVERURL + "wb_shenhe/getwbmain",
        type : "POST",
        data : {
        	userId : data,
        	sessionId : SESSIONID,
			userDevice : 'web'
        },
        dataType : 'json',
        success : function(msg) {
            if (msg != null && typeof (msg) != "undefined") {
                if (msg.isSuccess == true) {
                	var data = msg.data;
                	$("#mainzhanghaopl").empty().html(data.username);
                	$("#mainmimapl").empty().html(data.password);
                	
                } else {
                	$.alert('系统错误！', 4);
                }
            } else {
                $.alert('系统错误！', 4);
            }
        },
        error : function(msg) {
            $.alert("系统错误！", 4);
        }
    });
	
	
	if (dataTDpl != null)
		dataTDpl.destroy();
	dataTDpl=$("#mainDataTablepl").DataTable({
        ajax : {
            url : SERVERURL + "wb_shenhe/getpl",
            type : "POST",
            data :function(s){
            	s.search = $('#mainDataTablepl').DataTable().search(this.value),
            	s.userId = data,
                s.sessionId = SESSIONID;
    			s.userDevice = 'web';
            }
        },
        columns: [{
            data : "contentKeyId",
            width: "5%",
        },{
            data : "keyword",
            width: "15%",
        },{
            data : "content",
            width: "25%",
            render : function(data, type, row, meta) {
            	var shus=new Array();
            	shus = data;
            	var ddd=shus[0];
            	for(var i=1; i<shus.length; i++)
            	{
            		ddd=ddd+"★"+shus[i];
            	}
            	return row.keyword+"☆"+ddd;
            }
        },{
            data : "contentFuSwitch",
            width: "10%",
            render : function(data, type, row, meta) {
            	if(data == 1)
            		return '开';
            	else
            		return '关';
            }
        },{
            data : "contentFu",
            width: "25%",
            render : function(data, type, row, meta) {
            	var shus=new Array();
            	shus = data;
            	var ddd=shus[0];
            	for(var i=1; i<shus.length; i++)
            	{
            		ddd=ddd+"★"+shus[i];
            	}
            	return ddd;
            }
        },{
            data : "contentKeyId",
            width: "20%",
            render : function(data, type, row, meta) {
            	return "<button class='btn btn-default btn-xs' onclick='$.shenheplModalYN(" + data + ",1)'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>通过</button>"
            	+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button class='btn btn-default btn-xs' onclick='$.shenheplModalYN(" + data + ",2)'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>驳回</button>"
            }
        } ],
        dom : "<'row'<'col-md-3'B>>t<'row'<'col-md-3'l><'col-md-3'><'#mainToolbar.col-md-6'>r>t<'row'<'col-md-3'i><'col-md-9'p>>",
        initComplete: function () {
            // 更改工具栏按钮的样式
            $("#mainToolbar").empty();
            var strToolBar = "";
            $("#mainToolbar").append(strToolBar);
        },
        buttons :[{
            text : "<span class='glyphicon glyphicon-refresh' aria-hidden='true'></span> 刷新",
            className : 'btn-refresh',
            action : function(e, dt, node, config) {
                dt.ajax.reload();
            }
        } ],
        processing : true,//是否显示加载中提示
        serverSide : true,//是否从服务器获取数据
        ordering : false,
        autoFill : true,
        displayLength : DefaultNum,//默认每页显示的页数
        lengthMenu : [ [ 1, 5, 15, 20, 50, 100, 150, -1 ], [ 1, 5, 15, 20, 50, 100, 150, "All" ] ],
        language : {
            lengthMenu : LengthMenu,
            zeroRecords : ZeroRecords,
            infoEmpty : InfoEmpty,
            processing : Processing,
            info : Infos,
            infoFiltered : InfoFiltered,
            paginate : {
                first : FirstPage,
                previous : Previous,
                next : NextPage,
                last : LastPage
            },
            buttons: {
                selectItem : SelectItems
            },
            select:{
                rows:{
                    _ : SelectItems,
                    1 : SelectOne
                }
            }
        },
        drawCallback : function() {//每次表格调用完成时调用
            rowNumpl = 1;
            $('[data-toggle="popover"]').popover({
                trigger: 'hover ',
            });
        }
    });
}

$.shenheplModalYN = function (contentKeyId, status) {
	var ttt;
	if(status == 1)
		ttt = "通过";
	else if(status == 2)
		ttt = "驳回";
	else;
    swal({
            title:  '确定' + ttt + '吗?',
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "取消",
            confirmButtonClass: "btn-danger",
            confirmButtonText: "确定",
            closeOnConfirm: false
        },
        function(){
            $.shenheplModalYNGo(contentKeyId, status);
        });
}
$.shenheplModalYNGo=function(contentKeyId, status){
    $.ajax({
        url : SERVERURL + "wb_shenhe/getplShenhe",
        type : "POST",
        data : {
        	id : contentKeyId,
        	status : status,
        	sessionId : SESSIONID,
			userDevice : 'web'
		},
        dataType : 'json',
        success : function(msg) {
            if (msg != null && typeof (msg) != "undefined") {
                if (msg.isSuccess == true) {
                    $.alert("成功！", 1);
                    dataTDpl.ajax.reload(null, false);
                } else {
                    $.alert("失败！", 4);
                }
            } else {
                $.alert('系统错误！', 4);
            }
        },
        error : function(msg) {
            $.alert("系统错误！", 4);
        }
    });
}