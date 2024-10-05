package me.jqrtox.rpg.Collection;

import me.dovide.utils.Util;
import me.jqrtox.rpg.RPG;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CollectionLevel {

    public static void CollectionLevel(Player p, String stat, String collection) {

        PersistentDataContainer container = p.getPersistentDataContainer();
        Integer level = container.get(new NamespacedKey(RPG.getPlugin(), stat+"level"), PersistentDataType.INTEGER);
        Integer req = container.get(new NamespacedKey(RPG.getPlugin(), stat+"req"), PersistentDataType.INTEGER);
        Integer statistic = container.get(new NamespacedKey(RPG.getPlugin(), stat), PersistentDataType.INTEGER);


        if (statistic == 1){
            p.sendMessage(Util.cc("&e&l➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖"));
            p.sendMessage(Util.cc("&6&l  COLLECTION UNLOCKED: &e" + collection));
            p.sendMessage(Util.cc(""));
            p.sendMessage(Util.cc("&e&l➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖"));

        }

        if (statistic == req || statistic > req){

            container.set(new NamespacedKey(RPG.getPlugin(), stat+"level"), PersistentDataType.INTEGER, (level+1));
            container.set(new NamespacedKey(RPG.getPlugin(), stat+"req"), PersistentDataType.INTEGER, (int)Math.pow(level * 50, 1.25));
            CollectionLevelupMessage.collectionLevelup(p, collection, level);

        }

    }

}
