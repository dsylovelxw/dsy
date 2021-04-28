layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

/*  var userid = $("#uid").val();
  alert(userid);*/
/*  $.ajax({
	  url:"/MenuTest/RoleServlet?action=allRole",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role1");
		  $.ajax({
			  url:"/MenuTest/UserServlet?action=",	//查询用户是否有角色有返回1,没有返回0
		  })
		  var html = '<option value="0">无角色</option>';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.rname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })*/
  
/*  //自定义验证规则
  var isyan = form.verify({
	uname: function(value){
      if(value.length < 3){
        return '登录名不能小于3位数';
      }
      if(!/[^\u4e00-\u9fa5]/.test(value)){
    	  return "登录名不能为中文";
      }
    },
    password: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ],
    content: function(value){
      layedit.sync(editIndex);
    }
  });*/
  
  function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"/EMentTet/BuMenSerlvetDSY?action=isUname",
		  data:{"uname":uname},
		  async:false,
		  type:"post",
		  success:function(data){
			  if(data == 0){
				  is = true;
			  }else{
				  is = false;
			  }
		  }
	  })
	  return is;
  }
  
  $("#uname").blur(function(){
	  var name = $("#uname").val();
	  var name2 = $("#uname2").val();

  })
  
  
  $("#xiugai").click(function(){
	  var id = $("#id").val();
	  var name = $("#uname").val();
	  var name2 = $("#uname2").val();
	  var renshu = $("#renshu").val();
	  var userid = $("#userid").val();
	 
 
	 
	  var data = {
			  "id":id,
			  "name":name,
			  "renshu":renshu, 
			  "userid":userid		  
	  }
	  if(name.length<3){
		  layer.alert("部门名称不能小于3位数")
		  return false;
	  } else if(renshu.length == "" || renshu.length == null){
		  layer.alert('人数不能为空');
		  return false;
	  } 
		  
	  
	 
	 
	  $.ajax({
	  		url:"/EMentTet/BuMenSerlvetDSY?action=updateUserByAdmin",
			data:data,
			tyep:"post",
			success:function(data){
				  var info = eval("("+data+")");
				if(data !=0){
					layer.msg("部门信息修改成功");
					setTimeout(function(){
						layer.closeAll("iframe");
			            //刷新父页面
			            parent.location.reload();
		        	},1000);
				}else{
					layer.msg("系统异常");
				}
			}
	  })
	  return false;
  })
  
});
/*jQuery(function($){ 
	  $.ajax({
		  url:"/MenuTest/RoleServlet?action=allRole",
		  type:"post",
		  success:function(data){
			  var info = eval("("+data+")");
			  var role = $("#role");
			  var html = '';
			  $.each(info.data,function(index,datas){
				  html += '<option value="'+datas.id+'">'+datas.rname+'</option>';
			  })
			  role.html(html);
		  }
		  
	})
}); */