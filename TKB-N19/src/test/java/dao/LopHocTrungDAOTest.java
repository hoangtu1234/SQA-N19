package dao;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTrungDAOTest {
    LopHocTrungDAO lhtdao = new LopHocTrungDAO();
    DangKyHocDAO dkdao = new DangKyHocDAO();

    @Test
    void getLHPTrungTestTrue() {
        ArrayList<DangKyHoc> listDK = new ArrayList<>();
        SinhVienKhoa svk = new SinhVienKhoa();
        svk.setId(1);
        //
        KiHoc kh = new KiHoc();
        kh.setId(4);
        //
        MonHocKiHoc mhkh = new MonHocKiHoc();
        mhkh.setId(1);
        mhkh.setKihoc(kh);
        ///
        LopHocPhan lhp = new LopHocPhan();
        lhp.setId(3);
        lhp.setMonHocKiHoc(mhkh);
        //
        DangKyHoc dk = new DangKyHoc();
        dk.setSvk(svk);
        dk.setLopHocPhan(lhp);
        //
        listDK.add(dk);

        //tao dang ki hoc thu hai
        MonHocKiHoc mhkh2 = new MonHocKiHoc();
        mhkh2.setId(2);
        mhkh2.setKihoc(kh);
        LopHocPhan lhp2 = new LopHocPhan();
        lhp2.setId(9);
        lhp2.setMonHocKiHoc(mhkh2);
        DangKyHoc dk2 = new DangKyHoc();
        dk2.setSvk(svk);
        dk2.setLopHocPhan(lhp2);
        listDK.add(dk2);
        int idLHP = 5;
        try{
            DAO.con.setAutoCommit(false);
            String ok = dkdao.luuDKcuaSV(listDK);
            Assertions.assertEquals("Thanhcong",ok);

            //lay ra kiem tra
            ArrayList<DangKyHoc> listDKnew = dkdao.getListDangKy(svk.getId(), kh.getId());
            Assertions.assertNotNull(listDKnew);
            Assertions.assertEquals(2, listDKnew.size());
            Assertions.assertEquals(svk.getId(), listDKnew.get(0).getSvk().getId());
            Assertions.assertEquals(lhp.getId(), listDKnew.get(0).getLopHocPhan().getId());
            Assertions.assertEquals(svk.getId(), listDKnew.get(1).getSvk().getId());
            Assertions.assertEquals(lhp2.getId(), listDKnew.get(1).getLopHocPhan().getId());
            //
            ArrayList<LopHocTrung> listLH = lhtdao.getLHPTrung(listDKnew,idLHP);
            Assertions.assertNotNull(listLH);
            Assertions.assertEquals(1,listLH.size());
            Assertions.assertEquals(idLHP,listLH.get(0).getIdLHP2());
            boolean check = false;
            for(DangKyHoc dangKyHoc: listDK){
                if(dangKyHoc.getLopHocPhan().getId() == listLH.get(0).getIdLHP1() ) check = true;
            }
            Assertions.assertTrue(check);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
    @Test
    void getLHPTrung_testListDKEmpty(){
        ArrayList<DangKyHoc> listDK = new ArrayList<>();
        int idLHP = 5;
        ArrayList<LopHocTrung> listLH = lhtdao.getLHPTrung(listDK,idLHP);
        Assertions.assertEquals(0,listLH.size());
    }
    @Test
    void getLHPTrung_testLHPNotExist(){
        ArrayList<DangKyHoc> listDK = new ArrayList<>();
        SinhVienKhoa svk = new SinhVienKhoa();
        svk.setId(1);
        //
        KiHoc kh = new KiHoc();
        kh.setId(4);
        //
        MonHocKiHoc mhkh = new MonHocKiHoc();
        mhkh.setId(1);
        mhkh.setKihoc(kh);
        ///
        LopHocPhan lhp = new LopHocPhan();
        lhp.setId(3);
        lhp.setMonHocKiHoc(mhkh);
        //
        DangKyHoc dk = new DangKyHoc();
        dk.setSvk(svk);
        dk.setLopHocPhan(lhp);
        //
        listDK.add(dk);

        //tao dang ki hoc thu hai
        MonHocKiHoc mhkh2 = new MonHocKiHoc();
        mhkh2.setId(2);
        mhkh2.setKihoc(kh);
        LopHocPhan lhp2 = new LopHocPhan();
        lhp2.setId(9);
        lhp2.setMonHocKiHoc(mhkh2);
        DangKyHoc dk2 = new DangKyHoc();
        dk2.setSvk(svk);
        dk2.setLopHocPhan(lhp2);
        listDK.add(dk2);
        int idLHP = 100;
        try{
            DAO.con.setAutoCommit(false);
            String ok = dkdao.luuDKcuaSV(listDK);
            Assertions.assertEquals("Thanhcong",ok);

            //lay ra kiem tra
            ArrayList<DangKyHoc> listDKnew = dkdao.getListDangKy(svk.getId(), kh.getId());
            Assertions.assertNotNull(listDKnew);
            Assertions.assertEquals(2, listDKnew.size());
            Assertions.assertEquals(svk.getId(), listDKnew.get(0).getSvk().getId());
            Assertions.assertEquals(lhp.getId(), listDKnew.get(0).getLopHocPhan().getId());
            Assertions.assertEquals(svk.getId(), listDKnew.get(1).getSvk().getId());
            Assertions.assertEquals(lhp2.getId(), listDKnew.get(1).getLopHocPhan().getId());
            //
            ArrayList<LopHocTrung> listLH = lhtdao.getLHPTrung(listDKnew,idLHP);
            Assertions.assertEquals(0,listLH.size());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    void getLHPTrung_testlistDKEmpty_LhpNotExist(){
        ArrayList<DangKyHoc> listDK = new ArrayList<>();
        int idLHP = 100;
        ArrayList<LopHocTrung> listLHT = lhtdao.getLHPTrung(listDK,idLHP);
        Assertions.assertEquals(0,listLHT.size());
     }
}