package entity;

// Base class for enemies
public class Enemy extends Entity {

    public int offsetX;
    public int offsetY;
    public String direction;

    public Enemy() {

        super();
    }

    public Enemy(String resourcePath, int x, int y) {

        super(resourcePath, x, y);
    }
}
