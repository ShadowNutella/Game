package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {

        this.gp = gp;

    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.x + entity.solidPart.x;
        int entityRightWorldX = entity.y + entity.solidPart.x + entity.solidPart.width;
        int entityTopWorldY = entity.y + entity.solidPart.y;
        int entityBottomWorldY = entity.y + entity.solidPart.y + entity.solidPart.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow= entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(player.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - player.speed);
                break;
            case"down":
                break;
            case"left":
                break;
            case "right":
                break;
        }

    }

}
