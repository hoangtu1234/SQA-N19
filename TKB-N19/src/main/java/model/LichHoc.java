package model;

public class LichHoc {
    private int id;
    private String ten;
    private LopHocPhan lopHocPhan;
    private GiangVien giangVien;
    private PhongHoc phongHoc;
    private TuanHoc tuanHoc;
    private NgayHoc ngayHoc;
    private KipHoc kipHoc;
    private String moTa;

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

    public LopHocPhan getLopHocPhan() {
        return lopHocPhan;
    }

    public void setLopHocPhan(LopHocPhan lopHocPhan) {
        this.lopHocPhan = lopHocPhan;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public PhongHoc getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(PhongHoc phongHoc) {
        this.phongHoc = phongHoc;
    }

    public TuanHoc getTuanHoc() {
        return tuanHoc;
    }

    public void setTuanHoc(TuanHoc tuanHoc) {
        this.tuanHoc = tuanHoc;
    }

    public NgayHoc getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(NgayHoc ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public KipHoc getKipHoc() {
        return kipHoc;
    }

    public void setKipHoc(KipHoc kipHoc) {
        this.kipHoc = kipHoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LichHoc() {
    }
}
