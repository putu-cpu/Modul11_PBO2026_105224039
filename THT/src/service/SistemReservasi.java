package service;

// Import class dan exception yang dibutuhkan
import java.util.ArrayList;

import exception.DataPenumpangTidakValidException;
import exception.RuteTidakDitemukanException;
import exception.TiketHabisException;
import model.KeretaApi;

// Class ini menjadi pusat pengelolaan reservasi tiket
public class SistemReservasi {

    // Menyimpan daftar kereta
    private ArrayList<KeretaApi> daftarKereta;

    // Constructor
    // Data kereta langsung dimasukkan saat sistem dibuat
    public SistemReservasi() {

        daftarKereta = new ArrayList<>();

        daftarKereta.add(
                new KeretaApi(
                        "K01",
                        "Argo Bromo",
                        "JKT - SBY",
                        50));

        daftarKereta.add(
                new KeretaApi(
                        "K02",
                        "Parahyangan",
                        "JKT - BDG",
                        15));
    }

    // Menampilkan seluruh jadwal kereta
    public void tampilkanJadwal() {

        System.out.println("\n===== JADWAL KERETA =====");

        for (KeretaApi kereta : daftarKereta) {
            System.out.println(kereta);
        }
    }

    // Method untuk melakukan pemesanan tiket
    public void pesanTiket(
            String kodeKereta,
            String nik,
            String namaPenumpang,
            int jumlahTiket)

            throws RuteTidakDitemukanException,
            TiketHabisException {

        // Validasi NIK
        if (nik.length() != 16 || !nik.matches("\\d+")) {

            throw new DataPenumpangTidakValidException(
                    "NIK harus terdiri dari 16 digit angka!");
        }

        // Mencari kereta berdasarkan kode
        KeretaApi keretaDipilih = null;

        for (KeretaApi kereta : daftarKereta) {

            if (kereta.getKode().equalsIgnoreCase(kodeKereta)) {

                keretaDipilih = kereta;
                break;
            }
        }

        // Jika kereta tidak ditemukan
        if (keretaDipilih == null) {

            throw new RuteTidakDitemukanException(
                    "Kode kereta tidak ditemukan!");
        }

        // Jika jumlah tiket melebihi sisa kursi
        if (jumlahTiket > keretaDipilih.getSisaKursi()) {

            throw new TiketHabisException(
                    keretaDipilih.getNama(),
                    keretaDipilih.getSisaKursi());
        }

        // Mengurangi kursi setelah pemesanan berhasil
        keretaDipilih.kurangiKursi(jumlahTiket);

        // Menampilkan informasi pemesanan
        System.out.println("\n===== PEMESANAN BERHASIL =====");
        System.out.println("Nama : " + namaPenumpang);
        System.out.println("NIK : " + nik);
        System.out.println("Kereta : " + keretaDipilih.getNama());
        System.out.println("Jumlah Tiket : " + jumlahTiket);
        System.out.println("Sisa Kursi : " + keretaDipilih.getSisaKursi());
    }
}