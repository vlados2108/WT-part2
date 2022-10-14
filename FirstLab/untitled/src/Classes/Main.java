package Classes;

import java.util.Scanner;

import  static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        double x,y,f;
        Scanner in = new Scanner(System.in);
        System.out.println("Input x:");
        x = in.nextDouble();
        System.out.println("Input y:");
        y = in.nextDouble();

        double chisl = 1 + pow(sin(x+y),2);
        double znam = 2 + abs(x - (2*x/(1+pow(x,2)*pow(y,2))));
        f = chisl/znam + x;
        System.out.println("f = " + f);
    }
}