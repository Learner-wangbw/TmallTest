<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>模仿天猫-后台</title>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->

    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/listCategory">Tmall</a>
        </div>
    </nav>

    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a href="${pageContext.request.contextPath}/admin/listCategory"><i class="fa fa-bars"></i> 分类管理</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/listUser"><i class="fa fa-user"></i> 用户管理</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/listOrder"><i class="fa fa-list-alt"></i> 订单管理</a>
                </li>
                <li>
                    <a class="active-menu" href="${pageContext.request.contextPath}/admin/listLink"><i class="fa fa-link"></i> 推荐链接管理</a>
                </li>
            </ul>
        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        推荐链接管理
                        <small></small>
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            推荐链接表
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>链接ID</th>
                                        <th>链接显示文本</th>
                                        <th>链接连接地址</th>
                                        <%--<th>修改</th>--%>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${links}" var="l">
                                        <tr>
                                            <td>${l.id}</td>
                                            <td>${l.text}</td>
                                            <td>${l.link}</td>
                                            <%--<td><a href="${pageContext.request.contextPath}/admin/editLink?id=${l.id}"><span class="glyphicon glyphicon-edit"></span></a></td>--%>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>

        </div>
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${pageContext.request.contextPath}./assets/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<!-- Custom Js -->
<script src="${pageContext.request.contextPath}/assets/js/custom-scripts.js"></script>


</body>
</html>
