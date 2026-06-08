package exception;

// Checked Exception jika kode kereta tidak ditemukan
public class RuteTidakDitemukanException extends Exception {

    // Constructor untuk menerima pesan error
    public RuteTidakDitemukanException(String message) {
        super(message);
    }
}