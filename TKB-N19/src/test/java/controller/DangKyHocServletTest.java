package controller;

import dao.DangKyHocDAO;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DangKyHocServletTest {
    DangKyHocServlet servlet = new DangKyHocServlet();

    @Test
    void checkExitLhpTestTrue(){
        ArrayList<DangKyHoc> listDK = new ArrayList<DangKyHoc>();
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

        boolean check = servlet.checkExitLHP(listDK,3);
        Assertions.assertTrue(check);
    }
    @Test
    void checkExitLHP_listDKEmpty(){
        ArrayList<DangKyHoc> listDK = new ArrayList<DangKyHoc>();
        boolean check = servlet.checkExitLHP(listDK,3);
        Assertions.assertFalse(check);
    }

}