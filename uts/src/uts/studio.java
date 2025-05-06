/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts;

import java.util.Scanner;

/**
 *
 * @author LAB F
 */
class Studio {
    private String namaStudio;
    private String alamatStudio;
    private String pricelist; // Simpan pricelist sebagai string, Anda bisa memodifikasi ini menjadi struktur data yang lebih kompleks jika dibutuhkan (misalnya, Map<String, Double>)

    public Studio(String namaStudio, String alamatStudio, String pricelist) {
        this.namaStudio = namaStudio;
        this.alamatStudio = alamatStudio;
        this.pricelist = pricelist;
    }

    // Getter dan Setter
    public String getNamaStudio() { return namaStudio; }
    public void setNamaStudio(String namaStudio) { this.namaStudio = namaStudio; }
    public String getAlamatStudio() { return alamatStudio; }
    public void setAlamatStudio(String alamatStudio) { this.alamatStudio = alamatStudio; }
    public String getPricelist() { return pricelist; }
    public void setPricelist(String pricelist) { this.pricelist = pricelist; }

    @Override
    public String toString() {
        return "Studio{" +
                "namaStudio='" + namaStudio + '\'' +
                ", alamatStudio='" + alamatStudio + '\'' +
                ", pricelist='" + pricelist + '\'' +
                '}';
    }
}

 class AplikasiStudio {
    private Studio[] daftarStudio;
    private int jumlahStudio;
    private Scanner input;

    public AplikasiStudio() {
        daftarStudio = new Studio[100]; // Batas maksimal studio yang bisa disimpan
        jumlahStudio = 0;
        input = new Scanner(System.in);
    }

    public void menuAplikasi() {
        int pilihan;
        do {
            System.out.println("\nMenu Aplikasi Studio");
            System.out.println("1. Tambah Studio");
            System.out.println("2. Tampilkan Studio");
            System.out.println("3. Ubah Data Studio");
            System.out.println("4. Hapus Studio");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine(); // Consume newline

            switch (pilihan) {
                case 1: tambahStudio(); break;
                case 2: tampilkanStudio(); break;
                case 3: ubahStudio(); break;
                case 4: hapusStudio(); break;
                case 0: System.out.println("Keluar dari aplikasi."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        input.close();
    }

    private void tambahStudio() {
        System.out.print("Nama Studio: ");
        String nama = input.nextLine();
        System.out.print("Alamat Studio: ");
        String alamat = input.nextLine();
        System.out.print("Pricelist (Contoh: Jasa A - Rp 100.000, Jasa B - Rp 200.000): ");
        String pricelist = input.nextLine();

        daftarStudio[jumlahStudio] = new Studio(nama, alamat, pricelist);
        jumlahStudio++;
        System.out.println("Studio berhasil ditambahkan.");
    }

    private void tampilkanStudio() {
        if (jumlahStudio == 0) {
            System.out.println("Belum ada data studio.");
            return;
        }
        System.out.println("\nDaftar Studio:");
        for (int i = 0; i < jumlahStudio; i++) {
            System.out.println((i + 1) + ". " + daftarStudio[i]);
        }
    }

    private void ubahStudio() {
        tampilkanStudio();
        System.out.print("Pilih nomor studio yang akan diubah (1-" + jumlahStudio + "): ");
        int index = input.nextInt();
        input.nextLine(); // Consume newline

        if (index >= 1 && index <= jumlahStudio) {
            System.out.print("Nama Studio baru: ");
            daftarStudio[index - 1].setNamaStudio(input.nextLine());
            System.out.print("Alamat Studio baru: ");
            daftarStudio[index - 1].setAlamatStudio(input.nextLine());
            System.out.print("Pricelist baru: ");
            daftarStudio[index - 1].setPricelist(input.nextLine());
            System.out.println("Data studio berhasil diubah.");
        } else {
            System.out.println("Nomor studio tidak valid.");
        }
    }

    private void hapusStudio() {
        tampilkanStudio();
        System.out.print("Pilih nomor studio yang akan dihapus (1-" + jumlahStudio + "): ");
        int index = input.nextInt();

        if (index >= 1 && index <= jumlahStudio) {
            for (int i = index - 1; i < jumlahStudio - 1; i++) {
                daftarStudio[i] = daftarStudio[i + 1];
            }
            jumlahStudio--;
            System.out.println("Studio berhasil dihapus.");
        } else {
            System.out.println("Nomor studio tidak valid.");
        }
    }
}