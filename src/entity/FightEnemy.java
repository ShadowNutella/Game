package entity;

import entity.item.Projectile;

public class FightEnemy extends Enemy {

    // Adding targets, color for projectiles and damage output for the FightEnemies.
    public Entity target;
    public String projectileFarbe;
    public int damage;

    public FightEnemy(String resourcePath, int x, int y, Entity target, int damageEnemy) {
        super(resourcePath, x, y);
        this.target = target;
        this.damage = damageEnemy;
    }

    // Method, to spawn projectiles which will fly to the target.
    public Projectile shoot()
    {
        Projectile projectile = new Projectile("/objects/projectile/flame_" + projectileFarbe + "_", x, y, target.x, target.y, 10, damage);
        projectile.drawPriority = 105;
        projectile.setSize(0.8);
        return projectile;
    }

}
