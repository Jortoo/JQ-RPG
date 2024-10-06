package me.jqrtox.rpg.Selling;

import me.dovide.utils.Util;
import me.jqrtox.rpg.RPG;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;

import static me.jqrtox.rpg.Main.CommonButtons.backButton;
import static me.jqrtox.rpg.Main.StringUtils.Format;


public class SellingGUI implements Listener {

    public static ItemStack sellHopper() {
        ItemStack sellSlot = new ItemStack(Material.HOPPER);
        ItemMeta sellMeta = sellSlot.getItemMeta();
        sellMeta.setDisplayName(Util.cc("&e&lClick the item you want to sell"));
        ArrayList sellLore = new ArrayList();
        sellLore.add(Util.cc("&8Sell"));
        sellLore.add(Util.cc("&a"));
        sellLore.add(Util.cc("&7Click an item in your inventory"));
        sellLore.add(Util.cc("&7to sell, click it in the sell gui to refund"));
        sellLore.add(Util.cc("&a"));
        sellMeta.setLore(sellLore);
        sellMeta.addEnchant(Enchantment.MENDING, 1, true);
        sellMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sellSlot.setItemMeta(sellMeta);

        return sellSlot;
    }

    public static void createSellingGUI(Player p){
        Inventory inv = Bukkit.createInventory(p, 27, Util.cc("&2&lSell GUI"));
        ItemStack fillUp = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = fillUp.getItemMeta();
        meta.setDisplayName(Util.cc("&a"));
        fillUp.setItemMeta(meta);
        for (int i = 0; i < 27; i++){

            inv.setItem(i, fillUp);

        }
        inv.setItem(13, sellHopper());
        p.openInventory(inv);
    }
    @EventHandler
    public void sellClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        ItemStack inputItem = e.getCurrentItem();
        Inventory inventory = e.getClickedInventory();

        if (p.getOpenInventory().getTitle().equals(Util.cc("&2&lSell GUI")) && inventory.getType() == InventoryType.PLAYER){

            Integer inputAmount = inputItem.getAmount();
            PersistentDataContainer container = inputItem.getItemMeta().getPersistentDataContainer();
            Integer value = container.get(new NamespacedKey(RPG.getPlugin(), "value"), PersistentDataType.INTEGER);
            Inventory sellInv = p.getOpenInventory().getTopInventory();

            e.setCancelled(true);
            if (e.getClick().isLeftClick() && value != null) {

                p.getInventory().removeItem(inputItem);
                sellInv.setItem(13, inputItem);

                p.sendMessage(Util.cc("&e&lShop &8| &7You sold &e" + inputItem.getItemMeta().getDisplayName() + " &7for &a" + Format((value * inputAmount)) + "$&7!"));

            }else {
                p.sendMessage(Util.cc("&e&lShop &8| &7You can not sell this item!"));
            }
            //Add money here

        }else if (e.getView().getTitle().equals(Util.cc("&2&lSell GUI"))) {
            e.setCancelled(true);

            PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
            Integer value = container.get(new NamespacedKey(RPG.getPlugin(), "value"), PersistentDataType.INTEGER);

            //Remove money here
            if (value != null) {
                p.getInventory().addItem(inputItem);
                e.getInventory().setItem(13, sellHopper());
                p.sendMessage(Util.cc("&e&lShop &8| &7You refunded your last sold item and got &a" + (value* inputItem.getAmount()) + "$ &7back!"));
            }
        }

    }
}
