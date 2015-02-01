package shop;

import java.util.HashMap;
import java.util.Map;

public class Shelf {

    private static Integer lastId = 0;

    private Integer id;
    private Map<Integer, Product> products = new HashMap();

    public Shelf() {
        id = lastId++;
    }

    protected void addProduct(String pName) {
        Product product = new Product(pName);
    }
    
    protected void addProduct(Product pProduct) {
        products.put(products.size(), pProduct);
    }
    
    public Integer getId() {
        return id;
    }
}