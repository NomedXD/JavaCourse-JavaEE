package by.teachmeskills.hw_23062023;

public class SeparateShape implements Shapes {
    private final String name;

    public SeparateShape(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.printf("Отдельная фигура %s самостоятельно передвинулась\n", name);
    }

    @Override
    public void draw() {
        System.out.printf("Отдельная фигура %s отобразилась на экране\n", name);
    }
}
