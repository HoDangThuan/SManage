package srt.studentmanage.model.objects;

public class HocPhanChuaTL {
    private String maHP,tenHP,soTC,loaiMH,ghiChu;

    public HocPhanChuaTL(String maHP, String tenHP, String soTC, String loaiMH, String ghiChu) {
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.soTC = soTC;
        this.loaiMH = loaiMH;
        this.ghiChu = ghiChu;
    }

    public String getMaHP() {
        return maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public String getSoTC() {
        return soTC;
    }

    public String getLoaiMH() {
        return loaiMH;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public void setSoTC(String soTC) {
        this.soTC = soTC;
    }

    public void setLoaiMH(String loaiMH) {
        this.loaiMH = loaiMH;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
