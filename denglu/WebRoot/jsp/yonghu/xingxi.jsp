<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
 <%@ page import="denglu.entity.User "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

 <html>
<head>
	<meta charset="utf-8">
	<title>用户中心</title>
	
	 
</head>
<body class="childrenBody">

<div class="layuimini-container">
	<div class="layuimini-main">
		<blockquote class="layui-elem-quote quoteBox">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="uname" id="likename" class="layui-input" placeholder="请输入查找的登录名" />
				</div>
			</div>
			<div class="layui-inline">
				<button type="button" class="layui-btn" lay-filter="doSubmit" id="doSubmit">
		            <i class="layui-icon layui-icon-search layui-icon-normal"></i>搜索
				</button>
			</div> 
			<input type="text" id="loginName" value="${user.id }" style="display:none"/>
		</blockquote> 
		  <script type="text/html" id="toolbarDemo">
     <c:forEach var="List" items="${deeee}">
           ${List.mben}  
     </c:forEach>
         </script>
         
         
     <div style="padding: 15px;">
	 
	 
     <table id="demmmm" lay-filter="test"></table>
      <script type="text/javascript">
      
      </script>
 
</div>
	</div>
</div>

 

</body>
	    <link rel="stylesheet" href="css/layui.css">
   <link rel="stylesheet" href="layui-v2.5.5/lay/layui_ext/dtree/dtree.css"  />
   <link rel="stylesheet" href="layui-v2.5.5/lay/layui_ext/dtree/font/dtreefont.css"/>
 
	<link rel="stylesheet" href=" css/public.css" />
	<!--   分配权限  
	<div style="height: 400px;overflow: auto;display: none;" id="dtree1" >
	  <ul id="dataTree3" class="dtree" data-id="0"></ul>
	</div>
	
	 
	  -->
<script src="layui-v2.5.5/lay/layui_ext/dtree/dtree.js"></script> 
  
 <script src=" layui.js "></script>

</html>
  

   

	 
	 
 
 
 

 

 