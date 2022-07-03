package entity;

import main.AnimatedBufferedImage;
import main.Camera;

import java.awt.*;

// Base class for all entities in the game, characters, items etc.
public class Entity {

    // Coordinates of entity, measured on top left corner.
    public int x, y;

    // Image of entity.
    public AnimatedBufferedImage image;
    // path to the image file.
    public String resourcePath;
    // x and y size modifier.
    public double sizeX = 1.0, sizeY = 1.0;
    // Priority of drawing, the higher the priority the later it will be drawn (useful for stacking).
    public int drawPriority = 1;
    // Hitbox of entity, measured on top left corner.
    public Rectangle solidPart;
    // If true entity is colliding with something in the current flame -> movement is blocked.
    public boolean collisionOn = false;
    // Sets whether an entity is alive or not. alive -> will be drawn/displayed, not alive -> entity won't be drawn/displayed anymore.
    public boolean alive = true;

    // Constructor. Every entity has an image/a texture.
    public Entity() {

        image = new AnimatedBufferedImage();
    }

    // Constructor. Entity can now have multiple images (for animations) and specific coordinates where it'll be displayed.
    public Entity(String resourcePath, int x, int y) {
        this.resourcePath = resourcePath;
        this.x = x;
        this.y = y;
        loadImages();
    }

    // Loads all needed images from resource path.
    public void loadImages() {

        image = new AnimatedBufferedImage(resourcePath);
    }

    // Skips <animationSpeed> frames before switching to the next image frame.
    public void setAnimationSpeed(int animationSpeed) {

        image.animationSpeed = animationSpeed;
    }


    // Calls the advance method
    public void updateEntity() {
        image.advance();
    }

    // Sets the horizontal (x-axis) size of an entity.
    public void setSizeX(double sizeX) {

        this.sizeX = sizeX;
    }

    // Sets the vertical (y-axis) size modifier of an entity.
    public void setSizeY(double sizeY) {

        this.sizeY = sizeY;
    }

    // Sets the SizeX and SizeY size modifier at once.
    public void setSize(double sizeX, double sizeY) {
        setSizeX(sizeX);
        setSizeY(sizeY);
    }

    // Sets the SizeX and SizeY size modifier at once if SizeX and SizeY are the same by calling the setSize method above.
    public void setSize(double size) {
        setSize(size, size);
    }

    // Draws the entity texture at location x and y.
    public void draw(Graphics2D p) {

        // Multiplies the TileSize with sizeX and sizeY to get the finalSizeX/Y
        int finalSizeX = (int) ((double) Camera.instance.gp.getTileSize() * sizeX);
        int finalSizeY = (int) ((double) Camera.instance.gp.getTileSize() * sizeY);

        // Helps to prevent a game crash and rather draws no image of the Entity.
        if (image != null) {
            // Draws the Entity image at given coordinates.
            p.drawImage(image.getImage(), x - Camera.getAbsoluteX(), y - Camera.getAbsoluteY(), finalSizeX, finalSizeY, null); //* "Malt" den Charakter an Stelle XY plus dessen "Animation"
        }
    }

}

