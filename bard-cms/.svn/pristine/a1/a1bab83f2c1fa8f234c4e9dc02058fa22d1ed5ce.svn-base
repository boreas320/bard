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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理系统界面</title>
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="170,*" frameborder="no" border="0" framespacing="0">
    <frame src="left.jsp" name="leftFrame" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="<%=basePath%>userTokenAction!getUsertokenList" name="rightFrame" id="rightFrame" title="rightFrame" /> 
  </frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>
