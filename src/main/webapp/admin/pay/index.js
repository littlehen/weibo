var dataTD;
var rowNum = 1;
var type = 0;
$(document).ready(function(){
    dataTD=$("#mainDataTable").DataTable({
        ajax : {
            url : SERVERURL + "wb_pay/get",
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
            width: "30%",
        },{
            data : "time",
            width: "20%",
        },{
            data : "type",
            width: "20%",
            render : function(data, type, row, meta) {
            	if(1 == row.type)
            		return "vip会员";
            	else
                	return "积分";
            }
        },{
            data : "money",
            width: "20%",
        } ],
        dom : "<'row'<'col-md-3'B>>t<'row'<'col-md-3'l><'col-md-3'><'#mainToolbar.col-md-6'>r>t<'row'<'col-md-3'i><'col-md-9'p>>",
        initComplete: function () {
            // 更改工具栏按钮的样式
            $("#mainToolbar").empty();
            var strToolBar = "<span id='textContent'>充值类型：</span><select id='selectWay' class='form-control'><option value='0'>全部</option><option value='1'>vip会员</option><option value='2'>积分</option></select>" +
            	" <input type='text'class='form-control' style='width: 250px' name='searchText' placeholder='微信昵称' value=''> <button class='btn btn-default btn-sm' onclick='$(this).searchDT()'><span class='glyphicon glyphicon-search' aria-hidden='true'></span> 搜索</button></div>";
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