package dao;

import model.LopHocPhan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LopHocPhanDAOTest {
    LopHocPhanDAO dao = new LopHocPhanDAO();
    @Test
    void getLHPchoSVdangkiTrue() {
        int idMHKH  = 1;
        ArrayList<LopHocPhan> list = dao.getLHPchoSVdangki(idMHKH);
        Assertions.assertNotNull(list);
        Assertions.assertEquals(4,list.size());
        Assertions.assertEquals(idMHKH,list.get(0).getMonHocKiHoc().getId());
    }
    @Test
    void getLHPchoSVdangki_MHKHNotExist(){
        int idMHKH = 100;
        ArrayList<LopHocPhan> list = dao.getLHPchoSVdangki(idMHKH);
        Assertions.assertEquals(0,list.size());
    }
    @Test
    void getLHPchoSVdangki_MHKHkomoDK(){
        int idMHKH = 7;
        ArrayList<LopHocPhan> list = dao.getLHPchoSVdangki(idMHKH);
        Assertions.assertEquals(0,list.size());
    }
    @Test
    void getLHPchoSVdangki_MHKHNull(){
        int idMHKH = -10;
        ArrayList<LopHocPhan> list = dao.getLHPchoSVdangki(idMHKH);
        Assertions.assertEquals(0,list.size());
    }
}