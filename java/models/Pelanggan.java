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

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Pelanggan ===");
        System.out.println("Nama: " + getNama());
        System.out.println("Username: " + getUsername());
        System.out.println("Status Member: " + (statusMember ? "Aktif" : "Tidak Aktif"));  
    }
    
}
