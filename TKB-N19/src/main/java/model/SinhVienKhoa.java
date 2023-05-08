package model;

public class SinhVienKhoa {
    private int id;
    private String nienKhoa;
    private int dangHoc;
    private Khoa khoa;
    private SinhVien sinhVien;

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public int getDangHoc() {
        return dangHoc;
    }

    public void setDangHoc(int dangHoc) {
        this.dangHoc = dangHoc;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public SinhVienKhoa() {
    }
}
