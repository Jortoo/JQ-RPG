package me.jqrtox.rpg.Selling;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.jqrtox.rpg.Main.guiFillup.fillup;

public class SellingGUI implements Listener {

    public static void createSellingGUI(Player p){
        Inventory inv = Bukkit.createInventory(p, 27);

        for (int i = 0; i < 27; i++){

            inv.setItem(i, fillup());

        }
    }

}
