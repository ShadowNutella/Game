package main;

import entity.Entity;
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

    public int checkObject(Player player, boolean playerCollision) {

        int index = 999;

        for (int i = 0; i < gp.items.length; i++) {

            if(gp.items[i] != null) {

                //Get entity's solid Part position
                player.solidPart.x = player.x + player.solidPart.x;
                player.solidPart.y = player.y + player.solidPart.y;

                //Get the object's solid's part position
                gp.items[i].solidPart.x = gp.items[i].x + gp.items[i].solidPart.x;
                gp.items[i].solidPart.y = gp.items [i].y + gp.items[i].solidPart.y;

                switch(player.direction) {
                    case"back":
                        player.solidPart.y -= player.speed;
                        if(player.solidPart.intersects(gp.items[i].solidPart)) {
                            System.out.println("up collision");
                        }
                        break;
                    case"front":
                        player.solidPart.y += player.speed;
                        if(player.solidPart.intersects(gp.items[i].solidPart)) {
                            System.out.println("down collision");
                        }
                        break;
                    case"left":
                        player.solidPart.x -= player.speed;
                        if(player.solidPart.intersects(gp.items[i].solidPart)) {
                            System.out.println("left collision");
                        }
                        break;
                    case"right":
                        player.solidPart.x += player.speed;
                        if(player.solidPart.intersects(gp.items[i].solidPart)) {
                            System.out.println("right collision");
                        }
                        break;
                }
            }
            player.solidPart.x = player.solidPartX;
            player.solidPart.y = player.solidPartY;
            gp.items[i].solidPart.x = gp.items[i].solidPartX;
            gp.items[i].solidPart.y = gp.items[i].solidPartY;
        }

        return index;

    }

}
