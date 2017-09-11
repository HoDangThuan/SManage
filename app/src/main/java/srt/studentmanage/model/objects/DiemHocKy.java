package srt.studentmanage.model.objects;

/**
 * Created by Admin on 09/11/2017.
 */

public class DiemHocKy {
    private int maHK,soTcDk;
    private double diemTB, diemRL;
    private String xepLoai, ghiChu;

    public DiemHocKy() {
    }

    public DiemHocKy(int maHK, int soTcDk, double diemTB, double diemRL, String xepLoai, String ghiChu) {
        this.maHK = maHK;
        this.soTcDk = soTcDk;
        this.diemTB = diemTB;
        this.diemRL = diemRL;
        this.xepLoai = xepLoai;
        this.ghiChu = ghiChu;
    }

    public int getMaHK() {
        return maHK;
    }

    public void setMaHK(int maHK) {
        this.maHK = maHK;
    }

    public int getSoTcDk() {
        return soTcDk;
    }

    public void setSoTcDk(int soTcDk) {
        this.soTcDk = soTcDk;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public double getDiemRL() {
        return diemRL;
    }

    public void setDiemRL(double diemRL) {
        this.diemRL = diemRL;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
