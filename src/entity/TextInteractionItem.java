package entity;

import main.UI;

import java.awt.*;

public class TextInteractionItem extends Item {

    public String messageText;
    public int messageDuration;

    private int currentDuration=0;

    public TextInteractionItem(int x, int y, int width, int height, String messageText, int messageDuration) {
        super(null, x, y, null);
        solidPart.width = width;
        solidPart.height = height;
        this.messageText = messageText;
        this.messageDuration = messageDuration;
        collisionOn = true;
    }

    public void loadImages() { }

    public void draw(Graphics2D p) {
        if (messageText == null || currentDuration <= 0)
            return;
        p.setFont(UI.instance.arial_30);
        p.setColor(Color.LIGHT_GRAY);

        p.drawString(messageText, 20, 80);
        currentDuration--;
    }

    void startText()
    {
        currentDuration = messageDuration;
    }

    public boolean pickUp(Player player) {
        //UI.instance.showMessage(messageText, messageDuration);
        startText();
        return false;
    }

}
