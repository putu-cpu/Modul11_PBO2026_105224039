public class Main {

    public static void main(String[] args) {

        AkunBank akun1 = new AkunBank("123456789", 5000000);
        AkunBank akun2 = new AkunBank("987654321", 2000000);

        try {

            System.out.println("=== TRANSAKSI ATM ===\n");

            akun1.tarikTunai(3000000);

            akun1.tarikTunai(2500000);

            akun1.transfer(akun2, 12000000);

        }

        catch (SaldoTidakMencukupiExceptions e) {

            System.out.println("\nerror saldo");
            System.out.println(e.getMessage());
            System.out.println("Kekurangan saldo: Rp"
                    + e.getKekuranganSaldo());
        }

        catch (BatasTransferHarianException e) {

            System.out.println("\n[ERROR LIMIT TRANSFER]");
            System.out.println(e.getMessage());
        }

        finally {

            System.out.println(
                    "\nSesi transaksi ATM Anda telah diakhiri. " +
                    "Kartu dikeluarkan otomatis.");
        }
    }
}