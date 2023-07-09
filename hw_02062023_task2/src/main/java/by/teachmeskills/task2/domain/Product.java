package by.teachmeskills.task2.domain;

public class Product extends BaseEntity{
    private String name;
    private String imagepath;
    private String description;
    private int categoryid;
    private float price;

    public Product(){

    }

    public Product(int id, String name, String imagepath, String description, int categoryid, float price) {
        this.id = id;
        this.name = name;
        this.imagepath = imagepath;
        this.description = description;
        this.categoryid = categoryid;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImagepath() {
        return imagepath;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public float getPrice() {
        return price;
    }
}
