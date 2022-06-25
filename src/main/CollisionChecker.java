package main;

import entity.Player;

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

            case "back":
                entityTopRow = (topY - player.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {

                    player.collisionOn = true;

                }
                break;

            case "front":
                entityBotRow = (botY + player.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {

                    player.collisionOn = true;

                }
                break;

            case "left":
                entityLeftCol = (leftX - player.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBotRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {

                    player.collisionOn = true;

                }
                break;

            case "right":
                entityRightCol = (rightX + player.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {

                    player.collisionOn = true;

                }
                break;



        }
    }
}
