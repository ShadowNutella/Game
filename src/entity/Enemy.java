package entity;

import main.ItemHolder;
import scene.Scene;

// Base class for enemies
public class Enemy extends Entity {

    public int offsetX;
    public int offsetY;
    public String direction;
    public int damageTake;
    public int enemyHP;

    public Enemy() {
        super();
    }

    public Enemy(String resourcePath, int x, int y) {

        super(resourcePath, x, y);
    }

    // Metod to set the HP for every Enemy.
    public void setEnemyHP(int enemyHP) {

        this.enemyHP = enemyHP;
    }

    // Method to take Damage for every Enemy by substracting the damage taken from the HP of the Enemy.
    public void takeDamage(int damageTake) {

        this.damageTake = damageTake;
        enemyHP -= damageTake;

    }
}
