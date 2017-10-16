package srt.studentmanage.model.objects;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Admin on 10/16/2017.
 */

public class SinhVien implements Serializable {
    public  static String currentSV="";
    private String maSV, pass, hoTen, noiSinh, diaChi, sdt, email, mobile, lopSH, atm, cmnd;
    private  double dtb;
    private  int soTcTichLuy, trangThai;
    private Date ngaySinh;

    public SinhVien() {
    }

    public SinhVien(String maSV, String pass, String hoTen, String noiSinh, String diaChi, String sdt,
                    String email, String mobile, String lopSH, String atm, String cmnd, double dtb, int soTcTichLuy, int trangThai, Date ngaySinh) {
        this.maSV = maSV;
        this.pass = pass;
        this.hoTen = hoTen;
        this.noiSinh = noiSinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.mobile = mobile;
        this.lopSH = lopSH;
        this.atm = atm;
        this.cmnd = cmnd;
        this.dtb = dtb;
        this.soTcTichLuy = soTcTichLuy;
        this.trangThai = trangThai;
        this.ngaySinh = ngaySinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLopSH() {
        return lopSH;
    }

    public void setLopSH(String lopSH) {
        this.lopSH = lopSH;
    }

    public String getAtm() {
        return atm;
    }

    public void setAtm(String atm) {
        this.atm = atm;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    public int getSoTcTichLuy() {
        return soTcTichLuy;
    }

    public void setSoTcTichLuy(int soTcTichLuy) {
        this.soTcTichLuy = soTcTichLuy;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
