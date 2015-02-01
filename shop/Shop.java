package shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class Shop {

    private static Map<String, Department> departments = new HashMap<>();
    private static Scanner input = new Scanner(System.in);

    private static void addDepartment() {
        System.out.print("Enter name of new department: "); String nameDepartment = input.next();
        System.out.print("Is it food department? true/false: "); String isFoodDepartment = input.next();
        Department department = new Department(nameDepartment, new Boolean(isFoodDepartment));
        departments.put(nameDepartment, department);
        System.out.println("Department created, id: " + department.getId() + "\n");
        main(new String[0]);
    }

    private static void addShelf() {
        if (departments.size() == 0) {
            System.out.println("You not have any department - before adding shelf - create any department");
        } else {
            System.out.print("In what department adding shell?\n");
            Department[] arrayDepartments = new Department[departments.size()];
            Set<String> keySetNameDepartments = departments.keySet();
            int i = 0;  
            for (String departmentName : keySetNameDepartments) {
                System.out.print(i + " " + departmentName + "\n");
                arrayDepartments[i++] = departments.get(departmentName);
            }
            System.out.print("Enter number: "); String departmentNumber = input.next();
            // System.out.println("DEBUG: arrayDepartments:");
            // for (Department department : arrayDepartments) {
            //     System.out.println(department.getName());
            // }
            Department department = arrayDepartments[new Integer(departmentNumber)];
            Shelf shelf = department.addShelf();
            System.out.println("Shelf added with id: " + shelf.getId() + "\n");
            main(new String[0]);
        }
    }

    private static void addProduct() {
        System.out.print("Name of your product?: "); String productName = input.next();
        System.out.print("Book or Fruit?: "); String bookOrFruit = input.next();
        switch (bookOrFruit.toLowerCase()) {
            case "fruit": addProduct(new Fruit(productName));
            case "book" : addProduct(new Book(productName));
        }
    }
    
    public static void main (String[] args) {
        System.out.println("1. Add department");
        System.out.println("2. Add shelf");
        System.out.println("3. Add product ");
        System.out.print(": "); String choice = input.next();
        switch (choice) {
            case "1": addDepartment();
            case "2": addShelf();
            case "3": addProduct();
        }
    }
    
    private static void addProduct(Product product) {
        Department[] departmentsArray = new Department[departments.size()];
        System.out.println("Select department for your new product:");
        Set<String> departmentsKeySet = departments.keySet();
        int i = 0;
        for (String departmentName : departmentsKeySet) {
            Department department = departments.get(departmentName);
            if (department.isFoodDepartment() == product instanceof Fruit) {
                departmentsArray[i] = department;
                System.out.println(i++ + " " + department.getName());
            }
        }
        System.out.print("In what department add your new product?:"); String departmentNum = input.next();
        Department department = departmentsArray[new Integer(departmentNum)];
        int shelves = department.getShelves().size();
        if (shelves == 0) {
            System.out.println("For adding product you need add shelf first");
        } else {
            System.out.println("\nIn what shelf we will need add your product?: ");
            for (i = 0; i < shelves; i++) {
                System.out.println(i);
            }
            System.out.print(":"); String shelvNum = input.next();
            Shelf shelf = department.getShelves().get(new Integer(shelvNum));
            shelf.addProduct(product);
            System.out.println("product added");            
        }
        main(new String[0]);
    }
}