package main;

// Import class yang diperlukan
import java.util.InputMismatchException;
import java.util.Scanner;

import exception.DataPenumpangTidakValidException;
import exception.RuteTidakDitemukanException;
import exception.TiketHabisException;
import service.SistemReservasi;

// Class utama yang berisi menu aplikasi
public class JavaExpress {

    public static void main(String[] args) {

        // Membaca input pengguna
        Scanner input = new Scanner(System.in);

        // Membuat objek reservasi
        SistemReservasi reservasi = new SistemReservasi();

        boolean jalan = true;

        // Perulangan menu utama
        while (jalan) {

            try {

                System.out.println("\n===== JAVA EXPRESS =====");
                System.out.println("1. Lihat Jadwal");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih Menu : ");

                int pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {

                    // Menampilkan jadwal kereta
                    case 1:
                        reservasi.tampilkanJadwal();
                        break;

                    // Melakukan pemesanan tiket
                    case 2:

                        System.out.print("Kode Kereta : ");
                        String kode = input.nextLine();

                        System.out.print("NIK : ");
                        String nik = input.nextLine();

                        System.out.print("Nama Penumpang : ");
                        String nama = input.nextLine();

                        System.out.print("Jumlah Tiket : ");
                        int jumlah = input.nextInt();
                        input.nextLine();

                        reservasi.pesanTiket(
                                kode,
                                nik,
                                nama,
                                jumlah);
                        break;

                    // Keluar dari program
                    case 3:
                        jalan = false;
                        System.out.println(
                                "Terima kasih telah menggunakan JAVA EXPRESS.");
                        break;

                    default:
                        System.out.println("Menu tidak tersedia.");
                }

            }

            // Menangani jika user memasukkan huruf
            // saat program meminta angka
            catch (InputMismatchException e) {

                System.out.println(
                        "Input harus berupa angka!");

                input.nextLine();
            }

            // Menangani NIK tidak valid
            catch (DataPenumpangTidakValidException e) {

                System.out.println(
                        "ERROR : " + e.getMessage());
            }

            // Menangani kode kereta tidak ditemukan
            catch (RuteTidakDitemukanException e) {

                System.out.println(
                        "ERROR : " + e.getMessage());
            }

            // Menangani tiket habis
            catch (TiketHabisException e) {

                System.out.println(
                        "ERROR : " + e.getMessage());
            }

            // Menangani error lainnya
            catch (Exception e) {

                System.out.println(
                        "Terjadi kesalahan : " + e.getMessage());
            }
        }

        // Finally akan selalu dijalankan
        try {
            System.out.println("Menutup sistem...");
        } finally {
            input.close();
            System.out.println("Program selesai.");
        }
    }
}
