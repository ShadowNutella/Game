package entity;

// Base class for enemies
public class Enemy extends Entity {

    public Enemy() {

        super();
    }

    public Enemy(String resourcePath, int x, int y) {
        super(resourcePath, x, y);
    }
}
