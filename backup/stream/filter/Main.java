package stream.filter;


import java.util.List;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * java src/stream/filter/Main.java
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) {
        List<Person> persons = List.of(new Person("小明", 88), new Person("小黑", 62), new Person("小白", 45),
                new Person("小黄", 78), new Person("小红", 99), new Person("小林", 58));
        // 请使用filter过滤出及格的同学，然后打印名字:
        persons.stream().filter(person -> person.score >= 60).forEach(person -> System.out.println(person.name));
    }
}

class Person {
    String name;
    int score;

    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
}