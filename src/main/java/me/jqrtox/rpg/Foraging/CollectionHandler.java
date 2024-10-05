package me.jqrtox.rpg.Foraging;

import me.jqrtox.rpg.Collection.CollectionLevel;
import me.jqrtox.rpg.Main.StringUtils;
import me.jqrtox.rpg.RPG;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static me.jqrtox.rpg.Foraging.WoodMiningReplaceBlock.WoodReplace;
import static me.jqrtox.rpg.Main.StringUtils.capitalizeFirstLetter;

public class CollectionHandler {

    public static void WoodCollectionHandler(Player p, String wood, Material mat, Location loc) {

        PersistentDataContainer container = p.getPersistentDataContainer();
        Integer stat = container.get(new NamespacedKey(RPG.getPlugin(), wood+"Collection"), PersistentDataType.INTEGER);

        container.set(new NamespacedKey(RPG.getPlugin(), wood+"Collection"),PersistentDataType.INTEGER, stat+1);

        CollectionLevel.CollectionLevel(p, wood+"Collection", capitalizeFirstLetter(wood)+" Wood");

        WoodReplace(mat, loc, p, ForageItems.createWood(1, capitalizeFirstLetter(wood)+" Wood", mat));

    }

}
