package com.mycompany.sistempenyewaangedung;
import java.util.Scanner;
import services.PenyewaanService;
import models.User;

public class SistemPenyewaanGedung {
    public static void main(String[] args) {
        PenyewaanService service = new PenyewaanService();
        Scanner input = new Scanner(System.in);
        service.isiDummyData();
        
        User currentUser = service.login();
        
        while (true) {
            System.out.println("\n=== Sistem Penyewaan Gedung Serbaguna Mustika Jaya ===");
            System.out.println("1. Tambah Penyewaan");
            System.out.println("2. Lihat Semua Penyewaan");
            System.out.println("3. Ubah Data Penyewaan");
            System.out.println("4. Hapus Data Penyewaan");
            System.out.println("5. Cari Penyewaan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {
                case 1 -> service.tambahPenyewaan();
                case 2 -> service.tampilkanPenyewaan();
                case 3 -> service.ubahPenyewaan();
                case 4 -> service.hapusPenyewaan();
                case 5 -> service.cariPenyewaan();
                case 6 -> {
                    System.out.println("Terima kasih, silahkan datang kembali!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
