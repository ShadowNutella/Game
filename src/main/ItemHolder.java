package main;

import entity.Item;

import java.util.ArrayList;

public class ItemHolder {

    public ArrayList<Item> items = new ArrayList<Item>();

    public void collectItem(Item item) {

        items.add(item);
        System.out.println("Item collected");

    }



    public int getKeyCount() {

        return items.size();

    }
}
