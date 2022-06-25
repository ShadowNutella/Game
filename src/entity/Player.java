package entity;

import main.AnimatedBufferedImage;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    String resourcePath;
    public int speed;
    public AnimatedBufferedImage front, back, left, right;
    public String direction;


    public Player(GamePanel gp, KeyHandler keyH, String resourcePath, int speed, int x, int y) {

        this.gp = gp;
        this.keyH = keyH;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.resourcePath = resourcePath;

        solidPart = new Rectangle(6 , 34, 58, 30);

        setDefaultValues();
        getPlayerImage();
    }

    public void setAnimationSpeed(int animationSpeed)
    {
        front.animationSpeed = animationSpeed;
        back.animationSpeed = animationSpeed;
        left.animationSpeed = animationSpeed;
        right.animationSpeed = animationSpeed;
    }

    public void setDefaultValues() {

        direction = "right";
    }

    public void getPlayerImage() {


        // wir brauchen hier dieses große zeug gleich nicht mehr, hehe :))
        front = new AnimatedBufferedImage(resourcePath + "front");
        back = new AnimatedBufferedImage(resourcePath + "back");
        left = new AnimatedBufferedImage(resourcePath + "left");
        right = new AnimatedBufferedImage(resourcePath + "right");


    }

    public void update() {
        front.advance();
        back.advance();
        left.advance();
        right.advance();
    }

    public void updatePlayerOne() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            //Player 1
            if (keyH.upPressed) {
                direction = "back";

            } else if (keyH.downPressed) {
                direction = "front";
                y += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                x += speed;
            }

            //Check Tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //If collision is false, player can move
            if (collisionOn == false) {

                switch (direction) {
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        break;
                    case "left":
                        break;
                    case "right":
                        break;
                }

            }

            /*spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }*/
        }
        else
        {
            setAnimationSpeed(0);
        }

    }

    public void updatePlayerTwo() {
        if (keyH.upPressed2 || keyH.downPressed2 || keyH.leftPressed2 || keyH.rightPressed2) {

            //Player 2
            if (keyH.upPressed2) {
                direction = "back";
                y -= (speed + 1);
            } else if (keyH.downPressed2) {
                direction = "front";
                y += (speed + 1);
            } else if (keyH.leftPressed2) {
                direction = "left";
                x -= (speed + 1);
            } else if (keyH.rightPressed2) {
                direction = "right";
                x += (speed + 1);
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            /*spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }*/
        }
        else
        {
            setAnimationSpeed(0);
        }
    }

    public void draw(Graphics2D p) {

        BufferedImage image = null;

        switch (direction) {
            case "back":
                /*if (spriteNum == 1) {
                    image = back1;
                }
                if (spriteNum == 2) {
                    image = back2;
                }*/
                image = back.getImage();
                break;
            case "front":
                /*if (spriteNum == 1) {
                    image = front1;
                }
                if (spriteNum == 2) {
                    image = front2;
                }*/
                image = front.getImage();
                break;
            case "left":
                /*if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }*/
                image = left.getImage();
                break;
            case "right":
                /*if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }*/
                image = right.getImage();
                break;
        }
        int finalSizeX = (int) (Camera.instance.gp.tileSize * sizeX);
        int finalSizeY = (int) (Camera.instance.gp.tileSize * sizeY);
        p.drawImage(image, x - Camera.getAbsoluteX(), y - Camera.getAbsoluteY(), finalSizeX, finalSizeY, null); //* "Malt" den Charakter an Stelle XY plus dessen "Animation"
    }
}
