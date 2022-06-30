package main;

import entity.item.Item;

import java.util.ArrayList;

public class ItemHolder {

    public int HP;
    public int damage;

    public ArrayList<Item> items = new ArrayList<Item>();

    public void collectItem(Item item) {

        items.add(item);
        System.out.println("Item collected");

    }



    public int getKeyCount() {

        return items.size();

    }

    public void setHP(int HP) {

        this.HP = HP;

    }

    public void getDamage(int damage) {

        this.damage = damage;
        HP -= damage;
    }


}
