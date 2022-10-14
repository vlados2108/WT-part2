package Classes;

import java.util.*;
import java.util.List;
public class Task9 {
    public static void main(String[] args)
    {
        Basket basket = new Basket();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter num of balls: ");
        int numOfBalls = in.nextInt();
        for (int i=0;i<numOfBalls;i++)
        {
            int weight = 0;
            String color = "No color";
            try {
                System.out.print("Enter weight of ball " + i + ": ");
                weight = in.nextInt();
                System.out.print("Enter color of ball " + i + ": ");
                color = in.next();
            }
            catch (Exception ex)
            {
                System.out.println(ex.toString());
            }

            Ball ball = new Ball(weight,color);
            basket.AddBall(ball);
        }

        System.out.println("Sum weight of balls in basket = " + basket.GetSumWeight());
        System.out.println("Number of blue balls in basket = " + basket.GetNumOfBlueBalls());

    }

    public static class Ball{
        private int  weight;
        private String color;

        public  Ball(int weight,String color)
        {
            this.weight = weight;
            this.color = color;
        }

        public int GetWeight()
        {
            return this.weight;
        }

        public void SetWeight(int weight)
        {
            this.weight = weight;
        }

        public String GetColor()
        {
            return this.color;
        }

        public void SetColor(String color)
        {
            this.color = color;
        }

    }

    public static class Basket{

        private ArrayList<Ball>  balls = new ArrayList<Ball>();

        public void AddBall(Ball ball)
        {
            balls.add(ball);
        }

        public int GetSumWeight()
        {
            int sumWeight=0;
            for( int i =0;i< balls.size();i++)
                sumWeight += balls.get(i).GetWeight();
            return  sumWeight;
        }

        public int GetNumOfBlueBalls()
        {
            int num=0;
            String color = "";
            for( int i =0;i< balls.size();i++)
            {
                color = balls.get(i).GetColor();
                if (Objects.equals(color, "Blue"))
                    num+=1;
            }
            return  num;
        }

    }
}
