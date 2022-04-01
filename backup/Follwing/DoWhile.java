package Follwing;

public class DoWhile {
    public static void main(String[] args) {
        int sum = 0;
        int m = 20;
        int n = 100;
        int x = m;
        // 使用do while计算M+...+N:
        do {
            sum += x;
            x++;
        } while (x <= 100);
        System.out.println(sum);
    }
}
