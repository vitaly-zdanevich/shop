package shop;

public class Product {

    protected static Integer lastId = 0;

    protected Integer id;

    protected String name;

    public Product(String pName) {
        name = pName;
        id = lastId++;
    }

}