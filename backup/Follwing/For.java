package Follwing;

public class For {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i = 0; i < ns.length; i++) {
            System.out.println(ns[i]);
        }
        System.out.println("----------");
        main1();
        System.out.println("----------");
        main2();
        System.out.println("----------");
    }

    public static void main1() {
        int[] ns = { 1, 4, 9, 16, 25 };
        int sum = 0;
        for (int n : ns) {
            sum += n;
        }
        System.out.println(sum); // 55
    }

    public static void main2() {
        double pi = 0;
        boolean plus = true;
        for (int i = 1; i <= 10000; i = i + 2) {
            if (plus) {
                pi = pi + 1.0 / i;
                //System.out.printf("pi + 1.0 / %d = %.4f\n", i, pi);
            } else {
                pi = pi - 1.0 / i;
                //System.out.printf("pi - 1.0 / %d = %.4f\n", i, pi);
            }

            plus = !plus;
        }
        pi *= 4;
        System.out.println(pi);
    }
}
