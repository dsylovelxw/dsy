layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

 /* $.ajax({
	  url:"/EMentTet/JueseServlet?action=allRole",
	  type:"post",
	  success:function(data){
		  
		  var info = eval("("+data+")");
		  var row = info.data;  
		  var role = $("#role1");
		  var html = '';
		  $.each(row,function(index,item){
			
			  html += '<option value="'+item.id+'">'+item.lodName+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
    $.ajax({
	  url:"/EMentTet/JueseServlet?action=allBumeng",
	  type:"post",
	  success:function(data){
		  
		  var info = eval("("+data+")");
		  var row = info.data;
		  
		  var role = $("#bumeng");
		  var html = '';
		  $.each(row,function(index,item){
			
			  html += '<option value="'+item.id+'">'+item.rname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
    $.ajax({
	  url:"/EMentTet/JueseServlet?action=allZhicheng",
	  type:"post",
	  success:function(data){
		  
		  var info = eval("("+data+")");
		  var row = info.data;
		  
		  var role = $("#zhicheng");
		  var html = '';
		  $.each(row,function(index,item){
			
			  html += '<option value="'+item.id+'">'+item.rname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })*/
 
  function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"/EMentTet/bumen?action=addbumrn",
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
	  if(!name.length == "" || !name.length == null){
		  var check = checkUname(name);
		  if(check == true){
			  layer.alert("登录账号已存在! 请重新输入")
		  }
	  }
  })
  
  
  $("#tijiao").click(function(){
	  var name = $("#uname").val();
	  var shu = $("#shu").val();
	  var userid = $("#userid").val();
	  var data = {
			  "name":name,
			  "shu":shu,
			  "userid":userid
			  
	  }
	  if(name.length<3){
		  layer.alert("登录名不能小于3位数")
		  return false;
	  }else if(pass.length < 5 || pass.length > 19){
		  layer.alert('密码必须6到12位，且不能出现空格');
		  return false;
	  }else if(realName.length == "" || realName.length == null){
		  layer.alert('用户名不能为空');
		  return false;
	  } 
	 else if(phone.length != 11){
		  layer.alert("手机格式不正确! 请重新输入");
		  return false;
	  }else if(!name.length == "" || !name.length == null){
		  var check = checkUname(name);
		  if(check == true){
			  layer.alert("登录账号已存在! 请重新输入")
			  return false;
		  }
	  }
	  $.ajax({
	  		url:"/EMentTet/UserServlet?action=addUser",
			data:data,
			tyep:"post",
			success:function(data){
				  var info = eval("("+data+")");
				if(data !=0){
					layer.msg("添加成功")
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
