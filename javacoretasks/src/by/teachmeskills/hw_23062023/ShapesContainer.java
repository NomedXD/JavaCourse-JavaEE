package by.teachmeskills.hw_23062023;

import java.util.ArrayList;
import java.util.List;

public class ShapesContainer implements Shapes{
    private final List<Shapes> shapes;

    public ShapesContainer() {
        this.shapes = new ArrayList<>();
        shapes.add(new SeparateShape("Точка"));
        shapes.add(new SeparateShape("Прямоугольник"));
    }
    public void addShape(Shapes shape){
        shapes.add(shape);
    }

    public void removeShape(Shapes shape){
        shapes.remove(shape);
    }

    @Override
    public void move() {
        shapes.forEach(Shapes::move);
    }

    @Override
    public void draw() {
        shapes.forEach(Shapes::draw);
    }
}
