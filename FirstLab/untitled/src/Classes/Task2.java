package Classes;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        double x,y;
        Scanner in = new Scanner(System.in);
        System.out.println("Input x:");
        x = in.nextDouble();
        System.out.println("Input y:");
        y = in.nextDouble();

        if (x>=-6 && x < -4)
            if (y>=-3 && y<=0)
                System.out.println("true");
            else
                System.out.println("false");

        if (x>=-4 && x <= 4)
            if (y>=-3 && y<=5)
                System.out.println("true");
            else
                System.out.println("false");

        if (x>4 && x <=6)
            if (y>=-3 && y<=0)
                System.out.println("true");
            else
                System.out.println("false");
    }
}
