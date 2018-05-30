package srt.studentmanage.model.objects;

import java.io.Serializable;

public class TinDaoTao implements Serializable {
    private int maTin;
    private String tieuDe,noiDung,tacGia,ngayViet;

    public String getNgayViet() {
        return ngayViet;
    }

    public void setNgayViet(String ngayViet) {
        this.ngayViet = ngayViet;
    }

    public int getMaTin() {
        return maTin;
    }

    public void setMaTin(int maTin) {
        this.maTin = maTin;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public TinDaoTao() {
    }

    public TinDaoTao(int maTin, String tieuDe, String noiDung, String tacGia, String ngayViet) {
        this.maTin = maTin;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.tacGia = tacGia;
        this.ngayViet = ngayViet;
    }
}
