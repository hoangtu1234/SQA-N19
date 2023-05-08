package dao;

import model.Khoa;
import model.SinhVien;
import model.SinhVienKhoa;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SinhVienKhoaDAO extends DAO{
    /**
     * lay danh sach cac khoa/nganh ma sinh vien dang hoc de chon dang ki hoc dau hoc ki
     * @param idSV: id cua sinh vien
     * @return danh sach cacs doi tuong SinhvienKhoa
     */
    public ArrayList<SinhVienKhoa> getNganhcuaSV(int idSV){
        ArrayList<SinhVienKhoa> list = new ArrayList<>();
        String sql = "{call nganhcuaSV(?)}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1,idSV);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                SinhVienKhoa sinhVienKhoa = new SinhVienKhoa();
                sinhVienKhoa.setId(rs.getInt("idsvk"));

                SinhVien sinhVien = new SinhVien();
                sinhVien.setMaSv(rs.getString("masv"));
                sinhVien.setId(idSV);

                Khoa khoa = new Khoa();
                khoa.setId(rs.getInt("idkhoa"));
                khoa.setTen(rs.getString("tenkhoa"));

                sinhVienKhoa.setKhoa(khoa);
                sinhVienKhoa.setSinhVien(sinhVien);
                list.add(sinhVienKhoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;
    }

//    public static void main(String[] args) {
//        SinhVienKhoaDAO sinhVienKhoaDAO = new SinhVienKhoaDAO();
//        ArrayList<SinhVienKhoa> list = sinhVienKhoaDAO.getNganhcuaSV(1);
//        for(SinhVienKhoa sinhVienKhoaDAO1:list){
//            System.out.println(sinhVienKhoaDAO1);
//        }
//    }
}
