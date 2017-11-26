package srt.studentmanage.model.objects;

/**
 * Created by Dell on 11/24/2017.
 */

public class LichThi {
    private String tenLHP,lopHP,tenGV,ngayThi,gioThi,phongThi;

    public LichThi(){}

    public LichThi(String tenLHP,String lopHP,String tenGV,String ngayThi,String gioThi,String phongThi){
        this.tenLHP=tenLHP;
        this.lopHP=lopHP;
        this.tenGV=tenGV;
        this.ngayThi=ngayThi;
        this.gioThi=gioThi;
        this.phongThi=phongThi;
    }

    public String getTenLHP() {
        return tenLHP;
    }

    public void setTenLHP(String maHK) {
        this.tenLHP = tenLHP;
    }

    public String getLopHP() {
        return lopHP;
    }

    public void seLopHP(String lopHP) {
        this.lopHP = lopHP;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) { this.tenGV = tenGV; }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getGioThi() {
        return gioThi;
    }

    public void setGioThi(String gioThi) {
        this.gioThi = gioThi;
    }
    public String getPhongThi() {
        return phongThi;
    }

    public void setPhongThi(String phongThi) {
        this.phongThi = phongThi;
    }

}
