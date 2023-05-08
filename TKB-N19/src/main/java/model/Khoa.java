package model;

import java.util.ArrayList;

public class Khoa {
    private int id;
    private String ten;
    private String moTa;
    private ArrayList<BoMon> listBoMon;

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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public ArrayList<BoMon> getListBoMon() {
        return listBoMon;
    }

    public void setListBoMon(ArrayList<BoMon> listBoMon) {
        this.listBoMon = listBoMon;
    }

    public Khoa() {
    }
}
