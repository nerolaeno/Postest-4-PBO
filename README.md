# Postest 4 Praktikum PBO | Sistem penyewaan gedung

Nama : Alvionej Resna Lawrend Pandiangan

NIM  : 2409116073

## Deskripsi Program
Program Sistem Penyewaan Gedung merupakan aplikasi sederhana yang meniru fungsi dasar dari sistem pengelolaan penyewaan gedung serbaguna. Program ini memungkinkan user untuk melakukan operasi dasar seperti menambahkan data penyewaan gedung, menampilkan daftar penyewaan yang telah tercatat, mengubah data penyewaan yang sudah ada, serta menghapus data penyewaan dari sistem. Setiap data penyewaan berisi informasi seperti nama penyewa, jenis kegiatan, tanggal penyewaan, dan lama sewa dalam hitungan hari. Program ini dibuat menggunakan bahasa pemrograman Java

# Output Program

### Menu Utama
Pada saat User pertama kali menjalankan program dan masuk ke program, User akan dihadapkan dengan menu seperti gambar ini.

<img width="509" height="174" alt="Screenshot 2025-09-16 211234" src="https://github.com/user-attachments/assets/807804b5-7ff4-4b8f-a8db-4b5a95e9e115" />

### 1. Tambah Penyewaan

Jika pengguna memilih menu ini, program akan meminta input berupa nama penyewa, jenis kegiatan, tanggal sewa, dan lama sewa dalam hitungan hari. Setelah semua data dimasukkan, sistem akan menambahkan data penyewaan baru ke daftar dan menampilkan pesan konfirmasi bahwa data berhasil ditambahkan.

<img width="589" height="304" alt="Screenshot 2025-09-16 213107" src="https://github.com/user-attachments/assets/dd2e0c74-c247-4c93-8798-a67fce364de2" />

### 2. Lihat Semua Penyewaan

Menu ini digunakan untuk menampilkan semua data penyewaan yang sudah tercatat. Data akan ditampilkan dalam bentuk tabel yang memuat kolom ID, Nama Penyewa, Jenis Kegiatan, Tanggal Sewa, dan Lama Sewa (hari). Jika belum ada data, program akan menampilkan pesan bahwa data masih kosong.

<img width="885" height="414" alt="Screenshot 2025-09-16 213201" src="https://github.com/user-attachments/assets/daa17ebd-5cdf-4f5e-9f78-31b512d61885" />

### 3. Ubah Data Penyewaan

Menu ini memungkinkan pengguna mengubah data penyewaan yang sudah ada. Program akan meminta input ID penyewaan yang ingin diubah. Jika ID ditemukan, pengguna dapat memasukkan data baru seperti nama penyewa, jenis kegiatan, tanggal sewa, atau lama sewa. Setelah selesai, program menampilkan pesan konfirmasi bahwa data berhasil diubah.

<img width="575" height="278" alt="Screenshot 2025-09-16 213258" src="https://github.com/user-attachments/assets/e6440bea-85d8-4d2f-845d-caa408960346" />

### 4. Hapus Data Penyewaan

Jika pengguna memilih menu ini, program akan meminta input ID penyewaan yang ingin dihapus. Jika ID ditemukan, data tersebut akan dihapus dari daftar penyewaan, dan program menampilkan pesan konfirmasi bahwa data berhasil dihapus. Jika ID tidak ditemukan, akan muncul pesan peringatan.

<img width="567" height="227" alt="Screenshot 2025-09-16 213417" src="https://github.com/user-attachments/assets/58e92cd7-d200-4b92-b28c-fd9f3a6a54f8" />

Untuk melihat apakah data sudah terhapus, pilih menu 2 (Lihat Wahana).

<img width="868" height="385" alt="Screenshot 2025-09-16 213451" src="https://github.com/user-attachments/assets/5c282a50-a487-4d88-8c16-9df17f04c3d1" />

### 5. Cari Penyewaan

Menu ini digunakan untuk mencari data penyewaan berdasarkan nama penyewa. Program akan meminta pengguna memasukkan kata kunci nama, lalu menampilkan semua data penyewaan yang cocok dalam format tabel. Jika tidak ada data yang cocok, program akan memberi tahu bahwa data tidak ditemukan.

<img width="560" height="365" alt="Screenshot 2025-09-16 213551" src="https://github.com/user-attachments/assets/949e1973-37c1-46c8-b367-f117ed5f3008" />

### 6. Keluar

Jika pengguna memilih menu ini, program akan menampilkan pesan “Terima kasih, silahkan datang kembali!” kemudian menghentikan seluruh proses program.

