package me.jqrtox.rpg.Foraging;

import me.jqrtox.rpg.Main.DelayedTask;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WoodMiningReplaceBlock {

    public static void WoodReplace(Material block, Location loc, Player p, ItemStack item){

        p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

        p.getInventory().addItem(item);

        new DelayedTask(() -> {
            loc.getBlock().setType(block);
        }, 10*20);

    }

}
