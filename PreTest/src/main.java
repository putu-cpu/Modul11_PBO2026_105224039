import java.util.Scanner; 
import java.util.InputMismatchException; 

public class main {
    public static void main (String[] args ) {
        Scanner input = new Scanner (System.in); 
        kalkulator kalkulator = new kalkulator(); 
    
        try {
            System.out.println("masukkan pembilang :"); 
           int  pembilang = input.nextInt(); 

            System.out.println("masukkan penyebut :");
            int penyebut = input.nextInt(); 

            int hasil = kalkulator.bagi (pembilang , penyebut); 

            System.out.println("Hasil pembagian =" + hasil);
        } catch (ArithmeticException e) {
            System.out.println("Error gk boleh 0");
        }catch (InputMismatchException e ) {
            System.out.println("error input harus dalam angka");
        }finally {
            input.close();
            System.out.println("kalkulasi selesai");
        }
        }
    }

