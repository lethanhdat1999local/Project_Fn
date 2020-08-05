package tdc.edu.doanlaptrinhdidong2.ModulesClass;

public class congtyxe {
    private int maloai;
    private  String Tenloai;
    private String Xuatxu;

    public congtyxe(String tenloai, String xuatxu) {
        Tenloai = tenloai;
        Xuatxu = xuatxu;
    }

    public congtyxe() {
    }

    public congtyxe(int maloai, String tenloai, String xuatxu) {
        this.maloai = maloai;
        Tenloai = tenloai;
        Xuatxu = xuatxu;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return Tenloai;
    }

    public void setTenloai(String tenloai) {
        Tenloai = tenloai;
    }

    public String getXuatxu() {
        return Xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        Xuatxu = xuatxu;
    }
}
