package srt.studentmanage.model.objects;

import java.io.Serializable;

/**
 * Created by Admin on 08/31/2017.
 */

public class DiemHocPhan implements Serializable {
    private String maHP;
    private String lopHP;
    private String tenHP;
    private int soTc;
    private int hocKi;
    private String diemChu;
    private double diemSo;
    private boolean tichLuy;
    private String ghiChu;

    public DiemHocPhan() {
    }

    public DiemHocPhan(String maHP, String lopHP, String tenHP, int soTc, int hocKi, String diemChu, double diemSo, boolean tichLuy, String ghiChu) {
        this.maHP = maHP;
        this.lopHP = lopHP;
        this.tenHP = tenHP;
        this.soTc = soTc;
        this.hocKi = hocKi;
        this.diemChu = diemChu;
        this.diemSo = diemSo;
        this.tichLuy = tichLuy;
        this.ghiChu = ghiChu;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public String getLopHP() {
        return lopHP;
    }

    public void setLopHP(String lopHP) {
        this.lopHP = lopHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public int getSoTc() {
        return soTc;
    }

    public void setSoTc(int soTc) {
        this.soTc = soTc;
    }

    public int getHocKi() {
        return hocKi;
    }

    public void setHocKi(int hocKi) {
        this.hocKi = hocKi;
    }

    public String getDiemChu() {
        return diemChu;
    }

    public void setDiemChu(String diemChu) {
        this.diemChu = diemChu;
    }

    public double getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(double diemSo) {
        this.diemSo = diemSo;
    }

    public boolean isTichLuy() {
        return tichLuy;
    }

    public void setTichLuy(boolean tichLuy) {
        this.tichLuy = tichLuy;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
