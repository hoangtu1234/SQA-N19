package controller;

import dao.KiHocDAO;
import dao.SinhVienKhoaDAO;
import model.KiHoc;
import model.SinhVien;
import model.SinhVienKhoa;
import model.ThanhVien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ChonNganhServlet", value = "/chonNganhServlet")
public class ChonNganhServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<KiHoc> listKiHoc = getKiHocDangKi();
        request.setAttribute("listKiHoc",listKiHoc);


        ThanhVien sinhVien = (ThanhVien)request.getSession().getAttribute("sinhvien");
        ArrayList<SinhVienKhoa> listSinhVienKhoa = getNganhcusSV(sinhVien);
        request.getSession().setAttribute("listSVK",listSinhVienKhoa);

        request.setAttribute("listSinhVienKhoa",listSinhVienKhoa);

        request.getRequestDispatcher("gdChonNganhHoc.jsp").forward(request,response);
    }

    private ArrayList<SinhVienKhoa> getNganhcusSV(ThanhVien sinhVien) {
        SinhVienKhoaDAO sinhVienKhoaDAO = new SinhVienKhoaDAO();
        return sinhVienKhoaDAO.getNganhcuaSV(sinhVien.getId());
    }

    private ArrayList<KiHoc> getKiHocDangKi() {
        KiHocDAO kiHocDAO = new KiHocDAO();
        return kiHocDAO.getKiHocDangKi();
    }
}
