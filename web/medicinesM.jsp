<%@ page import="medicines.domain.Medicine" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/1/12
  Time: 20:21
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
                <li><a href="#">总览</a></li>
                <li class="active"><a href="./medicines.html">药品信息<span class="sr-only">(current)</span></a></li>
                <li><a href="./resposity.html">仓库</a></li>
                <li><a href="./factory.html">生产厂家</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="./inResposity.html">进货单</a></li>
                <li><a href="./outResposity.html">销售单</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="./inResposityMore.html">进货明细</a></li>
                <li><a href="./outResposityMore.html">销售明细</a></li>
                <li><a href="./costumer.html">客户</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h2 class="sub-header">药品信息</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <tr>
                        <%--<th>序号</th>--%>
                        <th>名称</th>
                        <th>编号</th>
                        <th>分类</th>
                        <th>生产厂家</th>
                        <th>进价</th>
                        <th>售价</th>
                        <th>折扣</th>
                        <th>有效期（单位：月）</th>
                    </tr>
                    <%
                        List<Medicine> list = (List<Medicine>) request.getAttribute("list");
                        if(list == null || list.size()<1){
                            PrintWriter writer = response.getWriter();
                            writer.print("没有数据");
                            writer.flush();
                            writer.close();
                        }else {
                            for (Medicine medicine : list){
                    %>

                    <tr id="medicine_list">
                        <td><%=medicine.getMed_name()%></td>
                        <td><%=medicine.getMed_id()%></td>
                        <td><%=medicine.getMde_class()%></td>
                        <td><%=medicine.getFactor()%></td>
                        <td><%=medicine.getPurchase_price()%></td>
                        <td><%=medicine.getSale_price()%></td>
                        <td><%=medicine.getDiscount()%></td>
                        <td><%=medicine.getValidity()%></td>
                    </tr>
                    <%
                        }
                    }
                    %>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="./Dashboard Template for Bootstrap_files/jquery.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/bootstrap.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/holder.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>


</body>
</html>
