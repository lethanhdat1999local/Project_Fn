package tdc.edu.doanlaptrinhdidong2.ModulesClass;

public class xemay {
    private String tenxe;
    private int maloai;
    private  String Dungtich;
    private  int soluong;
    private  int maxe;

    public xemay() {
    }

    public xemay(String tenxe, int maloai, String dungtich, int soluong) {
        this.tenxe = tenxe;
        this.maloai = maloai;
        Dungtich = dungtich;
        this.soluong = soluong;
    }

    public xemay(String tenxe, int maloai, String dungtich, int soluong, int maxe) {
        this.tenxe = tenxe;
        this.maloai = maloai;
        Dungtich = dungtich;
        this.soluong = soluong;
        this.maxe = maxe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getDungtich() {
        return Dungtich;
    }

    public void setDungtich(String dungtich) {
        Dungtich = dungtich;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getMaxe() {
        return maxe;
    }

    public void setMaxe(int maxe) {
        this.maxe = maxe;
    }
}
