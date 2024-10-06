package me.jqrtox.rpg.Foraging;

import me.dovide.utils.Util;
import me.jqrtox.rpg.Main.ProgressBar;
import me.jqrtox.rpg.RPG;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

import static me.jqrtox.rpg.Collection.CollectionGUI.createCollectionGUI;
import static me.jqrtox.rpg.Main.StringUtils.Format;
import static me.jqrtox.rpg.Main.StringUtils.capitalizeFirstLetter;

public class ForageCollectionGui implements Listener {

    public static void woodCollectionGui(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, Util.cc("&e&lWood Collections"));

        ItemStack fillup = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta fillupMeta = fillup.getItemMeta();
        fillupMeta.setDisplayName(Util.cc("&a"));
        fillup.setItemMeta(fillupMeta);

        ItemStack backSlot = new ItemStack(Material.BARRIER);
        ItemMeta backMeta = backSlot.getItemMeta();
        backMeta.setDisplayName(Util.cc("&c&lGo Back"));
        ArrayList backLore = new ArrayList();
        backLore.add(Util.cc("&a"));
        backLore.add(Util.cc("&7Click to go back"));
        backLore.add(Util.cc("&a"));
        backMeta.setLore(backLore);
        backSlot.setItemMeta(backMeta);

        for (int i = 0; i < 9; i++) {

            inv.setItem(i, fillup);

        }
        for (int i = 45; i < 54; i++) {

            inv.setItem(i, fillup);

        }

        int i2 = 0;
        for (int i = 0; i < 46; i++){

            i2++;
            if (i2 == 9){
                inv.setItem(i, fillup);
                inv.setItem(i+1, fillup);
                i2 = 0;
            }

        }

        woodCollectionSlots(p, "oak", inv, 10, Material.OAK_LOG);
        woodCollectionSlots(p, "birch", inv, 11, Material.BIRCH_LOG);
        woodCollectionSlots(p, "acacia", inv, 12, Material.ACACIA_LOG);
        woodCollectionSlots(p, "spruce", inv, 13, Material.SPRUCE_LOG);
        woodCollectionSlots(p, "jungle", inv, 14, Material.JUNGLE_LOG);
        inv.setItem(49, backSlot);
        p.openInventory(inv);

    }
    private static void woodCollectionSlots(Player p, String wood, Inventory inv, Integer slot, Material mat) {

        ItemStack slotItem = new ItemStack(mat);
        ItemMeta slotMeta = slotItem.getItemMeta();

        PersistentDataContainer container = p.getPersistentDataContainer();
        Integer level = container.get(new NamespacedKey(RPG.getPlugin(), wood+"Collectionlevel"), PersistentDataType.INTEGER);
        Integer col = container.get(new NamespacedKey(RPG.getPlugin(), wood+"Collection"), PersistentDataType.INTEGER);
        Integer req = container.get(new NamespacedKey(RPG.getPlugin(), wood+"Collectionreq"), PersistentDataType.INTEGER);

        slotMeta.setDisplayName(Util.cc("&e&l" + capitalizeFirstLetter(wood) + " Collection"));

        ArrayList lore = new ArrayList();
        lore.add(Util.cc("&8Collection"));
        lore.add("");
        lore.add(Util.cc("&fLevel: &8[&e" + level + "&8]"));
        lore.add(Util.cc("&7("+Format(col)+") ") + ProgressBar.progressBar((double)col, (double)req)+Util.cc("&7 ("+Format(req)+")"));
        lore.add("");
        slotMeta.setLore(lore);
        slotItem.setItemMeta(slotMeta);

        ItemStack hiddenSlot = new ItemStack(Material.GRAY_DYE);
        ItemMeta hiddenMeta = hiddenSlot.getItemMeta();
        hiddenMeta.setDisplayName(Util.cc("&7???"));

        ArrayList hiddenLore = new ArrayList();
        hiddenLore.add(Util.cc("&8Collection"));
        hiddenLore.add(Util.cc("&8"));
        hiddenLore.add(Util.cc("&cNot found yet!"));
        hiddenMeta.setLore(hiddenLore);
        hiddenSlot.setItemMeta(hiddenMeta);


        if (col > 0) {
            inv.setItem(slot, slotItem);
        }else{
            inv.setItem(slot, hiddenSlot);
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equals(Util.cc("&e&lWood Collections"))) {

            e.setCancelled(true);
            if (e.getClick().isLeftClick() && e.getSlot() == 49) {
                createCollectionGUI(p);
            }

        }
    }

}
