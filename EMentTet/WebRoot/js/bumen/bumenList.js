layui.extend({
	dtree: '{/}layui-v2.5.5/lay/layui_ext/dtree/dtree' 
}).use(['form','layer','laydate','table','laytpl',],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    

    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#demmmm',
        url : '/EMentTet/BumenServletZXD?action=BumenAll',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: 'id',  align:'center'},
            {field: 'meng_name', title: '部门名称',  align:'center'},
            {field: 'renshu_id', title: '部门人数', minWidth:100, align:"center"},
            {field: 'userId', title: '用户id', minWidth:100, align:"center"},
            
        ]]
   /* done : function(res, curr, count) {
		merge(res);
	}*/
    });
    
	/*function merge(res) {
		var data = res.data;
		var mergeIndex = 0; //定位需要添加合并属性的行数
		var mark = 1; //这里涉及到简单的运算，mark是计算每次需要合并的格子数
		var columsName = [ 'id', 'lode_id' ]; //需要合并的列名称s
		var columsIndex = [ 1, 2 ]; //需要合并的列索引值

		for (var k = 0; k < columsName.length; k++) { //这里循环所有要合并的列
			var trArr = $(".layui-table-body>.layui-table").find("tr"); //所有行
			for (var i = 1; i < res.data.length; i++) { //这里循环表格当前的数据
				var tdCurArr = trArr.eq(i).find("td").eq(columsIndex[k]); //获取当前行的当前列
				var tdPreArr = trArr.eq(mergeIndex).find("td").eq(columsIndex[k]); //获取相同列的第一列

				if (data[i][columsName[k]] === data[i - 1][columsName[k]]) { //后一行的值与前一行的值做比较，相同就需要合并
					mark += 1;
					tdPreArr.each(function() { //相同列的第一列增加rowspan属性
						$(this).attr("rowspan", mark);
					});
					tdCurArr.each(function() { //当前行隐藏
						$(this).css("display", "none");
					});
				} else {
					mergeIndex = i;
					mark = 1; //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
				}
			}
			mergeIndex = 0;
			mark = 1;
		}*/
	/*}*/
 
    
     //工具栏事件
	  table.on('toolbar(demmmm)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var userid = '';
	    for(i=0;i<data.length;i++){
	    	userid = data[i].id;
	    }
	    
	    switch(obj.event){
	      case 'fenFunc':	//分配权限
				if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					hairMenu(userid);
				}
	      break;
	      case 'addFunc'://新增部门
	  		     
		    	  layer.open({
		        		title : "添加部门",
		        		type : 2,
		        		content : "/EMentTet/jsp/bumen/userAdd.jsp",
		        		area:['800px','700px'],
		    	  })
		      break;
		      
		      case 'editFun':	//修改部门
		    	  upUser(userid);
		      break;
			        
		      case 'delFunc':	//删除部门
		    	  if(data.length == 0 || data.length > 1){
						layer.msg("请选择一行数据进行操作shan")
						return ;
					}else{
						layer.confirm('确定删除用户吗', {icon: 3, title:'提示'}, function(index){
							var loginName = $("#loginName").val();
							if(userid == loginName){
								layer.msg("你正在登录当前账号,无法删除")
							}else{
								delUser(userid);
								layer.close(index);
							}
			            });
					}
		      break;
	    };
	  });
    
	  //修改部门
	    function upUser(userid){
	    	layui.layer.open({
	    		title : "修改用户信息",
	    		type : 2,
	    		content : "jsp/yonghu/userInfo.jsp",
	    		area:['400px','540px'],
	    		success:function(layero, index){
	    			$.ajax({
	    				url:"/EMentTet/UserServlet?action=allUserByUserid",
	    				type:"post",
	    				data:{"userid":userid},
	    				success:function(data){
	    					
	    					var info = eval('(' + data + ')');
	          				var body = layui.layer.getChildFrame('body', index);
	          				body.find("#uid").val(info.id);          				
	    					body.find("#uname2").val(info.userCode);
	    					body.find("#uname").val(info.userCode);
	    					body.find("#password").val(info.userPassword);
	    					body.find("#realName").val(info.userName);
	    					body.find("#age").val(info.age);
	    					body.find("#phone").val(info.phone);
	    					//性别(单选)
	    					var sex2 = info.gender;
	    					if(sex2 == 1){
	    						body.find("#sex1").prop("checked",true);
	    					}else{
	    						body.find("#sex2").prop("checked",true);
	    					}
	    					 
	    				 
	    					

	    	    			/*------下拉框赋值--------*/
	    					$.ajax({
	    						  url:"/EMentTet/JueseServlet?action=allRole",
	    						  type:"post",
	    						  success:function(data){	
	    							 
	    							  var info = eval("("+data+")");
	    							  var row = info;
	    							 alert(row);
	    							 var body = layui.layer.getChildFrame('body', index);
	    							  var role = body.find("#role1");
	    							  var html = '';
	    	    							  $.each(row,function(index,item){
	    	    								  html += '<option value="'+item.id+'">'+item.lodName+'</option>';
	    	    								  
	    	    							  })
	    	    							  role.html(html);
	    	    							//获取新窗口对象
	    			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
	    			                        //重新渲染
	    			                        iframeWindow.layui.form.render();
	    								  }
	    							  })
	    							  
	    							  	$.ajax({
	    						  url:"/EMentTet/JueseServlet?action=allBumeng",
	    						  type:"post",
	    						  success:function(data){		 
	    							  var info = eval("("+data+")");
	    							  var row = info;
	    							 
	    							  var html = '';
	    							  var body = layui.layer.getChildFrame('body', index);
	    							  var role = body.find("#bumeng");
	    							 
	    	    							  $.each(row,function(index,item){
	    	    								  html += '<option value="'+item.id+'">'+item.meng_name+'</option>';
	    	    							  })
	    	    							  role.html(html);
	    	    							//获取新窗口对象
	    			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
	    			                        //重新渲染
	    			                        iframeWindow.layui.form.render();
	    								  }
	    							  })
	    							  	$.ajax({
	    						  url:"/EMentTet/JueseServlet?action=allZhicheng",
	    						  type:"post",
	    						  success:function(data){		 
	    							  var info = eval("("+data+")");
	    							  var row = info;
	    							 
	    							  var html = '';
	    							  var body = layui.layer.getChildFrame('body', index);
	    							  var role = body.find("#zhicheng");
	    						 
	    							 /* var role = body.find("#zhicheng");*/
	    	    							  $.each(row,function(index,item){
	    	    								  html += '<option value="'+item.id+'">'+item.zhi_name+'</option>';
	    	    								 
	    	    							  })
	    	    							  role.html(html);
	    	    							//获取新窗口对象
	    			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
	    			                        //重新渲染
	    			                        iframeWindow.layui.form.render();
	    								  }
	    							  })
	    						  
	    				
	    					/*  ------下拉框赋值--------*/
	    					//赋值后选中
	    				/*	$.ajax({
	    						url:"/denglu/LodeSerlvet?action=allRoleUserid",
	    						type:"post",
	    						data:{"userid":userid},
	    						success:function(data){
	    							alert(data)
	    							var info2 = eval("("+data+")")
	    							if(info2 == 0){
	    								var select = 'dd[lay-value="0"]';
	        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
	    							}else{
	    								var select = 'dd[lay-value='+info2.data.id+']';
	    								alert(info2.data.id)
	        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
	    							}
	    						}
	    					})*/
	                        //获取新窗口对象
	                        var iframeWindow = layero.find('iframe')[0].contentWindow;
	                        //重新渲染
	                        iframeWindow.layui.form.render();
	    				}
	    			})
	    		}
	    	})
	    }
	    //新增用户
	    function addUser(){
	    	layui.layer.open({
	    		title : "添加部门",
	    		type : 2,
	    		content : "/EMentTet/jsp/yonghu/userAdd.jsp",
	    		area:['400px','490px'],
	    		success:function(layero, index){
	    			/*------下拉框赋值--------*/
					$.ajax({
						  url:"/EMentTet/JueseServlet?action=allRole",
						  type:"post",
						  success:function(data){	
							 
							  var info = eval("("+data+")");
							  var row = info;
							 alert(row);
							 var body = layui.layer.getChildFrame('body', index);
							  var role = body.find("#role1");
							  var html = '';
	    							  $.each(row,function(index,item){
	    								  html += '<option value="'+item.id+'">'+item.lodName+'</option>';
	    								  
	    							  })
	    							  role.html(html);
	    							//获取新窗口对象
			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
			                        //重新渲染
			                        iframeWindow.layui.form.render();
								  }
							  })
							  
							  	$.ajax({
						  url:"/EMentTet/JueseServlet?action=allBumeng",
						  type:"post",
						  success:function(data){		 
							  var info = eval("("+data+")");
							  var row = info;
							 
							  var html = '';
							  var body = layui.layer.getChildFrame('body', index);
							  var role = body.find("#bumeng");
							 
	    							  $.each(row,function(index,item){
	    								  html += '<option value="'+item.id+'">'+item.meng_name+'</option>';
	    							  })
	    							  role.html(html);
	    							//获取新窗口对象
			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
			                        //重新渲染
			                        iframeWindow.layui.form.render();
								  }
							  })
							  	$.ajax({
						  url:"/EMentTet/JueseServlet?action=allZhicheng",
						  type:"post",
						  success:function(data){		 
							  var info = eval("("+data+")");
							  var row = info;
							 
							  var html = '';
							  var body = layui.layer.getChildFrame('body', index);
							  var role = body.find("#zhicheng");
						 
							 /* var role = body.find("#zhicheng");*/
	    							  $.each(row,function(index,item){
	    								  html += '<option value="'+item.id+'">'+item.zhi_name+'</option>';
	    								 
	    							  })
	    							  role.html(html);
	    							//获取新窗口对象
			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
			                        //重新渲染
			                        iframeWindow.layui.form.render();
								  }
							  })
						  }
					  })
	    		}
	    	 
	  
	    //删除部门
	    function delUser(userid){
	    	$.ajax({
	    		url:"bumen?action=delbumen",
	    		data:{"userid":userid},
	    		type:"post",
	    		success:function(data){
	    			  var info = eval("("+data+")");
	    			if(data == 1){
	    				layer.msg("删除成功")
	    				tableIns.reload("#newsList");
	    			}
	    		}
	    	})
	    }
    
	//分配权限
	    function hairMenu(userid){
	    	 
	    	layui.layer.open({
	    		title : "分配权限",
	    		type : 1,
	    		content : $('#dtree1'),
	    		area:['300px','500px'],
	    		success:function(){
	    		    //给dtree树加载数据
	    			
	    			dtree.render({
					  elem: "#dataTree3",
					  url: "/EMentTet/QuanServletInterface?action=allMenuDtree",
					  dataStyle: "layuiStyle",  //使用layui风格的数据格式
				  dataFormat: "list",  //配置data的风格为list
					  response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
					  checkbar:true,
					  line: true,  // 显示树线
					  done: function(res, $ul, first){
						  
						  $.ajax({
							  url:"/EMentTet/QuanServletInterface?action=menuByUseridType1",
							  type:"post",
							  data:{"userid":userid},
							  success:function(res){
								  
								  var cs = eval('(' + res + ')');
								  $.each(cs,function(index,row){
									dtree.chooseDataInit("dataTree3",[row.id]); // 初始化选中
								  })
							  }
						  })
	  		    	  }
	    			});
	    		} ,
	    	 btn:['分配权限'],
	    		yes: function(index, layero){
	    			var params = dtree.getCheckbarNodesParam("dataTree3");
	    			var infos = JSON.stringify(params);
	    			var cs = eval('(' + infos + ')');
	    			var menuidList = new Array();	//所有选中值的权限id
	    			//alert(menuidList.length);
	    			$.each(cs,function(index,row){
						menuidList[index] = row.nodeId;
	    			})
	    			$.ajax({
	    				url:"/EMentTet/QuanServletInterface?action=menuByUserid",
	    				data:{"array":menuidList,"userid":userid},
	    				type:"post",
	    				traditional:true,
	    				success:function(data){
	    					var demo = eval('(' + data + ')');
	    					if(demo.status == 1){
	    						layer.msg(demo.message);
	    						layer.close(index)	//关闭
	    					}else{
	    						layer.msg("分配失败");
	    					}
	    				}
	    			})
	    		}  
	    	})
	    }
  
    
     

})