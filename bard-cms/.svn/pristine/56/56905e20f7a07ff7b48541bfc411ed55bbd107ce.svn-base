<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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
    
    <title>My JSP 'addUsertoken.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script language="javascript">
		$(function(){   
		    //导航切换
		    $(".imglist li").click(function(){
		        $(".imglist li.selected").removeClass("selected");
		        $(this).addClass("selected");
		    });  
		    $("#form1").on("submit",".sure",function() {
		       $.alert('--start---');
		    }); 
		});  
	</script>
    </head>
<body>
  <form id="form1" action="<%=basePath%>userTokenAction!addUsertoken" method="post">
        <fieldset>
            <legend><span><img src="images/t01.png" />新建员工认证码信息</span></legend>
            <table class="imgtable" align=center>
            <tbody>
                <tr>
                    <td class="imgtd">姓名</td>
                    <td><input type="text" name="uname" id="uname"/></td>
                </tr>
                <tr>
                    <td class="imgtd">设备号</td>
                    <td><input type="text" name="udid"  id="udid"/></td>
                </tr>
                <tr>
                    <td class="imgtd">所属地区</td>
                    <td><input type="text" name="region"  id="region"/></td>
                </tr>
                <tr>
                    <td class="imgtd">职级</td>
                    <td><input type="text" name="rank"  id="rank"/></td>
                </tr>
                <tr>
                <td>设置权限</td>
                <td>
                    <select id="typeSelect" name="userType">
                        <option value="" selected="selected">默认权限</option> 
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option> 
                     </select>
                </td>
                </tr>
                <tr>
                    <td></td>
                    <td class="tipbtn">   <!--  'return confirm("确定添加吗？")'-->
                        <input type="submit" class="sure" value="添加" />
                        <input type="button" class="cancel" value="返回" onclick="history.go(-1); " />
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
   </form>
<script type="text/javascript">
    $('.imgtable tbody tr:odd').addClass('odd');
</script>   
</body>
</html>