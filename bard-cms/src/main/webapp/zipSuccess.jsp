<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zipSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function show(){
var aa=new Date();
bb=aa.getYear()+"年"+(aa.getMonth()+1)+"月"+aa.getDate()+"日\r";
bb+="星期"+'日一二三四五六'.charAt(aa.getDay())+"\r"+aa.getHours()+"时";
bb+=aa.getMinutes()+"分"+aa.getSeconds()+"秒";
document.all.cc.innerHTML=bb;
setTimeout("show()",1000)
}
</script>
<style type="text/css">
a:link   {text-decoration:none}     /* 未被访问的链接 没有下划线*/
a:hover  {text-decoration:underline}   /* 鼠标悬浮在上的链接  有下划线 下划线为underline 上划线为overline 无下划线为none*/
a:active {color: #0000FF;text-decoration:none}   /* 鼠标点中激活链接 蓝色 没有下划线*/
</style>    
<style type="text/css">body{text-align:center; }</style>
<style type="text/css">td, th, input{font-size:12px; text-align:center; }</style>
</head>
  
<body onload="show();">
   <font  color="red">自动打包成功！</font><br/>
   <h1>${progressMonitor.percentDone}%</h1>
   <a  href="<%=basePath%>fileAction!listFile?folderPath=">返回文件列表</a>
</body>
</html>
