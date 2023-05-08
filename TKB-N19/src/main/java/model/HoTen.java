package model;

public class HoTen {
    private String hoDem;
    private String ten;

    public HoTen() {
    }

    public String getTenDayDu(){
        return hoDem+" "+ten;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
