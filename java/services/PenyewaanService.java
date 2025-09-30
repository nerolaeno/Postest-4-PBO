package services;

import interfaces.CetakData;
import java.util.ArrayList;
import java.util.Scanner;
import models.Penyewaan;
import models.Admin;
import models.Pelanggan;
import models.User;

public class PenyewaanService implements CetakData {
    private ArrayList<Penyewaan> daftarPenyewaan = new ArrayList<>();
    private ArrayList<User> daftarUser = new ArrayList<>();
    private int idCounter = 1;
    private Scanner input = new Scanner(System.in);

    public void isiDummyData() {
        Penyewaan p1 = new Penyewaan(null, null, null, null, 0);
        p1.id = String.valueOf(idCounter++);
        p1.nama = "Na Jaemin";
        p1.jenisKegiatan = "Fansign";
        p1.tanggalSewa = "20-10-2025";
        p1.lamaSewa = 2;

        Penyewaan p2 = new Penyewaan(null, null, null, null, 0);
        p2.id = String.valueOf(idCounter++);
        p2.nama = "Loren";
        p2.jenisKegiatan = "Seminar";
        p2.tanggalSewa = "04-09-2025";
        p2.lamaSewa = 1;

        Penyewaan p3 = new Penyewaan(null, null, null, null, 0);
        p3.id = String.valueOf(idCounter++);
        p3.nama = "Inforsa";
        p3.jenisKegiatan = "Workshop";
        p3.tanggalSewa = "25-09-2025";
        p3.lamaSewa = 3;

        daftarPenyewaan.add(p1);
        daftarPenyewaan.add(p2);
        daftarPenyewaan.add(p3);
        tambahPenyewaan("Lisa", "Seminar", "09-11-2025", 4);
        
        Admin admin1 = new Admin("Admin Penyewaan", "admin", "1234", "AP01");
        Pelanggan pelanggan1 = new Pelanggan("Vio", "vio", "1234", true);
        daftarUser.add(admin1);
        daftarUser.add(pelanggan1);
    }
    
    public User login() {
        System.out.println("=== Login Sistem Penyewaan ===");
        while (true) {
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();

            for (User u : daftarUser) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    System.out.println("\nLogin Berhasil! Selamat datang, " + u.getNama());
                    u.tampilkanInfo();  // Polymorphism (override)
                    return u;
                }
            }
            System.out.println("Username atau password salah, coba lagi.\n");
        }
    }
    
    public void tambahPenyewaan() {
        System.out.print("Nama Penyewa: ");
        String nama = input.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong!");
            return;
        }

        System.out.print("Jenis Kegiatan: ");
        String kegiatan = input.nextLine().trim();

        System.out.print("Tanggal Sewa (DD-MM-YYYY): ");
        String tanggal = input.nextLine().trim();

        System.out.print("Lama Sewa (hari): ");
        int lama;
        try {
            lama = Integer.parseInt(input.nextLine().trim());
            if (lama <= 0) {
                System.out.println("Lama sewa harus lebih dari 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Input lama sewa harus angka!");
            return;
        }

        String id = String.valueOf(idCounter++);
        Penyewaan p = new Penyewaan(id, nama, kegiatan, tanggal, lama);
        daftarPenyewaan.add(p);
        System.out.println(" Data berhasil ditambahkan.");
    }
    
    public void tambahPenyewaan(String nama, String kegiatan, String tanggal, int lama) {
        String id = String.valueOf(idCounter++);
        Penyewaan p = new Penyewaan(id, nama, kegiatan, tanggal, lama);
        daftarPenyewaan.add(p);
        System.out.println("Data berhasil ditambahkan.");
    }
    
    public void tampilkanPenyewaan() {
        if (daftarPenyewaan.isEmpty()) {
            System.out.println("Belum ada data penyewaan.");
            return;
        }

        System.out.println("\nDaftar Penyewaan");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-20s | %-12s | %-10s |\n", 
                          "ID", "Nama Penyewa", "Jenis Kegiatan", "Tanggal Sewa", "Lama (hari)");
        System.out.println("------------------------------------------------------------------------------------");

        for (Penyewaan p : daftarPenyewaan) {
            System.out.printf("| %-5s | %-20s | %-20s | %-12s | %-10d |\n",
                              p.id, p.nama, p.jenisKegiatan, p.tanggalSewa, p.lamaSewa);
        }

        System.out.println("------------------------------------------------------------------------------------");
    }

    public void ubahPenyewaan() {
        System.out.print("Masukkan ID penyewaan yang ingin diubah: ");
        String id = input.nextLine();

        for (Penyewaan p : daftarPenyewaan) {
            if (p.id.equals(id)) {
                System.out.print("Tanggal Sewa Baru (DD-MM-YYYY): ");
                p.tanggalSewa = input.nextLine();

                System.out.print("Lama Sewa Baru (hari): ");
                try {
                    p.lamaSewa = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Input lama sewa harus angka!");
                    return;
                }
                System.out.println("Data berhasil diubah.");
                return;
            }
        }
        System.out.println("Data dengan ID tersebut tidak ditemukan.");
    }

    public void hapusPenyewaan() {
        System.out.print("Masukkan ID penyewaan yang ingin dihapus: ");
        String id = input.nextLine();

        for (int i = 0; i < daftarPenyewaan.size(); i++) {
            if (daftarPenyewaan.get(i).id.equals(id)) {
                daftarPenyewaan.remove(i);
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data dengan ID tersebut tidak ditemukan.");
    }

    public void cariPenyewaan() {
        System.out.print("Masukkan nama penyewa yang dicari: ");
        String keyword = input.nextLine().toLowerCase();

        boolean ditemukan = false;
        for (Penyewaan p : daftarPenyewaan) {
            if (p.nama.toLowerCase().contains(keyword)) {
                cetakDetail(p);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada penyewaan dengan nama tersebut.");
        }
    }
    
    @Override
    public void cetakDetail(Penyewaan p) {
        System.out.println("----------------------------");
        System.out.println("ID Penyewaan : " + p.id);
        System.out.println("Nama Penyewa : " + p.nama);
        System.out.println("Jenis Kegiatan : " + p.jenisKegiatan);
        System.out.println("Tanggal Sewa : " + p.tanggalSewa);
        System.out.println("Lama Sewa    : " + p.lamaSewa + " hari");
        System.out.println("----------------------------");
    }
    
    
}
