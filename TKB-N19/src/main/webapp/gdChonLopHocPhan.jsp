<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chọn lớp học phần</title>

    <title>Trang chu sinh vien</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/bootsrap.min.css">
    <link rel="stylesheet" href="js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="js/table.js">
</head>
<body>
<c:if test = "${sessionScope.sinhvien eq null}">
    <c:redirect url="gdDangNhap.jsp?err=timeout"/>
</c:if>

<c:if test = "${err eq 'trung'}">
    <h4 color="red">Lop hoc phan da trung</h4>
</c:if>

<h1 style="text-align:center">Chọn lớp học phần cho môn <i style="color: aqua">${listLopHocPhan[0].monHocKiHoc.monHoc.ten}</i></h1>
<table class="tbl-header">
    <tr>
        <th>TT</th>
        <th>Mã lớp</th>
        <th>Tên lớp học phần</th>
        <th>Sĩ số tối đa</th>
        <th>Sĩ số thực</th>
        <th>Xem lịch</th>
        <th>Chọn</th>

    </tr>
</table>
<table class="tbl-content">
    <c:forEach var="lhp" items="${sessionScope.listLopHocPhan}" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${lhp.id}</td>
            <td>${lhp.ten}</td>
            <td>${lhp.siSoToiDa}</td>
            <td>${lhp.siSoThucTe}</td>
            <td><a style="color: #b02a37" href="${pageContext.request.contextPath}/lichHocServlet?idlhp=${lhp.id}&tenlhp=${lhp.ten}">click để xem</a></td>
            <td><a style="color: #b02a37" href="${pageContext.request.contextPath}/dangKyHocServlet?action=them&idlhp=${lhp.id}&idmhkh=${lhp.monHocKiHoc.id}">(Chọn)</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
