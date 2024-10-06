package me.jqrtox.rpg.Main;

import me.dovide.utils.Util;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class guiFillup {

    public static ItemStack fillup() {

        ItemStack fillup = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = fillup().getItemMeta();
        meta.setDisplayName(Util.cc("&a"));
        fillup.setItemMeta(meta);

        return fillup;

    }

}
