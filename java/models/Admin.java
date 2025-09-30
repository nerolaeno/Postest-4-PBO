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

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Admin ===");
        System.out.println("Nama: " + getNama());
        System.out.println("Username: " + getUsername());
        System.out.println("Kode Admin: " + kodeAdmin);
    }
}
