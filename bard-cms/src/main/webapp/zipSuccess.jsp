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
bb=aa.getYear()+"��"+(aa.getMonth()+1)+"��"+aa.getDate()+"��\r";
bb+="����"+'��һ����������'.charAt(aa.getDay())+"\r"+aa.getHours()+"ʱ";
bb+=aa.getMinutes()+"��"+aa.getSeconds()+"��";
document.all.cc.innerHTML=bb;
setTimeout("show()",1000)
}
</script>
<style type="text/css">
a:link   {text-decoration:none}     /* δ�����ʵ����� û���»���*/
a:hover  {text-decoration:underline}   /* ����������ϵ�����  ���»��� �»���Ϊunderline �ϻ���Ϊoverline ���»���Ϊnone*/
a:active {color: #0000FF;text-decoration:none}   /* �����м������� ��ɫ û���»���*/
</style>    
<style type="text/css">body{text-align:center; }</style>
<style type="text/css">td, th, input{font-size:12px; text-align:center; }</style>
</head>
  
<body onload="show();">
   <font  color="red">�Զ�����ɹ���</font><br/>
   <h1>${progressMonitor.percentDone}%</h1>
   <a  href="<%=basePath%>fileAction!listFile?folderPath=">�����ļ��б�</a>
</body>
</html>
