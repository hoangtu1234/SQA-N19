package dao;

import model.KiHoc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KiHocDAOTest {
    KiHocDAO dao = new KiHocDAO();

    @Test
    void getKiHocDangKiTest() {
        ArrayList<KiHoc> list = dao.getKiHocDangKi();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(3,list.size());
    }
}