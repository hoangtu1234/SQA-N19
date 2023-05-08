<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chọn ngành học</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/bootsrap.min.css">
    <link rel="stylesheet" href="js/bootstrap.bundle.min.js">
</head>

<body>


<div class="container">
    <div class="row">
                <div class="card-body p-4 p-sm-5">

                    <h1>Chọn tuần học</h1>

                    <form style="margin-top: 30px"  action="xemTKBServlet" method="post">
                        <div class="form-floating mb-3">
                            <select class="form-control" id="floatingInput" name="tuan">
                                <c:forEach var="tuanHoc" items="${listTuanHoc}">
                                    <option value="${tuanHoc.id}">${tuanHoc.moTa}</option>
                                </c:forEach>
                            </select>
                            <label for="floatingInput">Tuan Hoc:</label>
                        </div>

                        <div class="d-grid" style="margin-top: 30px">
                            <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">Xem</button>
                        </div>
                        <hr class="my-4">

                    </form>
                </div>
    </div>
</div>
</body>
</html>
