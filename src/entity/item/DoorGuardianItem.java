package entity.item;

import entity.Player;
import ui.UI;

public class DoorGuardianItem extends TextInteractionItem {

    public DoorGuardianItem(int x, int y, int width, int height) {
        super(x, y, width, height, null, 0);
    }

    public boolean pickUp(Player player)
    {
        if (player.inventory.getKeyCount() < 1)
        {
            //UI.instance.showMessage("You need at least 10 keys to open this door.", 240);
            this.messageDuration = 240;
            this.messageText = "You need at least 10 keys to open this door.";
            startText();
            return false;
        }
        else
        {
            //UI.instance.showMessage("You have opened the door.", 240);
            UI.instance.startClosing(60);
            // doFightScreenStuff();
            return true;
        }
    }
}
