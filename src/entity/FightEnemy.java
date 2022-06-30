package entity;

public class FightEnemy extends Enemy {

    public Entity target;
    public String projectileFarbe;
    public int enemyHP;
    public int damage;

    public FightEnemy() {

        super();
    }

    public FightEnemy(String resourcePath, int x, int y, Entity target, int damageEnemy) {
        super(resourcePath, x, y);
        this.target = target;
        this.damage = damageEnemy;
    }

    public Projectile shoot()
    {
        Projectile projectile = new Projectile("/objects/projectile/flame_" + projectileFarbe + "_", x, y, target.x, target.y, 10, damage);
        projectile.drawPriority = 105;
        projectile.setSize(0.8);
        return projectile;
    }

    public void setEnemyHP(int enemyHP) {

        this.enemyHP = enemyHP;
    }
}
