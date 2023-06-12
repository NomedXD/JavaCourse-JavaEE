package by.teachmeskills.hw_16062023;

public abstract class Entity {
    private int x;
    private int y;
    private boolean isDynamic;
    private boolean animated;

    public Entity(int x, int y, boolean isDynamic, boolean animated) {
        this.x = x;
        this.y = y;
        this.isDynamic = isDynamic;
        this.animated = animated;
    }

    public Entity(Entity entity){
        if(entity!=null){
            this.x = entity.x;
            this.y = entity.y;
            this.isDynamic = entity.isDynamic;
            this.animated = entity.animated;
        }
    }
    public abstract Entity clone();

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Entity)){
            return false;
        }
        Entity entity2 = (Entity) obj;
        return entity2.x == x && entity2.y == y && entity2.isDynamic == isDynamic && entity2.animated == animated;

    }
}
