package dao;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DangKyHocDAOTest {
    DangKyHocDAO dao = new DangKyHocDAO();

    @Test
    void getListDangKy_testSVdangki1LHP() {
        int idSVK = 1;
        int idKiHoc = 4;
        ArrayList<DangKyHoc> listDK = dao.getListDangKy(idSVK,idKiHoc);
        Assertions.assertNotNull(listDK);
        //tao them data(idSVK,idKiHoc)

        Assertions.assertEquals(1, listDK.size());

        //
        Assertions.assertEquals(idSVK, listDK.get(0).getSvk().getId());
        Assertions.assertEquals(idKiHoc, listDK.get(0).getLopHocPhan().getMonHocKiHoc().getKihoc().getId());
    }

    @Test
    void getListDangKy_testSVdangkinhieuhon1LHP(){
        int idSVK = 1;
        int idKiHoc = 4;
        ArrayList<DangKyHoc> listDK = dao.getListDangKy(idSVK,idKiHoc);
        Assertions.assertNotNull(listDK);
        Assertions.assertEquals(3,listDK.size());
        Assertions.assertEquals(idSVK,listDK.get(0).getSvk().getId());
        Assertions.assertEquals(idKiHoc,listDK.get(0).getLopHocPhan().getMonHocKiHoc().getKihoc().getId());
    }

    @Test
    void getListDangKy_testKyHoc_svNull(){
        int idSVK = 3;
        int idKiHoc = 4;
        ArrayList<DangKyHoc> listDK = dao.getListDangKy(idSVK,idKiHoc);
        Assertions.assertEquals(0 ,listDK.size());
    }
    @Test
    void getListDangky_testKyHocNull_svExist(){
        int idSVK = 1;
        int idKiHoc = 100;
        ArrayList<DangKyHoc> listDK = dao.getListDangKy(idSVK,idKiHoc);
        Assertions.assertEquals(0 ,listDK.size());
    }
    @Test
    void getListDangKy_testKyHocNull_svNull(){
        int idSvk = 100;
        int idKiHoc = 100;
        ArrayList<DangKyHoc> listDK = dao.getListDangKy(idSvk,idKiHoc);
        Assertions.assertEquals(0,listDK.size());
    }


    @Test
    void luuDKcuaSV_testDangKy1Lop_chuacoDKcu() {
        ArrayList<DangKyHoc> listDK = new ArrayList<DangKyHoc>();
        //tao dang ki hoc thu nhat
        //tao svk
        SinhVienKhoa svk = new SinhVienKhoa();
        svk.setId(1);
        //
        KiHoc kh = new KiHoc();
        kh.setId(4);
        //
        MonHocKiHoc mhkh = new MonHocKiHoc();
        mhkh.setId(1);
        mhkh.setKihoc(kh);
        //
        LopHocPhan lhp = new LopHocPhan();
        lhp.setId(3);
        lhp.setMonHocKiHoc(mhkh);
        //
        DangKyHoc dk = new DangKyHoc();
        dk.setSvk(svk);
        dk.setLopHocPhan(lhp);
        listDK.add(dk);

        try{
            DAO.con.setAutoCommit(false);
            String ok = dao.luuDKcuaSV(listDK);
            Assertions.assertEquals("Thanhcong",ok);

            //lay ra kiem tra
            ArrayList<DangKyHoc> listDKnew = dao.getListDangKy(svk.getId(), kh.getId());
            Assertions.assertNotNull(listDKnew);
            Assertions.assertEquals(1, listDKnew.size());
            Assertions.assertEquals(svk.getId(), listDKnew.get(0).getSvk().getId());
            Assertions.assertEquals(lhp.getId(), listDKnew.get(0).getLopHocPhan().getId());
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
    void luuDangKyCuaSV_testDangKynhieuLop_chuacoDKcu(){
        ArrayList<DangKyHoc> listDK = new ArrayList<>();
        //tao dang ki hoc thu nhat
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

        try{
            DAO.con.setAutoCommit(false);
            String ok = dao.luuDKcuaSV(listDK);
            Assertions.assertEquals("Thanhcong",ok);

            //lay ra kiem tra
            ArrayList<DangKyHoc> listDKnew = dao.getListDangKy(svk.getId(), kh.getId());
            Assertions.assertNotNull(listDKnew);
            Assertions.assertEquals(2, listDKnew.size());
            Assertions.assertEquals(svk.getId(), listDKnew.get(0).getSvk().getId());
            Assertions.assertEquals(lhp.getId(), listDKnew.get(0).getLopHocPhan().getId());
            Assertions.assertEquals(svk.getId(), listDKnew.get(1).getSvk().getId());
            Assertions.assertEquals(lhp2.getId(), listDKnew.get(1).getLopHocPhan().getId());
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
    void luuDangKiSV_testDk1LophocphanTrungmonDkcu_1Lhp(){
        ArrayList<DangKyHoc> listDK = new ArrayList<DangKyHoc>();
        //tao dang ki hoc thu nhat
        //tao svk
        SinhVienKhoa svk = new SinhVienKhoa();
        svk.setId(1);
        //
        KiHoc kh = new KiHoc();
        kh.setId(4);
        //
        MonHocKiHoc mhkh = new MonHocKiHoc();
        mhkh.setId(1);
        mhkh.setKihoc(kh);
        //
        LopHocPhan lhp = new LopHocPhan();
        lhp.setId(3);
        lhp.setMonHocKiHoc(mhkh);
        //
        DangKyHoc dk = new DangKyHoc();
        dk.setSvk(svk);
        dk.setLopHocPhan(lhp);
        listDK.add(dk);

        try{
            DAO.con.setAutoCommit(false);
            String ok = dao.luuDKcuaSV(listDK);
            Assertions.assertEquals("Thanhcong",ok);

            //lay ra kiem tra
            ArrayList<DangKyHoc> listDKnew = dao.getListDangKy(svk.getId(), kh.getId());
            Assertions.assertNotNull(listDKnew);
            Assertions.assertEquals(1, listDKnew.size());
            Assertions.assertEquals(svk.getId(), listDKnew.get(0).getSvk().getId());
            Assertions.assertEquals(lhp.getId(), listDKnew.get(0).getLopHocPhan().getId());
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
    void luuDangKiSV_testDk1LophocphanKhacmonDkcu_1LhpCu(){
        ArrayList<DangKyHoc> listDK = new ArrayList<DangKyHoc>();
        //tao dang ki hoc thu nhat
        //tao svk
        SinhVienKhoa svk = new SinhVienKhoa();
        svk.setId(1);
        //
        KiHoc kh = new KiHoc();
        kh.setId(4);
        //
        MonHocKiHoc mhkh = new MonHocKiHoc();
        mhkh.setId(6);
        mhkh.setKihoc(kh);
        //
        LopHocPhan lhp = new LopHocPhan();
        lhp.setId(21);
        lhp.setMonHocKiHoc(mhkh);
        //
        DangKyHoc dk = new DangKyHoc();
        dk.setSvk(svk);
        dk.setLopHocPhan(lhp);
        listDK.add(dk);
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

        try{
            DAO.con.setAutoCommit(false);
            String ok = dao.luuDKcuaSV(listDK);
            Assertions.assertEquals("Thanhcong",ok);

            //lay ra kiem tra
            ArrayList<DangKyHoc> listDKnew = dao.getListDangKy(svk.getId(), kh.getId());
            Assertions.assertNotNull(listDKnew);
            Assertions.assertEquals(2, listDKnew.size());
            Assertions.assertEquals(svk.getId(), listDKnew.get(0).getSvk().getId());
            Assertions.assertEquals(lhp.getId(), listDKnew.get(0).getLopHocPhan().getId());
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
    void luuDangki_testDktrung(){
        ArrayList<DangKyHoc> listDK = new ArrayList<>();
        //tao dang ki hoc thu nhat
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
        mhkh2.setId(1);
        mhkh2.setKihoc(kh);
        LopHocPhan lhp2 = new LopHocPhan();
        lhp2.setId(3);
        lhp2.setMonHocKiHoc(mhkh2);
        DangKyHoc dk2 = new DangKyHoc();
        dk2.setSvk(svk);
        dk2.setLopHocPhan(lhp2);
        listDK.add(dk2);

        try{
            DAO.con.setAutoCommit(false);
            String ok = dao.luuDKcuaSV(listDK);
            Assertions.assertEquals("Thanhcong",ok);

            //lay ra kiem tra
            ArrayList<DangKyHoc> listDKnew = dao.getListDangKy(svk.getId(), kh.getId());
            Assertions.assertNotNull(listDKnew);
            Assertions.assertEquals(1, listDKnew.size());
            Assertions.assertEquals(svk.getId(), listDKnew.get(0).getSvk().getId());
            Assertions.assertEquals(lhp.getId(), listDKnew.get(0).getLopHocPhan().getId());
            Assertions.assertEquals(svk.getId(), listDKnew.get(1).getSvk().getId());
            Assertions.assertEquals(lhp2.getId(), listDKnew.get(1).getLopHocPhan().getId());
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
    void luuDangki_kocoDangki(){

    }




}