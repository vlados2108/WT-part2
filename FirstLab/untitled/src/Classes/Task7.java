package Classes;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Print array size:");
        int arraySize = in.nextInt();
        int[] array = new int[arraySize];
        for (int i=0;i<arraySize;i++)
            array[i] = in.nextInt();
        array = ShellSort(array);
        System.out.println("Sorted array:");
        for (int i=0;i<arraySize;i++)
            System.out.print(array[i] + " ");

    }

    public static int[] ShellSort(int[] array)
    {
        int i = 0;
        while (i < array.length - 1)
        {
            if (array[i] <= array[i + 1])
                i++;
            else
            {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                if (i != 0)
                    i--;
            }
        }
        return array;
    }
}
