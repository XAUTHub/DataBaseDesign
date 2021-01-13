<%@ page import="medicines.domain.details.Factory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/1/13
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>药品进销存管理系统</title>
    <link href="./Dashboard Template for Bootstrap_files/bootstrap.min.css" rel="stylesheet">
    <link href="./Dashboard Template for Bootstrap_files/dashboard.css" rel="stylesheet">
    <script src="./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>

    <link rel="stylesheet" href="./css/my.css">
    <link rel="stylesheet" href="./css/settlement.css">
    <link rel="stylesheet" href="./css/bottom.css">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script type="text/javascript" src="./js/dropdown.js"></script>

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
                <li><a href="${pageContext.request.contextPath}/overView.jsp">概览</a></li>
                <li><a href="${pageContext.request.contextPath}/infoServlet">药品信息</a></li>
                <li><a href="${pageContext.request.contextPath}/resposityServlet">仓库</a></li>
                <li class="active"><a href="#">生产厂家</a></li>
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

            <h2 class="sub-header">已生产商品清单</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <tr>
                        <th>厂家名称</th>
                        <th>药品编号</th>
                        <th>生产日期</th>
                        <th>进价</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>
                    <%
                        List<Factory> list = (List<Factory>) request.getAttribute("list");
                        if(list == null || list.size()<1){
//                            PrintWriter writer = response.getWriter();
//                            writer.print("没有数据");
//                            writer.flush();
//                            writer.close();
                        }else {
                            for (Factory factory : list){
                    %>

                    <tr id="<%=factory.getMed_identify()%>">
                        <%--<td><img src="<%=storage.getImg_url()%>" style="width: 40px;"></td>--%>
                        <td><%=factory.getFac_name()%></td>
                        <td><%=factory.getMed_identify()%></td>
                        <td><%=factory.getProduction_date()%></td>
                        <td><%=factory.getPurchase_price()%></td>
                        <td class="p-quantity">
                            <input type="button" class="decrease" value="-">
                            <input type="text" class="quantity" value="0"/>
                            <input type="button" class="increase" value="+">
                        </td>
                        <td><div class="p-sum">￥<span class="onlySum">0</span></div></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>
            </div>


            <div class="settlement">
                <div class="ww">
                    <div id="calculate">结算</div>
                    <div class="price-sum">
                        总价：￥<span class="sum-price"></span>
                    </div>
                </div>

                <div class="submit">
                    <a href="javascript:void(0)" id="submit-order">提交订单</a>
                </div>
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
