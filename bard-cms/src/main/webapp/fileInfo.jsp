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
    
    <title>My JSP 'updateFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script language="javascript">
		$(function(){   
		    //�����л�
		    $(".imglist li").click(function(){
		        $(".imglist li.selected").removeClass("selected")
		        $(this).addClass("selected");
		    });  
		});  
	</script>
    </head>
<body>
  <form name="form1" action="<%=basePath%>fileAction!updateFile" method="post">
        <fieldset>
            <legend><span><img src="images/t02.png" />�����ļ�����</span></legend>
            <input type="hidden" name="isFolder" value="${fileItem.isfolder}"></input>
            <table class="imgtable" align=center>
            <tbody>
                <tr>
                    <td class="imgtd">�ļ�����·��</td>
                    <td><input type="text" name="folderPath" value="${fileItem.folderpath}" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td class="imgtd">�ļ���</td>
                    <td><input type="text" name="fileName" value="${fileItem.filename}" readonly="readonly"/></td>
                </tr>
                <c:if test="${fileItem.isfolder == true}">
	                <tr>
	                    <td>�ļ�����Ȩ��</td>
	                    <td>
	                        <select id="typeSelect" name="fileType">
	                            <option value="0" selected="selected">Ĭ��Ȩ��</option> 
	                            <c:choose>
	                            <c:when test="${fileItem.type == 1}">
	                                  <option value="1" selected="selected">A</option>
	                                  <option value="2">B</option>
	                                  <option value="3">C</option> 
	                            </c:when>
	                            <c:when test="${fileItem.type == 2}">
	                                  <option value="1">A</option>
	                                  <option value="2" selected="selected">B</option>
	                                  <option value="3">C</option> 
	                            </c:when>
	                            <c:when test="${fileItem.type == 3}">
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
	                      </td>
	                  </tr>
                  </c:if>
                  <c:if test="${fileItem.isfolder == false}">
	                  <tr>
	                       <td>�Ƿ�֧���ʼ�����</td>
	                       <td>
	                           <select id="sendSelect" name="sendType">
	                               <c:choose>
	                                   <c:when test="${fileItem.send == 0}">
	                                     <option value="1">��</option>
	                                     <option value="0" selected="selected">��</option>
	                                   </c:when>
	                                   <c:otherwise>
	                                     <option value="1" selected="selected">��</option>
	                                     <option value="0">��</option>
	                                   </c:otherwise>
	                               </c:choose>  
	                           </select>
	                       </td>
	                   </tr>
                   </c:if>
                   <tr>
	                    <td></td>
	                    <td class="tipbtn"><!-- 'return confirm("ȷ���޸���")' -->
	                        <input type="submit" class="sure" value="�޸�"/>
	                        <input type="button" class="cancel" value="����" onclick="history.go(-1); " />
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