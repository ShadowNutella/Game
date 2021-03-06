package entity.item;

import entity.Player;
import main.AnimatedBufferedImage;

public class Particle extends Item {

    public int duration;

    public Particle(String resourcePath, int x, int y, int duration) {
        super(resourcePath, x, y);
        this.duration = duration;
    }

    public boolean pickUp(Player player) {
        return true;
    }

    public void updateEntity() {
        super.updateEntity();
        duration--;

        if (duration == 0) {
            alive = false;
        }
    }

    public void loadImages() {

        image = new AnimatedBufferedImage(resourcePath, true);
    }

}
