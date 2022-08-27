import java.util.Scanner;

public class Laboratorna {
    public static void main(String[] args){ 
        
        System.out.print("\nВведiть номер числа Фiбоначчi [N<=0]: ");
        Scanner input = new Scanner(System.in);
        int pozucia = input.nextInt();
        if (pozucia > 0) {
            System.out.println("\nПомилка!\n");
            System.exit(1);
        }
        Fibonacci object = new Fibonacci();
        System.out.print("\nВаше число: " + object.getNumber(pozucia) + "\n\n");

    }

    static class Fibonacci{

        public long getNumber(int pozucia){
            if (pozucia < 0){
                int remember = pozucia;
                pozucia = Math.abs(pozucia);
                long prev = 1, next = 1;
                while (--pozucia > 0){
                    next += prev;
                    prev = next - prev;
                }
                return prev = (long)(Math.pow(-1, remember+1) * prev);
            }
            long prev = 0;
            return prev;
        }
    }
}
