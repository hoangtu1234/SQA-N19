package controller;

import dao.MonHocKiHocDAO;
import model.MonHocKiHoc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ChonMonHocServlet", value = "/chonMonHocServlet")
public class ChonMonHocServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idKhoa = (int)session.getAttribute("idKhoa");
        int idKiHoc = (int)session.getAttribute("idKihoc");

        ArrayList<MonHocKiHoc> listMonHocKiHoc  = new MonHocKiHocDAO().getListMonHocKiHoc(idKhoa, idKiHoc);
        request.setAttribute("listMonHocKiHoc",listMonHocKiHoc);
        request.getRequestDispatcher("gdChonMon.jsp").forward(request,response);
    }
}
