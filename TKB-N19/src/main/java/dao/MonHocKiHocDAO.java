package dao;

import model.KiHoc;
import model.MonHoc;
import model.MonHocKiHoc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonHocKiHocDAO extends DAO{
    public ArrayList<MonHocKiHoc> getListMonHocKiHoc(int idKhoa, int idKiHoc){
        ArrayList<MonHocKiHoc> listMonHocKiHoc = new ArrayList<>();
        String sql = "{call MHmaSVduocDK(?,?)}";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, idKhoa);
            cs.setInt(2,idKiHoc);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                MonHocKiHoc monHocKiHoc = new MonHocKiHoc();
                monHocKiHoc.setId(rs.getInt("idmonhockihoc"));

                MonHoc monHoc = new MonHoc();
                monHoc.setId(rs.getInt("idmonhoc"));
                monHoc.setTen(rs.getString("tenmon"));
                monHoc.setSoTC(rs.getInt("sotinchi"));
                monHocKiHoc.setMonHoc(monHoc);

                KiHoc kiHoc = new KiHoc();
                kiHoc.setId(idKiHoc);
                monHocKiHoc.setKihoc(kiHoc);

                listMonHocKiHoc.add(monHocKiHoc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMonHocKiHoc;
    }

//    public static void main(String[] args) {
//        ArrayList<MonHocKiHoc> list = new MonHocKiHocDAO().getListMonHocKiHoc(1,4);
//
//    }
}
