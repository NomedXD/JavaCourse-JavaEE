package by.teachmeskills.hw_23062023;

import java.util.List;
import java.util.stream.Stream;

public class Run {
    public static void main(String[] args) {
        ShapesContainer shapesContainer = new ShapesContainer();
        SeparateShape separateShape = new SeparateShape("Круг");
        List<Shapes> shapes = Stream.of(shapesContainer, separateShape).toList();
        shapes.forEach(s -> {
            s.move();
            s.draw();
        });
    }
}
