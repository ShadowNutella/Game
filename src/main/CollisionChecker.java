package main;

import entity.Player;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {

        this.gp = gp;

    }

    public void checkTile(Player player) {

        int entityLeftWorldX = player.x + player.solidPart.x;
        int entityRightWorldX = player.y + player.solidPart.x + player.solidPart.width;
        int entityTopWorldY = player.y + player.solidPart.y;
        int entityBottomWorldY = player.y + player.solidPart.y + player.solidPart.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow= entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(player.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - player.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol] [entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol] [entityTopRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {

                    player.collisionOn = true;

                }
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
