package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// Similar to the class BufferedImage, but working with several Frames for one Texture to create an animation.
public class AnimatedBufferedImage {
    private BufferedImage[] images;
    private int currentIndex;
    private int frameCounter = 0;
    public int animationSpeed = 10;


    public AnimatedBufferedImage() {

    }

    // Used for Particle Animations.
    public AnimatedBufferedImage(String path, boolean randomStartFrame)
    {
        this(path, 1, randomStartFrame);
    }

    public AnimatedBufferedImage(String path) {
        this(path, 1, false);
    }


    public AnimatedBufferedImage(String path, int startIndex, boolean randomStartFrame) {
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        int i = startIndex;
        while (true) {
            // Depending on the Files name, choose the right one.
            try {
                images.add(ImageIO.read(getClass().getResourceAsStream(path + i + ".png")));
            } catch (IllegalArgumentException e) {
                if (images.size() == 0) {
                    try {
                        images.add(ImageIO.read(getClass().getResourceAsStream(path + ".png")));
                    } catch (IOException ex) {
                        e.printStackTrace();
                    }
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Increase i to get the next File for the Animation.
            i++;
        }
        if (randomStartFrame)
        {
            currentIndex = (int) (Math.random() * images.size());
        }
        else
        {
            currentIndex = 0;
        }
        this.images = images.toArray(new BufferedImage[images.size()]);
    }


    // Advances to the next frame, if no next frame exists, reset to zero.
    public void advance() {
        if (images == null || animationSpeed == 0)
            return;
        frameCounter++;
        if (frameCounter >= animationSpeed) {
            frameCounter = 0;
            currentIndex++;
            if (currentIndex >= images.length) {
                currentIndex = 0;
            }
        }
    }

    // Gets the right Image for the current Index.
    public BufferedImage getImage() {

        return images[currentIndex];
    }

    // Get a specific Frame of an Animation.
    public BufferedImage getFrame(int i) {

        return images[i];
    }

}
