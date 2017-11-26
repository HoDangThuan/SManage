package srt.studentmanage.model.objects;

import java.util.ArrayList;

/**
 * Created by Admin on 11/25/2017.
 */

public class BangDiem {
    private double diemTB;
    private int soTCTichLuy;
    private String xepHang;

    private ArrayList<DiemHocKy> diemHocKies;

    public BangDiem() {
    }

    public BangDiem(double diemTB, int soTCTichLuy, String xepHang) {
        this.diemTB = diemTB;
        this.soTCTichLuy = soTCTichLuy;
        this.xepHang = xepHang;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public int getSoTCTichLuy() {
        return soTCTichLuy;
    }

    public void setSoTCTichLuy(int soTCTichLuy) {
        this.soTCTichLuy = soTCTichLuy;
    }

    public String getXepHang() {
        return xepHang;
    }

    public void setXepHang(String xepHang) {
        this.xepHang = xepHang;
    }

    public ArrayList<DiemHocKy> getDiemHocKies() {
        return diemHocKies;
    }

    public void setDiemHocKies(ArrayList<DiemHocKy> diemHocKies) {
        this.diemHocKies = diemHocKies;
    }
}
