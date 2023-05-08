<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/header.jsp" %>
    <title>Trang chu sinh vien</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/bootsrap.min.css">
    <link rel="stylesheet" href="js/bootstrap.bundle.min.js">
</head>
<body>

<c:if test="${sessionScope.sinhvien eq null}">
    <c:redirect url="gdDangNhap.jsp?err=timeout"/>
</c:if>

<div class="container">
    <div class="row">

                <div class="card-body p-4 p-sm-5">
                    <div class="logo-img-div"><h1> Trang chủ sinh viên</h1></div>


                        <form style="margin-bottom: 20px" action="chonNganhServlet" method="post">
                            <div class="d-grid">
                                <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">
                                    Tạo Thời Khóa Biểu
                                </button>
                            </div>
                        </form>

                    <hr class="my-4">


                </div>
    </div>
</div>
</body>
</html>