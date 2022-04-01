package Follwing;

import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {
        System.out.println("please choice:");
        System.out.println(" 1: Rock");
        System.out.println(" 2: Scissors");
        System.out.println(" 3: Paper");
        // 用户输入:
        int choice;

        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

        // 计算机随机数 1, 2, 3:
        int random = 1 + (int) Math.random() * 3;
        System.out.printf("computer chose %d \n", random);

        switch (choice - random) {
            case -2:
                System.out.println(" you lose");
                break;
            case -1:
                System.out.println(" you win");
                break;
            case 0:
                System.out.println(" you equals");
                break;
            case 1:
                System.out.println(" you lose");
                break;
            case 2:
                System.out.println(" you win");
                break;
            default:
                System.out.println(" invalid choice");
        }
    }
}
