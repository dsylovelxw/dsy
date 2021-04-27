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
	 <link rel="stylesheet" href="<%=basePath %>/css/layui.css">
   <link rel="stylesheet" href="<%=basePath %>/layui-v2.5.5/lay/layui_ext/dtree/dtree.css"  />
   <link rel="stylesheet" href="<%=basePath %>/layui-v2.5.5/lay/layui_ext/dtree/font/dtreefont.css"/>
 
	<link rel="stylesheet" href="<%=basePath %>/css/public.css" />
	 
</head>
<body class="childrenBody">
 

	 
<script src="<%=basePath %>/layui-v2.5.5/lay/layui_ext/dtree/dtree.js"></script> 
  
 <script src=" <%=basePath %>/layui.js "></script>

</body>
	    <!-- 分配权限 -->
	<div style="height: 400px;overflow: auto;display: none;" id="dtree1" >
	  <ul id="dataTree3" class="dtree" data-id="0"></ul>
	</div>
	
	<!-- 分配角色 -->
	<div style="height: 400px;overflow: auto;display: none;" id="hairRole">
		<select name="Roleid" id="RoleName" lay-filter="RoleName">
	      	
		</select>
	</div>

</html>