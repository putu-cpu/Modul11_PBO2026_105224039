import java.util.Scanner;
import java.util.InputMismatchException;
//no 1
public class HargaMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] harga = new int[3];

        try {
    
            for (int i = 0; i < 4; i++) {
                System.out.print("Masukkan harga menu ke-" + (i + 1) + ": ");
                harga[i] = input.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harga harus berupa angka!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Kapasitas memori harga sudah penuh!");
        }

        input.close();
    }
}