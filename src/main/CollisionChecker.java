package main;

import entity.Entity;
import entity.Item;
import entity.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {

        this.gp = gp;

    }

    public void checkTile(Player player) {

        int leftX = player.x + player.solidPart.x;
        int rightX = player.x + player.solidPart.x + player.solidPart.width;
        int topY = player.y + player.solidPart.y;
        int botY = player.y + player.solidPart.y + player.solidPart.height;

        int entityLeftCol = leftX / gp.tileSize;
        int entityRightCol = rightX / gp.tileSize;
        int entityTopRow = topY / gp.tileSize;
        int entityBotRow = botY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (player.direction) {
            case "back" -> {
                entityTopRow = (topY - player.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {

                    player.collisionOn = true;

                }
            }
            case "front" -> {
                entityBotRow = (botY + player.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {

                    player.collisionOn = true;

                }
            }
            case "left" -> {
                entityLeftCol = (leftX - player.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBotRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {

                    player.collisionOn = true;

                }
            }
            case "right" -> {
                entityRightCol = (rightX + player.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {

                    player.collisionOn = true;

                }
            }
        }
    }

    public Item[] checkObjects(Player player) {
        ArrayList<Item> colliding = new ArrayList<Item>();
        for (Item item : gp.items) {
            if(item != null) {
                if (!item.collisionOn)
                    continue;
                // Create two hitboxes to compare them
                Rectangle playerHitbox = new Rectangle(player.x + player.solidPart.x, player.y + player.solidPart.y, player.solidPart.width, player.solidPart.height);
                Rectangle itemHitbox = new Rectangle(item.x + item.solidPart.x, item.y + item.solidPart.y, item.solidPart.width, item.solidPart.height);

                // This switch pretends to move the player by moving the hitbox, therefore checking for collision
                switch (player.direction) {
                    case "back" -> {
                        playerHitbox.y -= player.speed;
                        if (playerHitbox.intersects(itemHitbox)) {
                            System.out.println("up collision");
                            colliding.add(item);
                        }
                    }
                    case "front" -> {
                        playerHitbox.y += player.speed;
                        if (playerHitbox.intersects(itemHitbox)) {
                            System.out.println("down collision");
                            colliding.add(item);
                        }
                    }
                    case "left" -> {
                        playerHitbox.x -= player.speed;
                        if (playerHitbox.intersects(itemHitbox)) {
                            System.out.println("left collision");
                            colliding.add(item);
                        }
                    }
                    case "right" -> {
                        playerHitbox.x += player.speed;
                        if (playerHitbox.intersects(itemHitbox)) {
                            System.out.println("right collision");
                            colliding.add(item);
                        }
                    }
                }
            }
        }
        Item[] collidingArray = new Item[colliding.size()];
        for (int i = 0; i < colliding.size(); i++) {
            collidingArray[i] = colliding.get(i);
        }
        return collidingArray;
    }

}
