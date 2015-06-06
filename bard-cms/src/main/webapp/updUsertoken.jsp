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
		        $(".imglist li.selected").removeClass("selected")
		        $(this).addClass("selected");
		    });  
		});  
		function toUpdate() {
            if (document.all.form1.uname.value != ""
                    || document.all.form1.uname.value != null) {
                if (document.all.form1.udid.value != ""
                        || document.all.form1.udid.value != null) {
                     form1.action = "<%=basePath%>userTokenAction!updateUsertoken?t_id=${userToken.tid}";
                     form1.submit();
                } else {
                    alert("设备号不能为空！");
                }
            } else {
                alert("用户名不能为空！");
            }
        } 
	</script>
    </head>
<body>
  <form name="form1" action="<%=basePath%>userTokenAction!updateUsertoken?t_id=${userToken.tid}" method="post">
        <fieldset>
            <legend><span><img src="images/t02.png" />修改员工认证码信息</span></legend>
            
            <table class="imgtable" align=center>
            <tbody>
                <tr>
                    <td class="imgtd">姓名</td>
                    <td><input type="text" name="uname" value="${userToken.uname}"/></td>
                </tr>
                <tr>
                    <td class="imgtd">设备号</td>
                    <td><input type="text" name="udid" value="${userToken.udid}"/></td>
                </tr>
                <tr>
                    <td class="imgtd">所属地区</td>
                    <td><input type="text" name="region" value="${userToken.region}"/></td>
                </tr>
                <tr>
                    <td class="imgtd">职级</td>
                    <td><input type="text" name="rank" value="${userToken.rank}"/></td>
                </tr>
                <tr>
                    <td>文件访问权限</td>
                    <td>
                        <select id="typeSelect" name="userType">
                            <option value="" selected="selected">默认权限</option> 
                            <c:choose>
                            <c:when test="${userToken.userType eq 'A'}">
                                  <option value="A" selected="selected">A</option>
                                  <option value="B">B</option>
                                  <option value="C">C</option> 
                            </c:when>
                            <c:when test="${userToken.userType eq 'B'}">
                                  <option value="A">A</option>
                                  <option value="B" selected="selected">B</option>
                                  <option value="C">C</option> 
                            </c:when>
                            <c:when test="${userToken.userType eq 'C'}">
                                  <option value="A">A</option>
                                  <option value="B">B</option>
                                  <option value="C" selected="selected">C</option> 
                            </c:when>
                            <c:otherwise>
                                 <option value="A">A</option>
                                 <option value="B">B</option>
                                 <option value="C">C</option>
                            </c:otherwise>
                            </c:choose>
                         </select>
                      </td>
                  </tr>
                  <tr>
                    <td></td>
                    <td class="tipbtn"><!-- 'return confirm("确定修改吗？")' -->
                        <input type="submit" class="sure" value="修改"  onclick="toUpdate();"/>
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