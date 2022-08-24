import java.util.Scanner;

public class Laboratorna {
    public static void main(String[] args){ 
        
        System.out.print("\nВведiть номер числа Фiбоначчi [N<=0]: ");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        if (N > 0) {
            System.out.println("\nПомилка!\n");
            System.exit(1);
        }
        Fibonacci object = new Fibonacci();
        System.out.print("\nВаше число: " + object.getNumber(N) + "\n\n");

    }

    static class Fibonacci{
        
        private long num;

        Fibonacci() { num = 0; }

        public long getNumber() { return num; }
        
        public long getNumber(int N){
            if (N < 0){
                long prev = -1, next = -1;
                while (++N < 0){
                    next += prev;
                    prev = next - prev;
                }
                return prev;
            }
            long prev = 0;
            return prev;
        }
    }
}