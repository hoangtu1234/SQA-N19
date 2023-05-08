<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chọn môn học</title>
    <title>Trang chu sinh vien</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/bootsrap.min.css">
    <link rel="stylesheet" href="js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="js/table.js">

</head>
<body>
<c:if test="${sessionScope.sinhvien eq null}">
    <c:redirect url="gdDangNhap.jsp?err=timeout"/>
</c:if>
<h1 style="text-align:center">Chọn môn học</h1>
<table class="tbl-header">
    <thead>
    <tr>
        <th>TT</th>
        <th>Mã môn học</th>
        <th>Tên môn học</th>
        <th>Số tín chỉ</th>
        <th>Chọn</th>

    </tr>
    </thead>
</table>
<table class="tbl-content">
    <c:forEach var="mhkh" items="${listMonHocKiHoc}" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${mhkh.monHoc.id}</td>
            <td>${mhkh.monHoc.ten}</td>
            <td>${mhkh.monHoc.soTC}</td>
            <td><a style="color: #b02a37" href="${pageContext.request.contextPath}/chonLopHocPhanServlet?idmhkh=${mhkh.id}">click</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
