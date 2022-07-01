package entity.item;

import entity.Player;
import scene.LevelStatus;
import ui.UI;

public class DoorGuardianItem extends TextInteractionItem {

    public DoorGuardianItem(int x, int y, int width, int height) {
        super(x, y, width, height, null, 0);
    }

    public boolean pickUp(Player player)
    {
        if (player.inventory.getKeyCount() < 10)
        {

            this.messageDuration = 240;
            this.messageText = "You need 10 keys to open this door.";
            startText();
            return false;
        }
        else
        {
            UI.instance.startClosing(60, LevelStatus.WON);
            return true;
        }
    }
}
