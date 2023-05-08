package dao;

import model.KiHoc;
import model.LopHocPhan;
import model.MonHoc;
import model.MonHocKiHoc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LopHocPhanDAO extends DAO{
    public ArrayList<LopHocPhan> getLHPchoSVdangki( int idMHKH){
        ArrayList<LopHocPhan> kq = new ArrayList<LopHocPhan>();
        String sql = "{call LHPchoSVdangki(?)}";// su dung stored procedure
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, idMHKH);
            ResultSet rs = cs.executeQuery();

            while(rs.next()){

                LopHocPhan lhp = new LopHocPhan();
                lhp.setId(rs.getInt("idlophocphan"));
                lhp.setTen(rs.getString("tenlophocphan"));
                lhp.setSiSoToiDa(rs.getInt("sisotoida"));
                lhp.setSiSoThucTe(rs.getInt("sisothuc"));

                MonHocKiHoc mhkh = new MonHocKiHoc();
                mhkh.setId(idMHKH);

                MonHoc mh = new MonHoc();
                mh.setId(rs.getInt("idmonhoc"));
                mh.setTen(rs.getString("tenmonhoc"));
                mh.setSoTC(rs.getInt("sotinchi"));
                mhkh.setMonHoc(mh);

                KiHoc kh = new KiHoc();
                kh.setId(rs.getInt("idkihoc"));
                mhkh.setKihoc(kh);
                lhp.setMonHocKiHoc(mhkh);
                kq.add(lhp);
            }
        }catch(Exception e){
            e.printStackTrace();
            kq = null;
        }
        return kq;
    }
}
