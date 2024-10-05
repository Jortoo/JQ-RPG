package me.jqrtox.rpg.Foraging;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.persistence.PersistentDataContainer;

public class WoodMining implements Listener {

    @EventHandler
    public void woodMine(BlockBreakEvent e){

        Material eventBlock = e.getBlock().getType();
        Player p = e.getPlayer();
        Location loc = e.getBlock().getLocation();
        PersistentDataContainer container = p.getPersistentDataContainer();

        if (eventBlock == Material.SPRUCE_LOG) {

            e.setDropItems(false);
            CollectionHandler.WoodCollectionHandler(p, "spruce", Material.SPRUCE_LOG, loc);

        }else if (eventBlock == Material.OAK_LOG) {

            e.setDropItems(false);
            CollectionHandler.WoodCollectionHandler(p, "oak", Material.OAK_LOG, loc);

        }else if (eventBlock == Material.JUNGLE_LOG) {

            e.setDropItems(false);
            CollectionHandler.WoodCollectionHandler(p, "jungle", Material.JUNGLE_LOG, loc);

        }else if (eventBlock == Material.BIRCH_LOG) {

            e.setDropItems(false);
            CollectionHandler.WoodCollectionHandler(p, "birch", Material.BIRCH_LOG, loc);

        }else if (eventBlock == Material.ACACIA_LOG) {

            e.setDropItems(false);
            CollectionHandler.WoodCollectionHandler(p, "acacia", Material.ACACIA_LOG, loc);

        }

    }


}
