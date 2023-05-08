package dao;

import model.HocKi;
import model.KiHoc;
import model.NamHoc;
import model.TuanHoc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TuanHocDAO extends DAO{
    public ArrayList<TuanHoc> getListTuanhoc(){
        ArrayList<TuanHoc> listTuanHoc = new ArrayList<>();
        String sql = "{ call tuanHoc()}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                TuanHoc tuanHoc = new TuanHoc();
                tuanHoc.setId(rs.getInt("id"));
                tuanHoc.setTen(rs.getString("ten"));
                tuanHoc.setMoTa(rs.getString("mota"));
                listTuanHoc.add(tuanHoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTuanHoc;

    }
}
