package me.jqrtox.rpg.Collection;

import me.dovide.utils.Util;
import me.jqrtox.rpg.Foraging.ForageCollectionGui;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionGUI implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player p) {

            createCollectionGUI(p);
        }
        return true;
    }
        public static void createCollectionGUI(Player p){
            Inventory collections = Bukkit.createInventory(p, 27, Util.cc("&e&lCollections"));
            ItemStack fillup = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta fillupMeta = fillup.getItemMeta();
            fillupMeta.setDisplayName(Util.cc("&8"));
            fillup.setItemMeta(fillupMeta);

            ItemStack woodCollection = new ItemStack(Material.OAK_LOG);
            ItemMeta woodMeta = woodCollection.getItemMeta();
            woodMeta.setDisplayName(Util.cc("&e&lWood Collections"));
            ArrayList woodLore = new ArrayList<>();
            woodLore.add(Util.cc("&8Collection"));
            woodLore.add("");
            woodLore.add(Util.cc("&fClick to see your wood collections"));
            woodLore.add("");
            woodLore.add(Util.cc("&7Amount of wood collections: &e6"));
            woodLore.add("");
            woodMeta.setLore(woodLore);
            woodCollection.setItemMeta(woodMeta);

            for(int i = 0; i < 27; i++){

                collections.setItem(i, fillup);

            }

            collections.setItem(10, woodCollection);

            p.openInventory(collections);
    }

    @EventHandler
    public void collectionClick(InventoryClickEvent e) {

        Player p = (Player)e.getWhoClicked();

        if (e.getView().getTitle().equals(Util.cc("&e&lCollections"))) {

            e.setCancelled(true);

            if (e.getClick().isLeftClick() && e.getSlot() == 10) {

                    ForageCollectionGui.woodCollectionGui(p);

            }
        }


    }
}

