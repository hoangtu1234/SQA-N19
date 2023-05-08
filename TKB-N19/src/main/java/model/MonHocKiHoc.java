package model;

public class MonHocKiHoc {
    private int id;
    private MonHoc monHoc;
    private KiHoc kihoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public KiHoc getKihoc() {
        return kihoc;
    }

    public void setKihoc(KiHoc kihoc) {
        this.kihoc = kihoc;
    }

    public MonHocKiHoc() {
    }
}
