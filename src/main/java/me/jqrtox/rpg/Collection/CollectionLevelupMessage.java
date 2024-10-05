package me.jqrtox.rpg.Collection;

import me.dovide.utils.Util;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class CollectionLevelupMessage {

    public static void collectionLevelup(Player p, String collection, Integer level){

        p.sendMessage(Util.cc("&e&l➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖"));
        p.sendMessage(Util.cc("&6&l  COLLECTION LEVEL UP &e" + collection + " &7"+ (level-1) + " &8➜ &e" + level));
        p.sendMessage(Util.cc(""));
        p.sendMessage(Util.cc("&a&l  REWARD"));
        p.sendMessage(Util.cc(""));
        p.sendMessage(Util.cc("&3&e&l➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖"));
        p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
    }

}
