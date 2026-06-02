public class AkunBank {
    
    private String nomorRekening; 
    private double saldo; 
    private double totalTransferHarian; 

    private final double LIMIT_TRANSFER = 10000000; 

    public AkunBank (String nomorRekening , double saldo) {
        this.nomorRekening = nomorRekening; 
        this.saldo = saldo; 
        this.totalTransferHarian = 0; 
    }

    public String getNomorRekening () {
        return nomorRekening; 
    }

    public double getSaldo() {
        return saldo; 
    }

    public void tarikTunai (double nominal ) 
    throws SaldoTidakMencukupiExceptions {

        if (nominal > saldo) {
            double kekurangan = nominal - saldo; 

            throw new SaldoTidakMencukupiExceptions("Saldo tidak mencukupi untuk penarikan", kekurangan); 
        }

        saldo-=nominal; 

        System.out.println("Tarik tunai berhasil Rp :" + nominal);
        System.out.println("Sisa saldo : Rp " + saldo);
    }

    public void transfer (AkunBank tujuan , double nominal)
    throws SaldoTidakMencukupiExceptions, BatasTransferHarianException {

        if ((totalTransferHarian + nominal ) > LIMIT_TRANSFER) {
            throw new BatasTransferHarianException("Transferk melebihi batas harian Rp 10.000.000"); 

        }
        if (nominal > saldo ) {
            double kekurangan = nominal - saldo; 

            throw new SaldoTidakMencukupiExceptions("Saldo tidak mencukupi untuk transfer", kekurangan); 
        }

        saldo -= nominal; 
        tujuan.saldo += nominal; 
        totalTransferHarian += nominal; 

        System.out.println("Transfer berhasil sebesar Rp" + nominal);
    }
         
}
