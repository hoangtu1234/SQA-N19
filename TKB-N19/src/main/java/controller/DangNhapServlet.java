package controller;

import dao.ThanhVienDAO;
import model.ThanhVien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DangNhapServlet", value = "/dangNhapServlet")
public class DangNhapServlet extends HttpServlet {
    private ThanhVien thanhVien;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        ThanhVien thanhVien = new ThanhVien();
        thanhVien.setUserName(userName);
        thanhVien.setPassword(password);
        boolean up = checkUP(userName,password);
        boolean ok = checkUser(thanhVien);
        if(up){
            if(ok && (thanhVien.getVaiTro().equalsIgnoreCase("sinh viên"))){
                request.getSession().setAttribute("sinhvien",thanhVien);
                response.sendRedirect("gdChinhSinhVien.jsp");
            }else{
                response.sendRedirect("gdDangNhap.jsp?err=fail");
            }
        }else{
            response.sendRedirect("gdDangNhap.jsp?err=upfail");
        }


    }

    private boolean checkUser(ThanhVien thanhVien) {
        ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
        return thanhVienDAO.kiemTraDangNhap(thanhVien);
    }

    private boolean checkUP(String userName, String password) {
        if(userName.length() < 6 || password.length() <6) return false;
        return true;
    }
}
