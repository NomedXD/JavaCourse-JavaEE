package by.teachmeskills.hw_16062023;

public class Enemy extends Entity{
    private int speed;

    public Enemy(int x, int y, boolean isDynamic, boolean animated, int speed) {
        super(x, y, isDynamic, animated);
        this.speed = speed;
    }

    public Enemy(Enemy enemy){
        super(enemy);
        if(enemy!= null){
            this.speed = enemy.speed;
        }
    }
    @Override
    public Entity clone() {
        return new Enemy(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Enemy) || !super.equals(obj)){
            return false;
        }
        Enemy enemy2 = (Enemy) obj;
        return enemy2.speed == speed;
    }
}
