package entity;

public class FightEnemy extends Enemy {

    public Entity target;
    public String projectileFarbe;

    public FightEnemy() {

        super();
    }

    public FightEnemy(String resourcePath, int x, int y, Entity target) {
        super(resourcePath, x, y);
        this.target = target;
    }

    public Projectile shoot()
    {
        Projectile projectile = new Projectile("/objects/projectile/flame_" + projectileFarbe + "_", x, y, target.x, target.y, 10);
        projectile.drawPriority = 105;
        projectile.setSize(0.8);
        return projectile;
    }
}
