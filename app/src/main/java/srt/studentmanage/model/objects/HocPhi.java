package srt.studentmanage.model.objects;


public class HocPhi {
    private int MaHocKy,SoTCDK;
    private double HocPhiPhaiNop,BaoHiemYTe,BaoHiemThanThe,NopTaiTaiVu,NopQuaATM;
    private String NgayCapNhat,ChuThichHocPhi;

    public HocPhi(int maHocKy, int soTCDK, double hocPhiPhaiNop, double baoHiemYTe, double baoHiemThanThe, double nopTaiTaiVu, double nopQuaATM, String ngayCapNhat, String chuThichHocPhi) {
        MaHocKy = maHocKy;
        SoTCDK = soTCDK;
        HocPhiPhaiNop = hocPhiPhaiNop;
        BaoHiemYTe = baoHiemYTe;
        BaoHiemThanThe = baoHiemThanThe;
        NopTaiTaiVu = nopTaiTaiVu;
        NopQuaATM = nopQuaATM;
        NgayCapNhat = ngayCapNhat;
        ChuThichHocPhi = chuThichHocPhi;
    }

    public HocPhi() {
    }

    public int getMaHocKy() {
        return MaHocKy;
    }

    public int getSoTCDK() {
        return SoTCDK;
    }

    public double getHocPhiPhaiNop() {
        return HocPhiPhaiNop;
    }

    public double getBaoHiemYTe() {
        return BaoHiemYTe;
    }

    public double getBaoHiemThanThe() {
        return BaoHiemThanThe;
    }

    public double getNopTaiTaiVu() {
        return NopTaiTaiVu;
    }

    public double getNopQuaATM() {
        return NopQuaATM;
    }

    public String getNgayCapNhat() {
        return NgayCapNhat;
    }

    public String getChuThichHocPhi() {
        return ChuThichHocPhi;
    }

    public void setMaHocKy(int maHocKy) {
        MaHocKy = maHocKy;
    }

    public void setSoTCDK(int soTCDK) {
        SoTCDK = soTCDK;
    }

    public void setHocPhiPhaiNop(double hocPhiPhaiNop) {
        HocPhiPhaiNop = hocPhiPhaiNop;
    }

    public void setBaoHiemYTe(double baoHiemYTe) {
        BaoHiemYTe = baoHiemYTe;
    }

    public void setBaoHiemThanThe(double baoHiemThanThe) {
        BaoHiemThanThe = baoHiemThanThe;
    }

    public void setNopTaiTaiVu(double nopTaiTaiVu) {
        NopTaiTaiVu = nopTaiTaiVu;
    }

    public void setNopQuaATM(double nopQuaATM) {
        NopQuaATM = nopQuaATM;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        NgayCapNhat = ngayCapNhat;
    }

    public void setChuThichHocPhi(String chuThichHocPhi) {
        ChuThichHocPhi = chuThichHocPhi;
    }
}
