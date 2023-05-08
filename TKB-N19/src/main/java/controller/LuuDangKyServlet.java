package controller;

import dao.DangKyHocDAO;
import logic.Logic;
import model.DangKyHoc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LuuDangKyServlet", value = "/luuDangKyServlet")
public class LuuDangKyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DangKyHoc> listDK = (ArrayList<DangKyHoc>)request.getSession().getAttribute("listDangKyHoc");
        String message="";
        DangKyHocDAO dao = new DangKyHocDAO();
        String kq = dao.luuDKcuaSV(listDK);
        if(kq.equals("Thanhcong")){
            message="Đăng ký thành công!";
        } else if (kq.equals("Thatbai")) {
            message ="Loi dang ky";
        } else if (kq.equals("tin<3")) {
            message = "chua du so tin";
        }
        request.setAttribute("soTC", Logic.tongSoTinChi(listDK));
        request.setAttribute("errorMessage",message);
        request.getRequestDispatcher("giaoDienDangKy.jsp").forward(request,response);
    }
}
