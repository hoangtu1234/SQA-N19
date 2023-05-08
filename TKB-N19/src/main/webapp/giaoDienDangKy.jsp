<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký học</title>
    <style>
        .tdphai {
            padding-left: 40px;
        }

        .table2 {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        .table2 td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        .table2 tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
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
<h1 style="text-align: center;">Đăng ký học</h1>
<table class="tbl-header" style="margin:auto;">
    <tr>
        <td>Mã sinh viên:</td>

        <td class="tdphai">${sessionScope.sinhVienKhoa.id}</td>
    </tr>
    <tr>
        <td>Họ tên:</td>

        <td class="tdphai">${sessionScope.sinhvien.hoTen.tenDayDu}</td>
    </tr>
    <tr>
        <td>Ngành học:</td>

        <td class="tdphai">${sessionScope.sinhVienKhoa.khoa.ten}</td>
    </tr>
    <tr>
        <td><strong>Các lớp đã đăng ký</strong></td>
        <td style="padding-left:500px">Tổng số tín chỉ: ${soTC}</td>
    </tr>
</table>

<h3 style="color: red">${errorMessage}</h3>

    <div class="tbl-header">
        <table>
            <thead>
            <tr>
                <th>TT</th>
                <th>Mã môn học</th>
                <th>Tên môn học</th>
                <th>Tên lớp học phần</th>
                <th>Số Tín</th>
                <th>Xem lịch</th>
                <th>Sửa</th>
                <th>Xóa</th>
            </tr>
            </thead>

        </table>

    </div>
<table class="tbl-content">
    <c:forEach var="dangKyHoc" items="${sessionScope.listDangKyHoc}" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${dangKyHoc.lopHocPhan.monHocKiHoc.monHoc.id}</td>
            <td>${dangKyHoc.lopHocPhan.monHocKiHoc.monHoc.ten}</td>
            <td>${dangKyHoc.lopHocPhan.ten}</td>
            <td>${dangKyHoc.lopHocPhan.monHocKiHoc.monHoc.soTC}</td>
            <td>
                <a class="btn-link" style="color: #b02a37" href="${pageContext.request.contextPath}/lichHocServlet?idlhp=${dangKyHoc.lopHocPhan.id}&tenlhp=${dangKyHoc.lopHocPhan.ten}">(click
                    để xem)</a></td>
            <td>
                <a class="btn-link" style="color: #b02a37" href="${pageContext.request.contextPath}/chonLopHocPhanServlet?idmhkh=${dangKyHoc.lopHocPhan.monHocKiHoc.id}">(click
                    để sửa)</a></td>
            <td>
                <a class="btn-link" style="color: #b02a37" href="${pageContext.request.contextPath}/dangKyHocServlet?action=xoa&idlhp=${dangKyHoc.lopHocPhan.id}">(click
                    để xóa)</a></td>
        </tr>
    </c:forEach>

</table>

<div style="display:flex; justify-content:space-around; margin-top:50px">
    <form action="gdChinhSinhVien.jsp" method="post">
        <input type="submit" value="Về trang chủ">
    </form>

    <form action="chonMonHocServlet" method="post">
        <input type="submit" value="Tiếp tục">
    </form>
     <form action="tuanHocServlet" method="post">
            <input type="submit" value="Xem TKB">
        </form>

    <form action="luuDangKyServlet" method="post">
        <input type="submit" value="Lưu đăng ký">
    </form>
</div>


</body>
</html>
