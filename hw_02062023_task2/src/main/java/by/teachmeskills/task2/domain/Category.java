package by.teachmeskills.task2.domain;

public class Category extends BaseEntity{
    private final String name;
    private final String imagepath;
    private final String sometext;

    public Category(int id, String name, String imagepath, String sometext) {
        this.id = id;
        this.name = name;
        this.imagepath = imagepath;
        this.sometext = sometext;
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

    public String getSometext() {
        return sometext;
    }
}
