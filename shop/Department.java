package shop;

import java.util.HashMap;
import java.util.Map;

public class Department {

    private static Integer lastId = 0;

    private Integer id;
    private String name;
    private boolean isFoodDepartment;
    private Map<Integer, Shelf> shelves = new HashMap();

    public Department(String pName, boolean pIsFoodDepartment) {
        name = pName;
        isFoodDepartment = pIsFoodDepartment;
        id = lastId++;
    }

    protected Shelf addShelf() {
        Integer id = ++lastId;
        Shelf shelf = new Shelf();
        shelves.put(id, shelf);
        return shelf;
    }

    protected boolean isFoodDepartment() {
        return isFoodDepartment;
    }

    protected Integer getId() {
        return id;
    }

    protected Map<Integer, Shelf> getShelves() {
        return shelves;
    }
    
    public String getName() {
        return name;
    }
}