package dao;

import model.HoTen;
import model.ThanhVien;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThanhVienDAO extends DAO {
    public boolean kiemTraDangNhap(ThanhVien tv){
        boolean kq  = false;
        // check nhung ky tu cua sql injection
        if(tv.getUserName().contains("true")||tv.getUserName().contains("=")||
        tv.getPassword().contains("true")||tv.getPassword().contains("="))return false;
        String sql = "{call kiemtraDN(?,?)}";

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,tv.getUserName());
            cs.setString(2,tv.getPassword());
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                tv.setId(rs.getInt("id"));
                tv.setVaiTro(rs.getString("vaitro"));
                HoTen hoTen = new HoTen();
                hoTen.setTen(rs.getString("ten"));
                hoTen.setHoDem(rs.getString("hodem"));
                tv.setHoTen(hoTen);
                kq=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            kq=false;
        }

        return kq;
    }

//    public static void main(String[] args) {
//        ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
//        ThanhVien thanhVien = new ThanhVien();
//        thanhVien.setUserName("huy2110");
//        thanhVien.setPassword("123");
//        boolean ok = thanhVienDAO.kiemTraDangNhap(thanhVien);
//        if(ok){
//            System.out.println(thanhVien.getHoTen().getTenDayDu());
//            System.out.println(thanhVien.getVaiTro());
//        }else{
//            System.out.println("loi roi");
//        }
//    }
}
