package model;

public class LopHocPhan {
    private int id;
    private String ten;
    private int siSoToiDa;
    private int siSoThucTe;
    private String moTa;
    private MonHocKiHoc monHocKiHoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSiSoToiDa() {
        return siSoToiDa;
    }

    public void setSiSoToiDa(int siSoToiDa) {
        this.siSoToiDa = siSoToiDa;
    }

    public int getSiSoThucTe() {
        return siSoThucTe;
    }

    public void setSiSoThucTe(int siSoThucTe) {
        this.siSoThucTe = siSoThucTe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public MonHocKiHoc getMonHocKiHoc() {
        return monHocKiHoc;
    }

    public void setMonHocKiHoc(MonHocKiHoc monHocKiHoc) {
        this.monHocKiHoc = monHocKiHoc;
    }

    public LopHocPhan() {
    }
}
