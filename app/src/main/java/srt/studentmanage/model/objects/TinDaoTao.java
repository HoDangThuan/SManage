package srt.studentmanage.model.objects;

import java.io.Serializable;

/**
 * Created by Huu Ty on 14/09/2017.
 */

public class TinDaoTao implements Serializable {
    private int maTin;
    private String tieuDe;
    private String noiDung;
    private String tacGia;

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

    public TinDaoTao(int maTin, String tieuDe, String noiDung, String tacGia) {
        this.maTin = maTin;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.tacGia = tacGia;
    }
}
