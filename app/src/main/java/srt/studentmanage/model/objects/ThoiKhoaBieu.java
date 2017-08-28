package srt.studentmanage.model.objects;

import java.io.Serializable;

/**
 * Created by Admin on 08/28/2017.
 */

public class ThoiKhoaBieu implements Serializable{
    private int thu;
    private String tenMonHoc;
    private String lopHP;
    private int tuTiet;
    private int denTiet;
    private String giangVien;
    private String ngayHL;
    private String ghiChu;
    private String phong;

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getLopHP() {
        return lopHP;
    }

    public void setLopHP(String lopHP) {
        this.lopHP = lopHP;
    }

    public int getTuTiet() {
        return tuTiet;
    }

    public void setTuTiet(int tuTiet) {
        this.tuTiet = tuTiet;
    }

    public int getDenTiet() {
        return denTiet;
    }

    public void setDenTiet(int denTiet) {
        this.denTiet = denTiet;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public String getNgayHL() {
        return ngayHL;
    }

    public void setNgayHL(String ngayHL) {
        this.ngayHL = ngayHL;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public ThoiKhoaBieu() {
    }

    public ThoiKhoaBieu(int thu, String tenMonHoc, String lopHP, int tuTiet, int denTiet, String giangVien, String ngayHL, String ghiChu,String phong) {
        this.thu = thu;
        this.tenMonHoc = tenMonHoc;
        this.lopHP = lopHP;
        this.tuTiet = tuTiet;
        this.denTiet = denTiet;
        this.giangVien = giangVien;
        this.ngayHL = ngayHL;
        this.ghiChu = ghiChu;
        this.phong=phong;
    }
}
