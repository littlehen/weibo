var dataTD;
var rowNum = 1;
var type = 0;
$(document).ready(function(){
    dataTD=$("#mainDataTable").DataTable({
        ajax : {
            url : SERVERURL + "wb_user/get",
            type : "POST",
            data :function(s){
                s.search = $('#mainDataTable').DataTable().search(this.value);
                s.type = type;
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
            width: "5%",
        },{
            data : "cname",
            width: "20%",
        },{
            data : "cmoney",
            width: "20%",
        },{
            data : "member_endtime",
            width: "20%",
            render : function(data, type, row, meta) {
                return timetrans(data);
            }
        },{
            data : "userId",
            width: "30%",
            render : function(data, type, row, meta) {
            	return "<button class='btn btn-default btn-xs' onclick='$.editJifenModal(" + JSON.stringify(row) + ")'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>修改积分</button>"
                +"<button class='btn btn-default btn-xs' onclick='$.editHuiyuanModal(" + JSON.stringify(row) + ")'><span class='glyphicon glyphicon-list-alt' aria-hidden='true'></span>修改会员到期时间</button>"
            }
        } ],
        dom : "<'row'<'col-md-3'B>>t<'row'<'col-md-3'l><'col-md-3'><'#mainToolbar.col-md-6'>r>t<'row'<'col-md-3'i><'col-md-9'p>>",
        initComplete: function () {
            // 更改工具栏按钮的样式
            $("#mainToolbar").empty();
            var strToolBar = "<span id='textContent'>查询方式：</span><select id='selectWay' class='form-control'><option value='0'>全部</option><option value='1'>会员</option><option value='2'>非会员</option></select>" +
            	"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type='text'class='form-control' style='width: 250px' name='searchText' placeholder='微信昵称' value=''> <button class='btn btn-default btn-sm' onclick='$(this).searchDT()'><span class='glyphicon glyphicon-search' aria-hidden='true'></span> 搜索</button></div>";
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
	type=$("#selectWay").val();
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
};

$.editJifenModal=function(data){
	$.showModal("editJifen", "修改积分");
	$("#jifen").empty().val(data.cmoney);
	$("#userId").empty().val(data.userId);
	$("#openid").empty().val(data.openid);
}

$.editHuiyuanModal=function(data){
	$.showModal("editHuiyuan", "修改会员时间");
	$("#riqi").empty().datetimepicker("setValue",data.member_endtime);
	$("#userId1").empty().val(data.userId);
	$("#openid1").empty().val(data.openid);
}

$(function(){
	$('#editJifen').on('click',function(){
		$.ajax({
	        url : SERVERURL + "wb_user/editJifen",
	        type : "POST",
	        data : {
	        	userId : $('#userId').val(),
	        	openid : $('#openid').val(),
	        	jifen : $('#jifen').val(),
	        	sessionId : SESSIONID,
				userDevice : 'web'
	        },
	        dataType : 'json',
	        success : function(msg) {
	            if (msg != null && typeof (msg) != "undefined") {
	                if (msg.isSuccess == true) {
	                    $.alert("修改成功！", 1);
	                    dataTD.ajax.reload();
	                    $.closeModal('editJifen');
	                } else {
	                    $.alert("修改失败！", 4);
	                }
	            } else {
	                $.alert('系统错误！', 4);
	            }
	        },
	        error : function(msg) {
	            $.alert("系统错误！", 4);
	        }
	    });
	})
	
	$('#editHuiyuan').on('click',function(){
	    $.ajax({
	        url : SERVERURL + "wb_user/editHuiyuan",
	        type : "POST",
	        data : {
	        	userId : $('#userId1').val(),
	        	openid : $('#openid1').val(),
	        	riqi : $('#riqi').val(),
	        	sessionId : SESSIONID,
				userDevice : 'web'
	        },
	        dataType : 'json',
	        success : function(msg) {
	            if (msg != null && typeof (msg) != "undefined") {
	                if (msg.isSuccess == true) {
	                    $.alert("修改成功！", 1);
	                    dataTD.ajax.reload();
	                    $.closeModal('editHuiyuan');
	                } else {
	                    $.alert("修改失败！", 4);
	                }
	            } else {
	                $.alert('系统错误！', 4);
	            }
	        },
	        error : function(msg) {
	            $.alert("系统错误！", 4);
	        }
	    });
	})
})