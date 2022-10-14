package Classes;

import java.util.Scanner;

public class Task6 {
    public  static int[][] Matrix;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Print array size:");
        int arraySize = in.nextInt();
        int[] array = new int[arraySize];
        for (int i=0;i<arraySize;i++)
            array[i] = in.nextInt();
        Matrix = new int[arraySize][arraySize];
        CreateMatrix(array);
        ShowMatrix(arraySize);
    }

    public static void CreateMatrix(int[] array)
    {
        int k=0;
        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array.length;j++)
            {
                Matrix[i][j] = array[(j+k)%array.length];
            }
            k++;
        }
    }

    public  static void ShowMatrix(int size)
    {
        for (int i = 0;i < size;i++ )
        {
            for (int j = 0; j < size; j++)
                System.out.print(Matrix[i][j]+" ");
            System.out.println("");
        }
    }
}
