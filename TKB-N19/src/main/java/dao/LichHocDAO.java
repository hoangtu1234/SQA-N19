package dao;

import model.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LichHocDAO extends DAO{
    /**
     * lay danh sach cac kip hoc cua lop hoc phan @idLHP
     * @param idLHP: id lop hoc phan
     * @return danh sach cac kip hoc, moi kip hoc tuong ung mot doi tuong lich hoc
     */

    public ArrayList<LichHoc> getListLichHoc(int idLHP){
        ArrayList<LichHoc> list = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{call LichLHP(?)}");
            cs.setInt(1,idLHP);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                LichHoc lichHoc = new LichHoc();
                lichHoc.setId(rs.getInt("id"));
                lichHoc.setTen(rs.getString("ten"));

                LopHocPhan lopHocPhan = new LopHocPhan();
                lopHocPhan.setId(rs.getInt("lhpid"));
                lichHoc.setLopHocPhan(lopHocPhan);

                TuanHoc tuanHoc = new TuanHoc();
                tuanHoc.setTen(rs.getString("tentuan"));
                tuanHoc.setId(rs.getInt("tuanid"));
                lichHoc.setTuanHoc(tuanHoc);

                NgayHoc ngayHoc = new NgayHoc();
                ngayHoc.setTen(rs.getString("tenngay"));
                lichHoc.setNgayHoc(ngayHoc);

                KipHoc kipHoc = new KipHoc();
                kipHoc.setTen(rs.getString("tenkip"));
                lichHoc.setKipHoc(kipHoc);

                GiangVien giangVien = new GiangVien();
                HoTen hoTen = new HoTen();
                hoTen.setTen(rs.getString("tengv"));
                hoTen.setHoDem(rs.getString("hodemgv"));
                giangVien.setHoTen(hoTen);
                lichHoc.setGiangVien(giangVien);

                PhongHoc phongHoc = new PhongHoc();
                phongHoc.setTen(rs.getString("tenphong"));
                lichHoc.setPhongHoc(phongHoc);

                list.add(lichHoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

//    public static void main(String[] args) {
//        ArrayList<LichHoc> list = (new LichHocDAO()).getListLichHoc(1);
//        for(LichHoc item : list){
//            System.out.println(item.getKipHoc().getTen());
//        }
//    }
}
