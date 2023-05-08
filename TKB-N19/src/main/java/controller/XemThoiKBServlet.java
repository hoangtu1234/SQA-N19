package controller;

import dao.LichHocDAO;
import model.DangKyHoc;
import model.LichHoc;
import model.SinhVienKhoa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="XemTKBServlet", value = "/xemTKBServlet")
public class XemThoiKBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        LichHocDAO lichHocDAO = new LichHocDAO();
        int tuanID = Integer.parseInt(request.getParameter("tuan"));
        ArrayList<LichHoc> listLichHoc = new ArrayList<>();
        ArrayList<LichHoc> listLichHocFiltered = new ArrayList<>();
        ArrayList<DangKyHoc> listDK = null;
        for (DangKyHoc dangKyHoc : listDK = (ArrayList<DangKyHoc>) request.getSession().getAttribute("listDangKyHoc")) {

            listLichHoc = lichHocDAO.getListLichHoc(dangKyHoc.getLopHocPhan().getId());
            for (LichHoc a : listLichHoc) {
                if (a.getTuanHoc().getId() == tuanID) {
                    listLichHocFiltered.add(a);
                }
            }
        }
        request.setAttribute("listLichHoc",listLichHocFiltered);
        request.getRequestDispatcher("gdLichHoc.jsp").forward(request,response);
    }
}
