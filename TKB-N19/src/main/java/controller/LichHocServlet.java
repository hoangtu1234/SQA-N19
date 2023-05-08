package controller;

import dao.LichHocDAO;
import model.LichHoc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LichHocServlet", value = "/lichHocServlet")
public class LichHocServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LichHocDAO lichHocDAO = new LichHocDAO();
        ArrayList<LichHoc> listLichHoc = lichHocDAO.getListLichHoc(Integer.parseInt(request.getParameter("idlhp")));

        request.setAttribute("listLichHoc",listLichHoc);
        String tenLopHocPhan = request.getParameter("tenlhp");
        request.setAttribute("tenLopHocPhan",tenLopHocPhan);
        request.getRequestDispatcher("gdLichHoc.jsp").forward(request,response);
    }
}
