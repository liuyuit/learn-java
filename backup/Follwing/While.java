package Follwing;

public class While {
    public static void main(String[] args) {
        int sum = 0;
        int m = 20;
        int n = 100;
        // 使用while计算M+...+N:
        int x = m;
        while (x <= n) {
            sum += x;
            x++;
        }
        System.out.println(sum);
    }
}
