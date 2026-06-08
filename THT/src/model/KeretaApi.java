package model;

// Class ini digunakan untuk menyimpan data kereta api
public class KeretaApi {

    // Atribut kereta
    private String kode;
    private String nama;
    private String rute;
    private int sisaKursi;

    // Constructor untuk mengisi data awal kereta
    public KeretaApi(String kode, String nama,
                     String rute, int sisaKursi) {

        this.kode = kode;
        this.nama = nama;
        this.rute = rute;
        this.sisaKursi = sisaKursi;
    }

    // Getter untuk mengambil kode kereta
    public String getKode() {
        return kode;
    }

    // Getter untuk mengambil nama kereta
    public String getNama() {
        return nama;
    }

    // Getter untuk mengambil rute kereta
    public String getRute() {
        return rute;
    }

    // Getter untuk mengambil sisa kursi
    public int getSisaKursi() {
        return sisaKursi;
    }

    // Mengurangi jumlah kursi setelah tiket dipesan
    public void kurangiKursi(int jumlah) {
        sisaKursi -= jumlah;
    }

    // Menampilkan informasi kereta
    @Override
    public String toString() {
        return kode + " | " +
                nama + " | " +
                rute + " | Sisa Kursi : " +
                sisaKursi;
    }
}
