package models;

public class Penyewaan {
    public String id;
    public String nama;
    public String jenisKegiatan;
    public String tanggalSewa;
    public int lamaSewa;

    public Penyewaan(String id, String nama, String jenisKegiatan, String tanggalSewa, int lamaSewa) {
        this.id = id;
        this.nama = nama;
        this.jenisKegiatan = jenisKegiatan;
        this.tanggalSewa = tanggalSewa;
        this.lamaSewa = lamaSewa;
    }
}
