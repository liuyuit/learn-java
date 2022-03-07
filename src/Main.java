public class Main {
    public static void main(String[] args) {
    }
}

class Person {
    public void run() {}
}

class Student extends Person {
    @Override // Compile error!
    public void run() {}
}
