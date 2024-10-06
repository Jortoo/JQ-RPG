package me.jqrtox.rpg.Main;

import me.dovide.utils.Util;
import me.jqrtox.rpg.RPG;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class CommonButtons {

    public static ItemStack backButton() {

        ItemStack backSlot = new ItemStack(Material.BARRIER);
        ItemMeta backMeta = backSlot.getItemMeta();

        PersistentDataContainer container = backSlot.getItemMeta().getPersistentDataContainer();
        container.set(new NamespacedKey(RPG.getPlugin(), "back"), PersistentDataType.BOOLEAN, true);

        backMeta.setDisplayName(Util.cc("&c&lGo Back"));
        ArrayList backLore = new ArrayList();
        backLore.add(Util.cc("&a"));
        backLore.add(Util.cc("&7Click to go back"));
        backLore.add(Util.cc("&a"));
        backMeta.setLore(backLore);
        backSlot.setItemMeta(backMeta);

        return backSlot;
    }
}