<img width="768" height="224" alt="Screenshot 2025-09-16 213644" src="https://github.com/user-attachments/assets/8742b443-6e40-4332-a339-436971ac2ba6" />

## =============================================

<img width="392" height="225" alt="Screenshot 2025-09-16 214635" src="https://github.com/user-attachments/assets/bb614b14-65d7-40b4-b016-5d3e02d6a3b3" />

#### 1. com.mycompany.sistempenyewaangedung
Berisi file SistemPenyewaanGedung.java. :
-Menampilkan menu utama kepada pengguna
-Menerima input dari pengguna
-Mengarahkan proses ke bagian yang sesuai (menambah, melihat, mengubah, menghapus, mencari penyewaan)


#### 2. models
Berisi class yang menyimpan data.

##### - Admin.java : Menyimpan data admin (username, password, dsb.)
```java
package models;

public class Admin extends User {
    private String kodeAdmin;

    public Admin(String nama, String username, String password, String kodeAdmin) {
        super(nama, username, password);
        this.kodeAdmin = kodeAdmin;
    }

    public String getKodeAdmin() {
        return kodeAdmin;
    }

    public void setKodeAdmin(String kodeAdmin) {
        this.kodeAdmin = kodeAdmin;
    }   
}
```

##### - Gedung.java : Menyimpan data gedung (nama, kapasitas, harga sewa)
```java
package models;

public class Gedung {
    public String namaGedung;
    public String lokasi;
    public int kapasitas;

    public Gedung(String namaGedung, String lokasi, int kapasitas) {
        this.namaGedung = namaGedung;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
    }
}
```

##### - Penyewaan.java : Menyimpan data penyewaan (nama penyewa, jenis kegiatan,  tanggal sewa, lama sewa) SUBCLASS

```java
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
```

##### - User.java : Menyimpan data User (nama, username, password) SUPERCLASS

```java
package models;

public class User {
    private String nama;
    private String username;
    private String password;

    public User(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
```

##### - Pelanggan.java : Menyimpan data pelanggan (nama, username, password, statusMember) SUBCLASS

```java
package models;

public class Pelanggan extends User{
    private boolean statusMember;

    public Pelanggan(String nama, String username, String password,boolean statusMember) {
        super(nama, username, password);
        this.statusMember = statusMember;
    }

    public boolean isStatusMember() {
        return statusMember;
    }

    public void setStatusMember(boolean statusMember) {
        this.statusMember = statusMember;
    } 
}
```

Package ini hanya untuk menyimpan data, tidak ada proses perhitungan di sini.

4. services

 Berisi proses atau logika utama program.
 
-PenyewaanService.java → Mengatur semua proses seperti menambah penyewaan, menampilkan daftar, mengubah data, menghapus data, dan mencari data.

## Abstraction & Polymorphism

### 1. Menerapkan Abstraction
<img width="326" height="94" alt="Screenshot 2025-09-30 095540" src="https://github.com/user-attachments/assets/54980790-9a75-4992-9aeb-583b4a72593c" />

<img width="398" height="34" alt="Screenshot 2025-09-30 095555" src="https://github.com/user-attachments/assets/e814f52f-d8f1-4555-8012-0995e5dc5cc6" />

Disini User sebagai abstract class, karena User hanya menjadi template bagi Admin dan Pelanggan, tidak dibuat sebagai objek langsung.
Lalu tambahkan 1 method abstract tampilkanInfo() supaya wajib dioverride oleh semua subclass.

### 2. Menggunakan Interface

<img width="382" height="161" alt="image" src="https://github.com/user-attachments/assets/55b76ec1-cc7b-47e6-9977-8fe369b0e1b6" />

Membuat interface CetakData yang dipakai untuk menampilkan informasi penyewaan.

### 3. Menerapkan Interface di Service

<img width="707" height="303" alt="image" src="https://github.com/user-attachments/assets/9263f0e9-d8e0-44d8-8f56-cd75d8e11433" />

Disini PenyewaanService mengimplementasikan CetakData karena berfungsi sebagai pengelola utama dalam sistem penyewaan.
Method tampilkanDetail() kita buat sebagai implementasi dari interface.

### 4. Menerapkan Polymorphism

- Override

<img width="921" height="214" alt="Screenshot 2025-09-30 102527" src="https://github.com/user-attachments/assets/80741a93-a728-4cc9-b923-1e1964ea49b1" />

<img width="554" height="178" alt="Screenshot 2025-09-30 102547" src="https://github.com/user-attachments/assets/f3e2db6e-bd49-4131-89a0-596c56c19d77" />

- Overloading

<img width="874" height="139" alt="image" src="https://github.com/user-attachments/assets/8bbb687c-890f-459a-a08f-43a09d2d057b" />



