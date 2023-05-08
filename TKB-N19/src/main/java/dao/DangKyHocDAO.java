package dao;

import logic.Logic;
import model.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DangKyHocDAO extends DAO{
    /**
     * lay danh sach cac lop hoc phan ma @idSVK da dang ki trong hoc ki @idKihoc
     * @param idSVK: id sinh vien khoa
     * @param idKihoc: id ki hoc
     * @return dang sach dang ki hoc
     */
    public ArrayList<DangKyHoc> getListDangKy(int idSVK, int idKihoc){
        ArrayList<DangKyHoc> list = new ArrayList<>();
        String sql = "{call DKcuaSVtheoKi(?,?)}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, idSVK);
            cs.setInt(2, idKihoc);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                DangKyHoc dangKyHoc = new DangKyHoc();
                dangKyHoc.setId(rs.getInt("id"));

                LopHocPhan lopHocPhan = new LopHocPhan();
                lopHocPhan.setId(rs.getInt("idlhp"));
                lopHocPhan.setTen(rs.getString("tenlhp"));

                MonHocKiHoc monHocKiHoc = new MonHocKiHoc();
                monHocKiHoc.setId(rs.getInt("idmhkh"));

                MonHoc monHoc = new MonHoc();
                monHoc.setId(rs.getInt("idmh"));
                monHoc.setTen(rs.getString("tenmh"));
                monHoc.setSoTC(rs.getInt("sotinchi"));
                monHocKiHoc.setMonHoc(monHoc);

                KiHoc kiHoc = new KiHoc();
                kiHoc.setId(idKihoc);
                monHocKiHoc.setKihoc(kiHoc);

                lopHocPhan.setMonHocKiHoc(monHocKiHoc);
                dangKyHoc.setLopHocPhan(lopHocPhan);

                SinhVienKhoa sinhVienKhoa = new SinhVienKhoa();
                sinhVienKhoa.setId(idSVK);
                sinhVienKhoa.setNienKhoa(rs.getString("nienkhoa"));

                SinhVien sinhVien = new SinhVien();
                sinhVien.setId(rs.getInt("tblSinhVienId"));
                sinhVien.setMaSv(rs.getString("masv"));

                HoTen hoTen = new HoTen();
                hoTen.setHoDem(rs.getString("hodem"));
                hoTen.setTen(rs.getString("tensv"));

                Khoa khoa = new Khoa();
                khoa.setId(rs.getInt("idkhoa"));
                khoa.setTen(rs.getString("tenkhoa"));

                sinhVien.setHoTen(hoTen);
                sinhVienKhoa.setSinhVien(sinhVien);
                sinhVienKhoa.setKhoa(khoa);
                dangKyHoc.setSvk(sinhVienKhoa);

                list.add(dangKyHoc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String luuDKcuaSV(ArrayList<DangKyHoc> listDK){
//        if(Logic.tongSoTinChi(listDK) < 3 ) return "tin<3";
        String kq = null;
        String sqlXoa = "DELETE FROM tbldangkihoc WHERE tblSinhVienKhoaId=? AND tblLopHocPhanId IN "
                + "(SELECT a.id FROM tbllophocphan a, tblmonhockihoc b WHERE b.tblKiHocId = ? AND a.tblMonHocKiHocId=b.id)";
        String sqlThem = "INSERT INTO tbldangkihoc(tblSinhVienKhoaId, tblLopHocPhanId) VALUES(?,?)";
        try{
//            con.setAutoCommit(false);
            //xoa het dang ki cu
            int idSVK = listDK.get(0).getSvk().getId();
            int idKihoc = listDK.get(0).getLopHocPhan().getMonHocKiHoc().getKihoc().getId();
            PreparedStatement psXoa = con.prepareStatement(sqlXoa);
            psXoa.setInt(1, idSVK);
            psXoa.setInt(2, idKihoc);
            psXoa.executeUpdate();

            //them lai dang ki nhu dang ki moi
            for(DangKyHoc dk : listDK){
                PreparedStatement psThem = con.prepareStatement(sqlThem);
                psThem.setInt(1, dk.getSvk().getId());
                psThem.setInt(2, dk.getLopHocPhan().getId());
                psThem.executeUpdate();
            }
//            con.commit();//cmt dong nay ney chay che do JUnit test
            kq="Thanhcong";
        }catch(Exception e){
            try{
//               con.rollback();//cmt dong nay ney chay che do JUnit test
            }catch(Exception ee){
                kq="Thatbai";
                ee.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            try{
//                con.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
            }catch(Exception e){
                kq="Thatbai";
                e.printStackTrace();
            }
        }
        return kq;
    }
}
