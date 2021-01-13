<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/1/12
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>药品进销存管理系统</title>
    <link href="./Dashboard Template for Bootstrap_files/bootstrap.min.css" rel="stylesheet">
    <link href="./Dashboard Template for Bootstrap_files/dashboard.css" rel="stylesheet">
    <script src="./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-brand">药品进销存管理系统</div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">概览</a></li>
                <li><a href="${pageContext.request.contextPath}/infoServlet">药品信息</a></li>
                <li><a href="${pageContext.request.contextPath}/resposityServlet">仓库</a></li>
                <li><a href="${pageContext.request.contextPath}/factoryServlet">生产厂家</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/inServlet">进货单</a></li>
                <li><a href="${pageContext.request.contextPath}/outServlet">销售单</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/inMoreServlet">进货明细</a></li>
                <li><a href="${pageContext.request.contextPath}/outMoreServlet">销售明细</a></li>
                <li><a href="${pageContext.request.contextPath}/clientServlet">客户</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">药品进销存管理系统</h1>

            <div  style="float: left";>
                <h4>1）数据库设计：</h4>
                （1）了解（需求分析）药品进销存管理系统的功能需求、数据需求及其他需求；<br>
                （2）分析药品的进货、销售（含折扣）、过期处理、损耗、库存量控制、盘存等相关业务流程及相关实体；<br>
                （3）对所涉及的各类实体进行抽象，包括：药品的分类、生产厂家、药品销售、药品销售折扣、库存量控制与预警、过期药品、药品损耗、药品库存情况等；
                <h4>2）编程实现客户端对数据库进行访问。</h4>
                要求：<br>
                （1）每组 3 个人，每人都要建立库及全部表（数据库库部分要求），每人完成一个子系统（客户端部分要求）；<br>
                （2）每组提交一份设计报告，要能够体现每成员的完成部分；<br>
                （3）程序用选定的语言编写，必须上交上机调试通过的源程序。<br>
            </div>

        </div>
    </div>
</div>
</body>
</html>
