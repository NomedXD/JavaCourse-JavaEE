package by.teachmeskills.hw_16062023;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<Entity> shapes = new ArrayList<>();
        List<Entity> shapesCopy = new ArrayList<>();
        Player player = new Player(12,12,true,true,10);
        shapes.add(player);
        Player secondPlayer = (Player) player.clone();
        shapesCopy.add(secondPlayer);

        Enemy enemy = new Enemy(25,25,true,false,12);
        shapes.add(enemy);
        Enemy secondEnemy = (Enemy) enemy.clone();
        shapesCopy.add(secondEnemy);
        cloneAndCompare(shapes,shapesCopy);
    }

    private static void cloneAndCompare(List<Entity> shapes, List<Entity> shapesCopy) {
        for (Entity shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
