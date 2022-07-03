package main;

import entity.item.Item;

import java.util.ArrayList;

public class ItemHolder {

    public int HP;
    public int damage;

    public ArrayList<Item> items = new ArrayList<Item>();

    // If this method is called, it adds the item to the list.
    public void collectItem(Item item) {

        items.add(item);

    }

    // Gets the current Number of Keys collected by returning the size of the list.
    public int getKeyCount() {

        return items.size();

    }

    // Sets the Players HP
    public void setHP(int HP) {

        this.HP = HP;

    }

    public void takeDamage(int damage) {

        this.damage = damage;
        HP -= damage;
    }


}
