<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>认证码管理系统</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="js/jquery.js"></script>
	<script src="js/cloud.js" type="text/javascript"></script>
	
	<script language="javascript">
	    $(function(){
		    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		    $(window).resize(function(){  
		    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	     });  
	    }); 
	    
	    function toLogin() {
	        if (document.all.form1.username.value != ""
	                || document.all.form1.username.value != null) {
	            if (document.all.form1.password.value != ""
	                    || document.all.form1.password.value != null) {
	                 form1.action = "<%=basePath%>loginAction!login";
	                 form1.submit();
	            } else {
	                alert("密码不能为空！");
	            }
	        } else {
	            alert("用户账号不能为空！");
	        }
        } 
   </script> 
  </head>
  
  <body style="background-color:#1c77ac; background-image:url(images/logo.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>认证码管理平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    <span class="systemlogo"></span> 
    <div class="loginbox">
    
    <form name="form1" action="" method="post">
	    <ul>
	    <li><input name="username" type="text" class="loginuser"  onclick="JavaScript:this.value=''"/></li>
	    <li><input name="password" type="password" class="loginpwd"  onclick="JavaScript:this.value=''"/></li>
	    <li><input name="" type="button" class="loginbtn" value="登录"  onclick="toLogin();"/>
        <!-- <label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label> -->
	    </li>
	    </ul>
    </form>
    </div>
    </div>
</body>

</html>
