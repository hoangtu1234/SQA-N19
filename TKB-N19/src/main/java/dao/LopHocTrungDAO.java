package dao;

import model.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LopHocTrungDAO extends DAO {
    public ArrayList<LopHocTrung> getLHPTrung(ArrayList<DangKyHoc> listDK, int idLHP){
        ArrayList<LopHocTrung> list = new ArrayList<LopHocTrung>();
        String sql = "{call lopHocTrung(?,?)}";
        for(DangKyHoc dangKyHoc : listDK){
            try {
                CallableStatement cs = con.prepareCall(sql);
                cs.setInt(1, idLHP);
                cs.setInt(2, dangKyHoc.getLopHocPhan().getId());
                ResultSet rs = cs.executeQuery();
                while(rs.next()){
                    LopHocTrung lopHocTrung = new LopHocTrung();
                    lopHocTrung.setId(rs.getInt("id"));
                    lopHocTrung.setIdLHP1(rs.getInt("idLopHocPhan1"));
                    lopHocTrung.setIdLHP2(rs.getInt("idLopHocPhan2"));

                    list.add(lopHocTrung);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;

    }
}
