<%@ page language="java" import="java.util.*" pageEncoding="gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'userlist.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script language="javascript">
        $(function () {
            //�����л�
            $(".imglist li").click(function () {
                $(".imglist li.selected").removeClass("selected");
                $(this).addClass("selected");
            });
        });
    </script>
    <style type="text/css">
td{
    word-break: break-all;
}
        .tid {width:5%;


        }

        .name {width:8%;
        }

        .udid {width:10%;
        }

        .utoken {width:7%;
        }

        .region {width:7%;
        }

        .rank {width:7%;
        }

        .status {width:5%;
        }

        .timestamp {width:12%;
        }

        .modifytime {width:12%
        }

        .usertype {width:8%;
        }

        .action {width:10%;
        }




    </style>
</head>
<body>
<div class="place">
    <span>λ�ã�</span>
    <ul class="placeul">
        <!--  <li><a href="#">��ҳ</a></li> -->
        <li>Ա����֤���б�</li>
    </ul>
</div>

<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li><span><img src="images/t01.png"/><a href="addUsertoken.jsp"><font style="font-size:120%">����Ա����֤��</font></a></span>
            </li>
        </ul>
    </div>

    <table class="imgtable">
        <thead>
        <tr>
            <th class="tid">ID</th>
            <th class="name">�û���</th>
            <th class="udid">�豸��</th>
            <th class="utoken">��֤��</th>
            <th class="region">��������</th>
            <th class="rank">ְ��</th>
            <th class="status">״̬</th>
            <th class="timestamp">����ʱ��</th>
            <th class="modifytime">ʧЧʱ��</th>
            <th class="usertype">�û�Ȩ��</th>
            <th class="action8">����</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="li" items="${list}">
            <tr>
                <td class="imgtd tid"> ${li.tid}</td>
                <td class="name"> ${li.uname}</td>
                <td class="udid"> ${li.udid}</td>
                <td class="utoken"> ${li.utoken}</td>
                <td class="region"> ${li.region}</td>
                <td class="rank"> ${li.rank}</td>
                <td class="status">
                    <c:if test="${li.status == '1'}">ʧЧ</c:if>
                    <c:if test="${li.status == '0'}">��Ч</c:if>
                </td>
                <td class="timestamp"> ${li.timestamp}</td>
                <td class="modifytime"> ${li.modifytime}</td>
                <td class="usertype">
                    <select id="typeSelect" name="userType">
                        <option value="" selected="selected">Ĭ��Ȩ��</option>
                        <c:choose>
                            <c:when test="${li.userType eq 'A'}">
                                <option value="A" selected="selected">A</option>
                                <option value="B">B</option>
                                <option value="C">C</option>
                            </c:when>
                            <c:when test="${li.userType eq 'B'}">
                                <option value="A">A</option>
                                <option value="B" selected="selected">B</option>
                                <option value="C">C</option>
                            </c:when>
                            <c:when test="${li.userType eq 'C'}">
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
                <td class="action">
                    <a class="click" href="<%=basePath%>userTokenAction!invalidUsertoken?t_id=${li.tid}"
                       onclick='return confirm("ȷ��ʧЧ�ü�¼��")'>ʧЧ</a>
                    <a class="click" href="<%=basePath%>userTokenAction!deleteUsertoken?t_id=${li.tid}"
                       onclick='return confirm("ȷ��ɾ���ü�¼��")'>ɾ��</a>
                    <a class="click" href="<%=basePath%>userTokenAction!operateUsertoken?t_id=${li.tid}"
                       onclick='return confirm("ȷ���޸ĸü�¼��")'>�޸�</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    $('.imgtable tbody tr:odd').addClass('odd');
</script>
</body>
</html>