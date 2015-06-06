<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
	<script type="text/javascript">
	$(function(){   
	    //导航切换
	    $(".menuson li").click(function(){
	        $(".menuson li.active").removeClass("active");
	        $(this).addClass("active");
	    });
	    
	    $('.title').click(function(){
	        var $ul = $(this).next('ul');
	        $('dd').find('ul').slideUp();
	        if($ul.is(':visible')){
	            $(this).next('ul').slideUp();
	        }else{
	            $(this).next('ul').slideDown();
	        }
	    });
	});  
	</script>
  </head>
  
  <body style="background:#f0f9fd;">
  <!--   <div class="lefttop"><span></span>通讯录</div> -->
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>管理信息
    </div>
        <ul class="menuson">
      <!--  <li class="active"><cite></cite><a href="computer.html" target="rightFrame">文件管理</a><i></i></li> -->
        <!--  <li><cite></cite><a href="right.html" target="rightFrame">数据列表</a><i></i></li> -->
        <li class="active"><cite></cite><a href="<%=basePath%>userTokenAction!getUsertokenList" target="rightFrame">用户认证码管理</a><i></i></li>
         <li><cite></cite><a href="<%=basePath%>fileAction!listFile" target="rightFrame">文件管理</a><i></i></li>
      <!--   <li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li>
        <li><cite></cite><a href="imglist.html" target="rightFrame">图片列表</a><i></i></li>
        <li><cite></cite><a href="imglist1.html" target="rightFrame">自定义</a><i></i></li>
        <li><cite></cite><a href="error.html" target="rightFrame">404页面</a><i></i></li> -->
        </ul>    
    </dd>
    </dl>
</body>
</html>