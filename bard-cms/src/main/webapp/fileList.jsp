<%@ page language="java" import="java.util.*" pageEncoding="gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'fileList.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script language="javascript">
        $(function () {
            //导航切换
            $(".imglist li").click(function () {
                $(".imglist li.selected").removeClass("selected");
                $(this).addClass("selected");
            });
        });
        $(function () {
            setInterval(function () {
                $.get("fileAction!getZipFileProgress", function (data) {
                    var result = $.parseJSON(data);
                    $("#last").text(new Date(result.lastZipBeginTime).toLocaleString());
                    $("#progress").text(result.percent + "%")
                });
            }, 5000)
        });


    </script>
</head>
<body>
<!-- <div class="place">
<span>位置：</span>
<ul class="placeul">
<li><a href="#">首页</a></li>
<li>文件管理列表 </li>
</ul> </div>-->
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="<%=basePath%>fileAction!listFile?folderPath=${currentFolder}">${currentFolder}</a></li>
    </ul>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span><a href="<%=basePath%>fileAction!zipFile" class="cancel">手动打包</a></span><span>上次执行时间</span><span
        id="last"></span> <span>当前进度</span><span id="progress"></span>
</div>

<div class="rightinfo">
    <!-- <div class="tools">
	    <ul class="toolbar">
	        <li><span><img src="images/t01.png"/><a href="addUsertoken.jsp">添加员工认证码</a></span></li>
	    </ul>
    </div> -->
    <div class="tools">
        <%--  <input type="button" class="cancel" value="返回根目录" onclick="<%=basePath%>fileAction!listFile"/>
         <input type="button" class="cancel" value="返回上一层" onclick="history.go(-1); " /> --%>
        <!--         <input type="button" class="cancel" value="返回上一层" onclick="history.go(-1);"/>  -->
        <!--         <input type="button" class="cancel" value="返回上一层" onclick="history.go(-1); "/>&nbsp;&nbsp;&nbsp;&nbsp; -->
        <a href="<%=basePath%>fileAction!listFile?folderPath=${lastFolder}" class="cancel">返回上一层</a>
    </div>
    <form>
        <table class="imgtable">
            <thead>
            <tr>
                <th>文件路径</th>
                <th>文件夹</th>
                <th>文件名</th>
                <th>大小</th>
                <th>后缀名</th>
                <th>文件权限</th>
                <th>邮件发送</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="li" items="${itemList}">
                <tr>
                    <td width="250px" class="imgtd">
                        <c:if test="${li.isfolder == true}">
                            <a class="click"
                               href="<%=basePath%>fileAction!listFile?folderPath=${li.folderpath}">${li.folderpath}</a>
                        </c:if>
                        <c:if test="${li.isfolder == false}">${li.folderpath}</c:if>
                    </td>
                    <td>
                        <c:if test="${li.isfolder == true}">文件夹</c:if>
                        <c:if test="${li.isfolder == false}">文件</c:if>
                    </td>
                    <td width="250px"> ${li.filename}</td>
                    <td><fmt:formatNumber value="${li.size/1024}" pattern="##.##"
                                          minFractionDigits="2"></fmt:formatNumber>(KB)
                    </td>
                    <td> ${li.extension}</td>
                    <td>
                        <c:if test="${li.isfolder == true}">
                            <select id="typeSelect" name="fileType">
                                <option value="0" selected="selected">默认权限</option>
                                <c:choose>
                                    <c:when test="${li.type == 1}">
                                        <option value="1" selected="selected">A</option>
                                        <option value="2">B</option>
                                        <option value="3">C</option>
                                    </c:when>
                                    <c:when test="${li.type == 2}">
                                        <option value="1">A</option>
                                        <option value="2" selected="selected">B</option>
                                        <option value="3">C</option>
                                    </c:when>
                                    <c:when test="${li.type == 3}">
                                        <option value="1">A</option>
                                        <option value="2">B</option>
                                        <option value="3" selected="selected">C</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="1">A</option>
                                        <option value="2">B</option>
                                        <option value="3">C</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${li.isfolder == false}">
                            <select id="sendSelect" name="send">
                                <c:choose>
                                    <c:when test="${li.send == 0}">
                                        <option value="1">是</option>
                                        <option value="0" selected="selected">否</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="1" selected="selected">是</option>
                                        <option value="0">否</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </c:if>
                    </td>
                    <td>
                        <a class="click"
                           href="<%=basePath%>fileAction!getFile?folderPath=${li.folderpath}&fileName=${li.filename}&isFolder=${li.isfolder}"
                           onclick='return confirm("确定修改该记录？")'>修改</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript">
    $('.imgtable tbody tr:odd').addClass('odd');
</script>
</body>
</html>