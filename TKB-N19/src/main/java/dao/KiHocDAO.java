package dao;

import model.HocKi;
import model.KiHoc;
import model.NamHoc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KiHocDAO extends DAO {
    /**
     * Lay danh sach cac hoc ki dang mo cho sinh vien chon dang ki hoc
     *
     * @return danh sach ki hoc dang mo dang ki
     */
    public ArrayList<KiHoc> getKiHocDangKi() {
        ArrayList<KiHoc> list = new ArrayList<>();
        String sql = "{call kiDangDK()}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                KiHoc kiHoc = new KiHoc();
                kiHoc.setId(rs.getInt("idkihoc"));

                NamHoc namHoc = new NamHoc();
                namHoc.setId(rs.getInt("idnamhoc"));
                namHoc.setTen(rs.getString("namhoc"));

                HocKi hocKi = new HocKi();
                hocKi.setId(rs.getInt("idhocki"));
                hocKi.setTen(rs.getString("hocki"));

                kiHoc.setHocKi(hocKi);
                kiHoc.setNamHoc(namHoc);

                list.add(kiHoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
