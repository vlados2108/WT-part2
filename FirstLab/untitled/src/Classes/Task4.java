package Classes;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Print array size:");
        int arraySize = in.nextInt();
        int[] numbers = new int[arraySize];
        for (int i=0;i<arraySize;i++)
            numbers[i] = in.nextInt();
        for (int i=0;i<arraySize;i++)
        {
            if (isPrime(numbers[i]))
            {
                System.out.printf("%d ",i);
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i=2;i<number;i++) {
            if (number % i==0) {
                return false;
            }
        }
        return true;
    }
}
