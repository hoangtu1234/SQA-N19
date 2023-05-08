package dao;

import model.LichHoc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LichHocDAOTest {
    LichHocDAO dao = new LichHocDAO();

    @Test
    void getListLichHocTrue() {
        int idLHP = 1;
        ArrayList<LichHoc> list = dao.getListLichHoc(idLHP);
        Assertions.assertNotNull(list);
        Assertions.assertEquals(5,list.size());
        Assertions.assertEquals(idLHP,list.get(0).getLopHocPhan().getId());
    }
    @Test
    void getListLichHoc_LHPNotExist(){
        ArrayList<LichHoc> list = dao.getListLichHoc(100);
        Assertions.assertEquals(0,list.size());
    }
    @Test
    void getListLichHoc_LHPKocoLichhoc(){
        ArrayList<LichHoc> list = dao.getListLichHoc(21);
        Assertions.assertEquals(0,list.size());
    }
}