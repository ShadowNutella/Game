package entity;

import entity.item.Item;
import scene.LevelStatus;
import ui.UI;

import java.awt.*;

public class Projectile extends Item {

    public int targetX, targetY;
    public double speed;
    public int damage;


    public Projectile(String resourcePath, int x, int y, int targetX, int targetY, double speed, int damage) {
        super(resourcePath, x, y);
        this.targetX = targetX;
        this.targetY = targetY;
        this.speed = speed;
        this.damage = damage;
        solidPart = new Rectangle(0, 0, 64, 64);
        collisionOn = true;

    }


    public boolean pickUp(Player player) {

        if (alive) {
            UI.instance.showMessage("You got hit, idiot", 30);
            //UI.instance.startClosing(60, LevelStatus.WON);
            player.inventory.takeDamage(damage);

            if (player.inventory.HP <= 0) {
                player.inventory.HP = 0;
                UI.instance.startClosing(60, LevelStatus.LOST);
            }
        }


        return true;
    }

    public void updateEntity() {
        super.updateEntity();
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

