package Classes;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Print array size:");
        int arraySize = in.nextInt();
        int[] table = new int[arraySize];
        for (int i=0;i<arraySize;i++)
            table[i] = in.nextInt();
        int k = getMinElements(table);
        System.out.println("Mininal number of deleted items is: " + k );
    }

    public static int getMinElements(int[] table) {

        int maxIncLen = 0, curInLen = 0;
        boolean isIncrease;

        if (table == null) {
            throw new IllegalArgumentException("Array is empty");
        }

        for (int i = 0; i < table.length; i++) {
            isIncrease = true;
            curInLen = 1;
            for (int j = i + 1; (j < table.length) && isIncrease; j++) {
                if (table[j - 1] < table[j]) {
                    curInLen++;
                } else {
                    isIncrease = false;
                }
            }
            maxIncLen = Math.max(maxIncLen, curInLen);
        }
        return table.length - maxIncLen;
    }
}
