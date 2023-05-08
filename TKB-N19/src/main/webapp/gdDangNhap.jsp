<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dang nhap</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/bootsrap.min.css">
    <link rel="stylesheet" href="js/bootstrap.bundle.min.js">
</head>
<body>


<c:if test = "${param.err eq 'fail'}">
    <h4 color="red">Sai tên đăng nhập/mật khẩu!</h4>
</c:if>
<c:if test = "${param.err eq 'upfail'}">
    <h4 color="red">tên đăng nhập/mật khẩu > 6 ky tu </h4>
</c:if>

<div class="container">
    <div class="row">
                <div class="card-body p-4 p-sm-5">
                    <h5 class="card-title text-center mb-5 fw-light fs-5">Đăng Nhập</h5>
                    <c:if test = "${param.err eq 'timeout'}">
                        <strong>Hết phiên làm việc. Làm ơn đăng nhập lại!</strong>
                    </c:if>
                    <form style="margin-top: 30px" name="dangnhap" action="dangNhapServlet" method="post">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInput" name="username" placeholder="nhập tài khoản" required>
                            <label for="floatingInput">Tài khoản</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="nhập mật khẩu" required>
                            <label for="floatingPassword">Mật khẩu</label>
                        </div>
                        <div class="d-grid" style="margin-top: 30px">
                            <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">Đăng nhập</button>
                        </div>
                        <hr class="my-4">

                    </form>
                </div>
    </div>
</div>
</body>
</html>