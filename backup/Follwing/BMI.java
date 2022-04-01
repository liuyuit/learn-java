package Follwing;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight;
        weight = scanner.nextDouble();
        System.out.print("input your weight：");

        System.out.print("input your Height：");
        double height;
        height = scanner.nextDouble();

        double bmi;
        bmi = weight / (height * height);
        System.out.printf("your bmi: %.2f", bmi);
        if (bmi >= 25.0) {
            System.out.println("过重：大于 25");
        } else if (bmi >= 18.5) {
            System.out.println("正常：18.5-25");
        } else {
            System.out.println("过轻：低于18.5");
        }
    }
}
