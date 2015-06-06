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
            //导航切换
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
    <span>位置：</span>
    <ul class="placeul">
        <!--  <li><a href="#">首页</a></li> -->
        <li>员工认证码列表</li>
    </ul>
</div>

<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li><span><img src="images/t01.png"/><a href="addUsertoken.jsp"><font style="font-size:120%">添加员工认证码</font></a></span>
            </li>
        </ul>
    </div>

    <table class="imgtable">
        <thead>
        <tr>
            <th class="tid">ID</th>
            <th class="name">用户名</th>
            <th class="udid">设备号</th>
            <th class="utoken">认证码</th>
            <th class="region">所属地区</th>
            <th class="rank">职级</th>
            <th class="status">状态</th>
            <th class="timestamp">创建时间</th>
            <th class="modifytime">失效时间</th>
            <th class="usertype">用户权限</th>
            <th class="action8">操作</th>
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
                    <c:if test="${li.status == '1'}">失效</c:if>
                    <c:if test="${li.status == '0'}">有效</c:if>
                </td>
                <td class="timestamp"> ${li.timestamp}</td>
                <td class="modifytime"> ${li.modifytime}</td>
                <td class="usertype">
                    <select id="typeSelect" name="userType">
                        <option value="" selected="selected">默认权限</option>
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
                       onclick='return confirm("确定失效该记录？")'>失效</a>
                    <a class="click" href="<%=basePath%>userTokenAction!deleteUsertoken?t_id=${li.tid}"
                       onclick='return confirm("确定删除该记录？")'>删除</a>
                    <a class="click" href="<%=basePath%>userTokenAction!operateUsertoken?t_id=${li.tid}"
                       onclick='return confirm("确定修改该记录？")'>修改</a>
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