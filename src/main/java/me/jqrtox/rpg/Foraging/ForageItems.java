package me.jqrtox.rpg.Foraging;

import me.dovide.utils.Util;
import me.jqrtox.rpg.RPG;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class ForageItems {

    public static ItemStack createWood(Integer amount, String name, Material item){

        ItemStack wood = new ItemStack(item, amount);
        ItemMeta meta = wood.getItemMeta();
        meta.setDisplayName(Util.cc("&f"+name));
        ArrayList lore = new ArrayList<>();
        lore.add(Util.cc("&8Collection Item"));
        lore.add(Util.cc("&a"));
        lore.add(Util.cc("&f&lCOMMON"));
        meta.setLore(lore);
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(new NamespacedKey(RPG.getPlugin(),"value"), PersistentDataType.INTEGER, 2);
        wood.setItemMeta(meta);

        return wood;

    }

}
