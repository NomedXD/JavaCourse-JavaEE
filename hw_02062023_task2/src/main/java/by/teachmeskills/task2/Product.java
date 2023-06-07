package by.teachmeskills.task2;

public class Product {
    private final int id;
    private final String name;
    private final String imagepath;
    private final String description;
    private final int categoryid;
    private final String price;

    public Product(int id, String name, String imagepath, String description, int categoryid, String price) {
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

    public String getPrice() {
        return price;
    }
}
