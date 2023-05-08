package logic;

import model.DangKyHoc;

import java.util.ArrayList;

public class Logic {
    public static int tongSoTinChi(ArrayList<DangKyHoc> list){
        int sum = 0;
        for(DangKyHoc item:list){
            sum+=item.getLopHocPhan().getMonHocKiHoc().getMonHoc().getSoTC();
        }
        return sum;
    }
}
