package srt.studentmanage.model.objects;

/**
 * Created by Dell on 11/24/2017.
 */

public class DangKyMonHoc {
    private String maHP,tenHP,tenLHP,ghiChu,giangVien;
    boolean checkBox;
    int soTC,thu,tutiet,dentiet,sisoMax,soDK;

    public DangKyMonHoc() {
    }

    public DangKyMonHoc(String maHP, String tenHP, String tenLHP, String ghiChu, String giangVien, int soTC, int thu, int tutiet, int dentiet, int sisoMax, int soDK) {
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.tenLHP = tenLHP;
        this.ghiChu = ghiChu;
        this.giangVien = giangVien;
        this.soTC = soTC;
        this.thu = thu;
        this.tutiet = tutiet;
        this.dentiet = dentiet;
        this.sisoMax = sisoMax;
        this.soDK = soDK;
        this.checkBox=false;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    public String getMaHP() {
        return maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public String getTenLHP() {
        return tenLHP;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public int getSoTC() {
        return soTC;
    }

    public int getThu() {
        return thu;
    }

    public int getTutiet() {
        return tutiet;
    }

    public int getDentiet() {
        return dentiet;
    }

    public int getSisoMax() {
        return sisoMax;
    }

    public int getSoDK() {
        return soDK;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public void setTenLHP(String tenLHP) {
        this.tenLHP = tenLHP;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public void setTutiet(int tutiet) {
        this.tutiet = tutiet;
    }

    public void setDentiet(int dentiet) {
        this.dentiet = dentiet;
    }

    public void setSisoMax(int sisoMax) {
        this.sisoMax = sisoMax;
    }

    public void setSoDK(int soDK) {
        this.soDK = soDK;
    }
}
