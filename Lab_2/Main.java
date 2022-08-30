//Product: id, Найменування, Виробник, Ціна, Термін зберігання, Кількість.
//Скласти масив об'єктів. Вивести:
//a) список товарів для заданого найменування;
//b) список товарів для заданого найменування, ціна яких не перевищує задану;
//c) список товарів, термін зберігання яких більше заданого.

package com.company;
import java.util.Scanner;
public class Main {
    public static void enteredName(Product[] array, Scanner in) {
        System.out.print("\nЗадайте найменування товару: ");
        String tovar = in.nextLine();
        int check = 0;
        for (int i = 0; i < array.length; i++) {
            if (tovar.equals(array[i].getName())) {
                System.out.println(check+1 + "." + array[i].toString());
                check++;
            }
        }
        if (check == 0)
            System.out.println("\nНемає товарів із заданим найменуванням!\n");
    }
    public static void entredPrice(Product[] array, Scanner in) {
        System.out.print("\nЗадайте найменування товару: ");
        String tovar = in.nextLine();
        System.out.print("Задайте максимальну ціну товару: ");
        int max = in.nextInt();
        int check = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getPrice() <= max && tovar.equals(array[i].getName())) {
                System.out.println(check+1 + "." + array[i].toString());
                check++;
            }
        }
        if (check == 0)
            System.out.println("\nНемає товарів із таким найменуванням та меншою ціною ніж задана!\n");
    }
    public static void biggerTerm(Product[] array, Scanner in) {
        System.out.print("\nЗадайте мінімальний термін зберігання товару: ");
        double minTerm = in.nextDouble();
        int check = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getTerm() > minTerm) {
                System.out.println(check+1 + "." + array[i].toString());
                check++;
            }
        }
        if (check == 0)
            System.out.println("\nНемає товарів з більшим терміном зберігання!\n");
    }
    public static void printArray(Product[] array){
        System.out.println("\nЕлементи списку\n");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Product[] array = new Product[9];
        array[0] = new Product(1, "Butter", "UK", 120, 12, 50);
        array[1] = new Product(2, "Milk", "UK", 30, 3, 20);
        array[2] = new Product(3, "Butter", "US", 110, 10, 10);
        array[3] = new Product(4, "Bread", "DE", 26, 6, 15);
        array[4] = new Product(5, "Butter", "FR", 100, 12, 20);
        array[5] = new Product(6, "Milk", "DE", 35, 4, 10);
        array[6] = new Product(7, "Bread", "UK", 20, 5, 50);
        array[7] = new Product(8, "Bread", "US", 23, 6, 30);
        array[8] = new Product(9, "Bread", "FR", 25, 5, 20);
        printArray(array);
        System.out.println("\nЗавдання а - список товарів для заданого найменування");
        enteredName(array, in);
        System.out.println("\nЗавдання b - список товарів для заданого найменування, ціна яких не перевищує задану");
        entredPrice(array, in);
        System.out.println("\nЗавдання с - список товарів, термін зберігання яких більше заданого");
        biggerTerm(array,in);
    }
}
