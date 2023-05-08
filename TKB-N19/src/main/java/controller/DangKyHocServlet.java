package controller;

import dao.DangKyHocDAO;
import dao.LopHocPhanDAO;
import dao.LopHocTrungDAO;
import dao.SinhVienKhoaDAO;
import logic.Logic;
import model.DangKyHoc;
import model.LopHocPhan;
import model.LopHocTrung;
import model.SinhVienKhoa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DangKyHocServlet", value = "/dangKyHocServlet")
public class DangKyHocServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<DangKyHoc> listDK = null;
        SinhVienKhoa svk = null;
        HttpSession session = request.getSession();
        //kiem tra cach trang nay bi goi
        String action = request.getParameter("action");
        if(action==null){// action = null tuc la trang nay bi goi tu trang chon nganh chon ki
            DangKyHocDAO dangKyHocDAO = new DangKyHocDAO();
            int idSVK = Integer.parseInt(request.getParameter("nganh"));
            int idKihoc = Integer.parseInt(request.getParameter("ki"));

            //set vao session de lat nua them dang ky can 2 thong tin nay
            session.setAttribute("idSVK", idSVK);
            session.setAttribute("idKihoc", idKihoc);

            ArrayList<SinhVienKhoa> listSinhVienKhoa = (ArrayList<SinhVienKhoa>)session.getAttribute("listSVK");
            for(SinhVienKhoa svkhoa :listSinhVienKhoa){
                if(svkhoa.getId()==idSVK){
                    svk= svkhoa;
                    session.setAttribute("idKhoa",svk.getKhoa().getId());
                    break;
                }
            }
            listDK = dangKyHocDAO.getListDangKy(idSVK,idKihoc);

        }else if (action.equalsIgnoreCase("them")) {// goi tu trang chon lop hoc phan
            listDK = (ArrayList<DangKyHoc>)session.getAttribute("listDangKyHoc");
            if(listDK == null) listDK = new ArrayList<DangKyHoc>();
            svk = (SinhVienKhoa) session.getAttribute("sinhVienKhoa");
            ArrayList<LopHocPhan> listLHP = (ArrayList<LopHocPhan>)session.getAttribute("listLopHocPhan");
            int idLHP = Integer.parseInt(request.getParameter("idlhp"));
            boolean daTontaiLHP = checkExitLHP(listDK,idLHP); ;
            boolean trungLHP = checkTrungLHP(listDK,idLHP);

//            for(DangKyHoc dk:listDK){
//                if(dk.getLopHocPhan().getId() == idLHP){
//                    daTontaiLHP = true;
//                    break;
//                }
//            }\
            if(!trungLHP){
                int idmhkh=Integer.parseInt(request.getParameter("idmhkh"));
                request.getSession().setAttribute("err","trung");
                request.getRequestDispatcher(String.format("/chonLopHocPhanServlet?idmhkh=%d",idmhkh)).forward(request,response);
                return;
            }else{
                request.getSession().setAttribute("err","non");
            }

            if(!daTontaiLHP && trungLHP){
                //tao dang ki moi
                DangKyHoc dkMoi = null;
                for (LopHocPhan lhp : listLHP)
                    if (lhp.getId() == idLHP) {
                        dkMoi = new DangKyHoc();
                        dkMoi.setLopHocPhan(lhp);
                        dkMoi.setSvk(svk);
                    }
                //kiem tra co phai sua dang ki cu khong
                int index = 0;
                for (DangKyHoc dk : listDK) {
                    if (dk.getLopHocPhan().getMonHocKiHoc().getId() == dkMoi
                            .getLopHocPhan().getMonHocKiHoc().getId()) {
                        listDK.remove(dk);
                        break;
                    }
                    index++;
                }
                //them dang ki moi vao danh sach
                listDK.add(index, dkMoi);
            }
        }else if (action.equalsIgnoreCase("xoa")) {// goi tu trang dang ki, de xoa
            listDK = (ArrayList<DangKyHoc>)session.getAttribute("listDangKyHoc");
            if (listDK == null)
                listDK = new ArrayList<DangKyHoc>();
            svk = (SinhVienKhoa) session.getAttribute("sinhVienKhoa");
            int idLHP = Integer.parseInt(request.getParameter("idlhp"));
            for (DangKyHoc dk : listDK)
                if (dk.getLopHocPhan().getId() == idLHP) {
                    listDK.remove(dk);
                    break;
                }
        }

        session.setAttribute("sinhVienKhoa",svk);
        session.setAttribute("listDangKyHoc",listDK);
        request.setAttribute("soTC", Logic.tongSoTinChi(listDK));
        request.getRequestDispatcher("giaoDienDangKy.jsp").forward(request,response);
    }

    private boolean checkTrungLHP(ArrayList<DangKyHoc> listDK, int idLHP) {
        LopHocTrungDAO lopHocTrungDAO = new LopHocTrungDAO();
        ArrayList<LopHocTrung> list = lopHocTrungDAO.getLHPTrung(listDK,idLHP);
        if(list.isEmpty()) return true;
        return false;
    }

    boolean checkExitLHP(ArrayList<DangKyHoc> listDK, int idLHP) {
        for(DangKyHoc dk:listDK){
            if(dk.getLopHocPhan().getId() == idLHP){
               return true;
            }
        }
        return false;
    }


}
