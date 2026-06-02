public class SaldoTidakMencukupiExceptions extends Exception {
    private double kekuranganSaldo; 


    public SaldoTidakMencukupiExceptions (String pesan, double kekuranganSaldo) {
        super(pesan); 
        this.kekuranganSaldo = kekuranganSaldo; 
    }
    

    public double getKekuranganSaldo() {
        return kekuranganSaldo; 
    }
}
