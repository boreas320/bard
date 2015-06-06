<%@ page language="java"  pageEncoding="gb2312"  contentType="text/html;charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
	<base href="<%=basePath%>">
		<title>download</title>
	</head>
	<body>
		<%--	<s:iterator value="uploadFileName" id="downloadFileName">--%>
		<%--				<a href="download.action?name=<s:property value='%{#downloadFileName}'/>"><s:property value="%{#%{#downloadFileName}}" /> </a>--%>
		<%--				<br>--%>
		<%--	</s:iterator>--%>
		<table align="center" width="50%" border="1">
			<tr>
				<td align="center">
					нд╪Чобть
				</td>
			</tr>
			<c:forEach var="uploadFiles" items="${uploadFiles}">
				<tr>
					<td>
                    <a  href="${basePath}downloadAction?name=${uploadFiles.uploadRealName }&realname=${uploadFiles.uploadFileName }">${uploadFiles.uploadFileName
							}</a>
					</td>
				</tr>

			</c:forEach>


		</table>
	</body>
</html>