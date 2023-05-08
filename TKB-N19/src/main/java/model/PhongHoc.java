package model;

public class PhongHoc {
    private int id;
    private String ten;
    private int sucChua;

    public PhongHoc() {
    }

    public PhongHoc(int id, String ten, int sucChua) {
        this.id = id;
        this.ten = ten;
        this.sucChua = sucChua;
    }

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

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }
}
