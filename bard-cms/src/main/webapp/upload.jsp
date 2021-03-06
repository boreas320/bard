<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	<!--addMore函数可以提供上传多个文件上传-->
	
	function addMore()
	{
	    var td = document.getElementById("more");
	    var br = document.createElement("br");
	    var input = document.createElement("input");
	    var button = document.createElement("input");
	    
	    input.type = "file";
	    input.name = "upload";
	    
	    button.type = "button";
	    button.value = "   删除    ";
	    
	    button.onclick = function()
	    {
	        td.removeChild(br);
	        td.removeChild(input);
	        td.removeChild(button);
	    }
	    
	    td.appendChild(br);
	    td.appendChild(input);
	    td.appendChild(button);
	}
	</script>
  </head>
  
  <body>
    <!--<h3><font color="red">上传文件类型后缀为doc,ppt,xls,pdf,txt,java，每个文件大小不能大于50M</font></h3>-->
        <table align="center" width="50%">
            <tr>
                <td>
                    <!--        <s:actionerror cssStyle="color:red"/>-->
                    <s:fielderror cssStyle="color:red" />
                </td>
            </tr>
        </table>
        
        <s:form action="%{basePath}uploadAction"  theme="simple" method="post" enctype="multipart/form-data">
            <table align="center" width="50%" border="1">
                <tr>
                    <td>
                                                           上传文件
                    </td>
                    <td id="more" >
                        <s:file name="upload"></s:file>
                        <input type="button" value="上传更多..." onclick="addMore()">
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:submit value=" 确认 "></s:submit>
                    </td>
                    <td>
                        <s:reset value=" 重置 "></s:reset>
                    </td>
                </tr>
            </table>
        </s:form>
  </body>
</html>
