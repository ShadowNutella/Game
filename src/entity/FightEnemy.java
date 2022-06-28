package entity;

public class FightEnemy extends Enemy {

    public Entity target;
    public FightEnemy() {

        super();
    }

    public FightEnemy(String resourcePath, int x, int y, Entity target) {
        super(resourcePath, x, y);
        this.target = target;
    }

    public Projectile shoot()
    {
        Projectile projectile = new Projectile("/objects/projectile/flame_blau_", x, y, target.x, target.y, 3);
        projectile.setSize(0.8);
        return projectile;
    }
}
