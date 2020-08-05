package tdc.edu.doanlaptrinhdidong2.ModulesClass;

public class chitietdonhang {
    private int madonhang;
    private int maxe;
    private int soluongdonhang;
    private int dongia;
    private String ngaylap;

    public chitietdonhang() {
    }

    public chitietdonhang(int maxe, int soluongdonhang, int dongia, String ngaylap) {
        this.maxe = maxe;
        this.soluongdonhang = soluongdonhang;
        this.dongia = dongia;
        this.ngaylap = ngaylap;
    }

    public chitietdonhang(int madonhang, int maxe, int soluongdonhang, int dongia, String ngaylap) {
        this.madonhang = madonhang;
        this.maxe = maxe;
        this.soluongdonhang = soluongdonhang;
        this.dongia = dongia;
        this.ngaylap = ngaylap;
    }

    public int getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(int madonhang) {
        this.madonhang = madonhang;
    }

    public int getMaxe() {
        return maxe;
    }

    public void setMaxe(int maxe) {
        this.maxe = maxe;
    }

    public int getSoluongdonhang() {
        return soluongdonhang;
    }

    public void setSoluongdonhang(int soluongdonhang) {
        this.soluongdonhang = soluongdonhang;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }
}
