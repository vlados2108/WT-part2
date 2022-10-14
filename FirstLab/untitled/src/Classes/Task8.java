package Classes;

import java.util.Scanner;
import java.util.ArrayList;

public class Task8 {
    public  static   Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        double[] a,b;
        System.out.print("Print A array size:");
        int aSize = in.nextInt();
        System.out.println("Enter array A:");
        a = EnterArray(aSize);
        System.out.print("Print B array size:");
        int bSize = in.nextInt();
        System.out.println("Enter array B:");
        b = EnterArray(bSize);
        ArrayList<Double> sequence = Merge(a,b);
        for (int i=0;i<sequence.size();i++)
            System.out.print(sequence.get(i) + " ");
    }

    public  static  double[] EnterArray(int size)
    {
        double[] a = new double[size];
        for (int i=0;i<size;i++)
            a[i] = in.nextDouble();
        return  a;
    }

    public static ArrayList<Double> Merge(double[] a, double[] b){

        if((a == null) || (b == null)) {
            throw new IllegalArgumentException("Sequences can't be null");
        }

        double maxLength = a.length + b.length;
        ArrayList<Double> mergedSequence = new ArrayList<Double>();
        int indexA = 0, indexB = 0;
        int curIndex = 0;

        while (curIndex < maxLength  ) {
            if((indexA < a.length) && (indexB < b.length)) {
                if (a[indexA] == b[indexB] ){
                    mergedSequence.add( a[indexA++]);
                    indexB++;
                    curIndex += 2;
                }
                else if (a[indexA] < b[indexB] ){
                    mergedSequence.add( a[indexA++]);
                    curIndex++;
                }
                else if (b[indexB] < a[indexA]){
                    mergedSequence.add( b[indexB++]);
                    curIndex++;
                }
            }

            if ((indexB >= b.length) && (indexA < a.length) ) {
                mergedSequence.add( a[indexA++]);
                curIndex++;
            }
            else if ((indexA >= a.length) && (indexB < b.length)) {
                mergedSequence.add( b[indexB++]);
                curIndex++;
            }
        }
        return mergedSequence;
    }
}
