package Oop;

public class Method {
    public static void main(String[] args) {
        Person p = new Person();
        String bob = "Bob";
        p.setName(bob); // 传入bob变量
        System.out.println(p.getName()); // "Bob"
        bob = "Alice"; // bob改名为Alice， String 类型的数据赋值后就不能修改 ，这里重新赋值 String 变量会重新开辟一块内存存放新的 String 然后 bob 变量指向这块内存
        System.out.println(p.getName()); // "Bob"还是"Alice"? Bob
    }
}


class Person {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}