package Array;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length; i++) {
            // 下面的循环是为了将排在第 i 位的元素通过将第 i 位的元素逐一于 i 到 ns.length 的元素进行比较，若 ns[i] 较大，则将 ns[i] 与 ns[n] 调换位置
            // 如果将 int n = i + 1; 改为 int n = i++; 则会改变 i 的值，结果会出错
            for (int n = i + 1; n < ns.length; n++){
                if (ns[i] > ns[n]) {
                    int temp = ns[i];
                    ns[i] = ns[n];
                    ns[n] = temp;
                }
            }
        }
        // 排序后:
        System.out.println(Arrays.toString(ns));
        System.out.println("===============");
        main2();
    }



    public static void main2() {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length; i++) {
            // 下面的循环是为了将排在第 i 位的元素通过将第 i 位的元素逐一于 i 到 ns.length 的元素进行比较，若 ns[i] 较大，则将 ns[i] 与 ns[n] 调换位置
            // 如果将 int n = i + 1; 改为 int n = i++; 则会改变 i 的值，结果会出错
            for (int n = i + 1; n < ns.length; n++){
                if (ns[i] < ns[n]) {
                    int temp = ns[i];
                    ns[i] = ns[n];
                    ns[n] = temp;
                }
            }
        }

        // 排序后:
        System.out.println(Arrays.toString(ns));
        if (Arrays.toString(ns).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }






    public static void main1(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j+1]) {
                    // 交换ns[j]和ns[j+1]:
                    int tmp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                }
            }
        }
        // 排序后:
        System.out.println(Arrays.toString(ns));
    }
}
