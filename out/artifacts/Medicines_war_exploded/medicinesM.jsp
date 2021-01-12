<%--
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
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>名称</th>
                        <th>编号</th>
                        <th>分类</th>
                        <th>生产厂家</th>
                        <th>进价</th>
                        <th>售价</th>
                        <th>折扣</th>
                        <th>有效期</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="medicine_list">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $.getJSON("infoServlet", function (result) {
            console.log("result: "+result);
            var mhtml = "";
            alert("success");
            $.each(result, function (i, field) {
                mhtml += "<tr>"
                mhtml += "<td>" + (i+1) + "</td>";
                mhtml += "<td>" + field.med_name + "</td>";
                mhtml += "<td>" + field.med_id + "</td>";
                mhtml += "<td>" + field.med_class + "</td>";
                mhtml += "<td>" + field.factor + "</td>";
                mhtml += "<td>" + field.purchase_price + "</td>";
                mhtml += "<td>" + field.sale_price + "</td>";
                mhtml += "<td>" + field.discount + "</td>";
                mhtml += "<td>" + field.validity + "</td>";
                mhtml += "<td><button type='button' class='btn btn-primary btn-ns' onclick='showEdit(" + field.id +")'>编辑</button><button type='button' class='btn btn-danger btn-ns'>删除</button></td>";
                mhtml += "</tr>"
            })
            $("#medicine_list").html(mhtml);
        })
    })
</script>

<script src="./Dashboard Template for Bootstrap_files/jquery.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/bootstrap.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/holder.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>


</body>
</html>
