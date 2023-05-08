<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xem lịch học</title>
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
<h1 style="text-align:center">Lịch học</h1>
<p style="color:#fff;">Lớp học phẩn: ${tenLopHocPhan}</p>
<table class="tbl-header">
    <tr>
        <th>TT</th>
        <th>Tuần</th>
        <th>Thứ</th>
        <th>Kíp</th>
        <th>Giảng viên</th>
        <th>Phòng học</th>
    </tr>
</table>
<table class="tbl-content">
    <c:forEach var="lichHoc" items="${listLichHoc}" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${lichHoc.tuanHoc.ten}</td>
            <td>${lichHoc.ngayHoc.ten}</td>
            <td>${lichHoc.kipHoc.ten}</td>
            <td>${lichHoc.giangVien.hoTen.hoDem} ${lichHoc.giangVien.hoTen.ten}</td>
            <td>${lichHoc.phongHoc.ten}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
