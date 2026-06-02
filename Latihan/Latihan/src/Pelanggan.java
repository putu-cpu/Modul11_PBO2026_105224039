//no2
class Pelanggan {

    int stokKopi = 5;

    public void daftarMember(int umur) {

        if (umur < 17) {
            throw new IllegalArgumentException(
                "Maaf, umur Anda belum mencukupi untuk menjadi Member VIP"
            );
        }

        System.out.println("Pendaftaran Member VIP berhasil!");
    }

    public void pesanKopi(int jumlahPesanan) {

        if (jumlahPesanan > stokKopi) {
            throw new KopiHabisException(
                "Maaf, stok kopi tidak mencukupi!"
            );
        }

        stokKopi -= jumlahPesanan;

        System.out.println(
            "Pesanan berhasil. Sisa stok kopi: " + stokKopi
        );
    }
}

