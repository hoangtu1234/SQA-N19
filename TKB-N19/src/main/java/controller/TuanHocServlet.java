package controller;

import dao.KiHocDAO;
import dao.SinhVienKhoaDAO;
import dao.TuanHocDAO;
import model.KiHoc;
import model.SinhVienKhoa;
import model.ThanhVien;
import model.TuanHoc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "tuanHocServlet", value = "/tuanHocServlet")
public class TuanHocServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TuanHocDAO tuanHocDAO = new TuanHocDAO();
        ArrayList<TuanHoc> listTuanHoc = tuanHocDAO.getListTuanhoc();
        request.setAttribute("listTuanHoc",listTuanHoc);

        request.getSession().setAttribute("listTuanHoc",listTuanHoc);


        request.getRequestDispatcher("gdchọnTuan.jsp").forward(request,response);
    }
}
