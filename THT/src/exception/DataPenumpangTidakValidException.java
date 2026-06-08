package exception;

// Unchecked Exception untuk NIK yang tidak valid
public class DataPenumpangTidakValidException extends RuntimeException {

    // Constructor untuk menerima pesan error
    public DataPenumpangTidakValidException(String message) {
        super(message);
    }
}