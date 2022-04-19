package pattern.observer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) {
        // observer:
        Admin a = new Admin();
        Customer c = new Customer();
        // store:
        Store store = new Store();
        // register:
        store.addObserver(a);
        store.addObserver(c);
        // 注册匿名观察者:
        store.addObserver(new ProductObserver() {
            @Override
            public void onPublished(ObserverProduct observerProduct) {
                System.out.println("[Log] on product published: " + observerProduct);
            }

            @Override
            public void onPriceChanged(ObserverProduct observerProduct) {
                System.out.println("[Log] on product price changed: " + observerProduct);
            }
        });
        // operation:
        store.addNewProduct("Design Patterns", 35.6);
//        store.addNewProduct("Effective Java", 50.8);
//        store.setProductPrice("Design Patterns", 31.9);
    }
}

class Customer implements ProductObserver {

    public void onPublished(ObserverProduct observerProduct) {
        System.out.println("[Customer] on product published: " + observerProduct);
    }

    public void onPriceChanged(ObserverProduct observerProduct) {
        System.out.println("[Customer] on product price changed: " + observerProduct);
    }
}

class Admin implements ProductObserver {

    public void onPublished(ObserverProduct observerProduct) {
        System.out.println("[Admin] on product published: " + observerProduct);
    }

    public void onPriceChanged(ObserverProduct observerProduct) {
        System.out.println("[Admin] on product price changed: " + observerProduct);
    }
}

class ObserverProduct {

    private String name;
    private double price;

    public ObserverProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("{Product: name=%s, price=%s}", name, price);
    }
}

interface ProductObservable {



}

interface ProductObserver {

    void onPublished(ObserverProduct observerProduct);

    void onPriceChanged(ObserverProduct observerProduct);
}

class Store {

    private List<ProductObserver> observers = new ArrayList<>();
    private Map<String, ObserverProduct> products = new HashMap<>();

    public void addObserver(ProductObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(ProductObserver observer) {
        this.observers.remove(observer);
    }

    public void addNewProduct(String name, double price) {
        ObserverProduct p = new ObserverProduct(name, price);
        products.put(p.getName(), p);
        observers.forEach(o -> o.onPublished(p));
    }

    public void setProductPrice(String name, double price) {
        ObserverProduct p = products.get(name);
        p.setPrice(price);
        observers.forEach(o -> o.onPriceChanged(p));
    }
}

class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("{Product: name=%s, price=%s}", name, price);
    }
}