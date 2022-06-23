package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class AnimatedBufferedImage {
    private BufferedImage[] images;
    private int currentIndex;
    private int frameCounter = 0;
    public int animationSpeed = 10;

    public AnimatedBufferedImage(BufferedImage[] images) {
        this.images = images;
    }

    public AnimatedBufferedImage()
    {

    }

    public AnimatedBufferedImage(String path) {
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        int i = 1;
        while (true) {
            try
            {
                images.add(ImageIO.read(getClass().getResourceAsStream(path + i + ".png")));
            } catch (IllegalArgumentException e) {
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        this.images = images.toArray(new BufferedImage[images.size()]);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getLength() {
        return images.length;
    }

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

    public BufferedImage getImage() {
        return images[currentIndex];
    }

    public BufferedImage getNext() {
        if (images.length == 0) {
            throw new IllegalArgumentException("No images in array");
            //return null;
        }
        BufferedImage image = images[currentIndex];

        currentIndex += 1;
        if (currentIndex >= images.length)
            currentIndex = currentIndex - images.length;
        return image;
    }
}
