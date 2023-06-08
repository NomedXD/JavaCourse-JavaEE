package by.teachmeskills.hw_16062023;

public class Player extends Entity{
    private int bullets;

    public Player(int x, int y, boolean isDynamic, boolean animated, int bullets) {
        super(x, y, isDynamic, animated);
        this.bullets = bullets;
    }

    public Player(Player player){
        super(player);
        if(player!= null){
            this.bullets = player.bullets;
        }
    }
    @Override
    public Entity clone() {
        return new Player(this);
    }

    @Override
    public boolean equals(Object obj) {
       if(!(obj instanceof Player) || !super.equals(obj)){
           return false;
       }
       Player player2 = (Player) obj;
       return player2.bullets == bullets;
    }
}
