package entity;

public class Projectile extends Entity {

    public int targetX, targetY;
    public double speed;
    public Projectile(String resourcePath, int x, int y, int targetX, int targetY, double speed) {
        super(resourcePath, x, y);
        this.targetX = targetX;
        this.targetY = targetY;
        this.speed = speed;

    }



    public void update() {
        super.update();
        move();
    }

    public void move()
    {
        // Calculate angle for movement from own position to target position and move in that direction multiplied by speed
        double angle = Math.atan2(targetY - y, targetX - x);
        x += (int) (Math.cos(angle) * speed);
        y += (int) (Math.sin(angle) * speed);

        if (y > targetY - 2)
        {
            alive = false; // :(
        }
    }

}

