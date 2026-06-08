package exception;

// Checked Exception jika kursi tidak mencukupi
public class TiketHabisException extends Exception {

    // Menyimpan nama kereta
    private String namaKereta;

    // Menyimpan sisa kursi
    private int sisaKursi;

    public TiketHabisException(String namaKereta, int sisaKursi) {

        super("Tiket tidak mencukupi untuk kereta "
                + namaKereta +
                ". Sisa kursi hanya "
                + sisaKursi);

        this.namaKereta = namaKereta;
        this.sisaKursi = sisaKursi;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public int getSisaKursi() {
        return sisaKursi;
    }
}