package apps.sffa.com.ainaki.model;

/**
 * Created by Diako on 21/05/2018.
 */

public class Product {


    private int id;
    private String name;


    public Product(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
