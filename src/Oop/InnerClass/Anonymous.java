package Oop.InnerClass;

import java.util.HashMap;

public class Anonymous {
    public static void main(String[] args) {
        OuterAnonymous outer = new OuterAnonymous("Nested");
        outer.asyncHello();

        HashMap<String, String> map1 = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<>() {}; // 匿名类!
        HashMap<String, String> map3 = new HashMap<>() {
            {
                put("A", "1");
                put("B", "2");
            }
        };

        System.out.println(map3.get("A"));
    }
}

class OuterAnonymous {
    private String name;

    OuterAnonymous(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, " + OuterAnonymous.this.name);
            }
        };
        new Thread(r).start();
    }
}