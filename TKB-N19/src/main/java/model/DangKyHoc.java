package model;

public class DangKyHoc {
    private int id;
    private SinhVienKhoa svk;
    private LopHocPhan lopHocPhan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVienKhoa getSvk() {
        return svk;
    }

    public void setSvk(SinhVienKhoa svk) {
        this.svk = svk;
    }

    public LopHocPhan getLopHocPhan() {
        return lopHocPhan;
    }

    public void setLopHocPhan(LopHocPhan lopHocPhan) {
        this.lopHocPhan = lopHocPhan;
    }

    public DangKyHoc() {
    }
}
