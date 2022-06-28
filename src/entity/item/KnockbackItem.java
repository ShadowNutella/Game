package entity.item;

import entity.PatrolEnemy;
import entity.Player;

public class KnockbackItem extends TextInteractionItem {
    private PatrolEnemy owner;
    public KnockbackItem(int x, int y, int width, int height, PatrolEnemy owner) {
        super(x, y, width, height, null, 0);
        this.owner = owner;
    }

    public boolean pickUp(Player player) {
        if (owner.moveLeft)
        {
            player.x -= player.speed * 1.5;
        }
        else
        {
            player.x += player.speed * 1.5;
        }
        return false;
    }
}
