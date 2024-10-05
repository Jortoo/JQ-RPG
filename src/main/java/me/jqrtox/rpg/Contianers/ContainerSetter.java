package me.jqrtox.rpg.Contianers;

import me.jqrtox.rpg.RPG;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ContainerSetter {

    // Checks if the player's container is set, if not, it will set it (This will be used when a player joins)

    public static void ContainerSetter(String c, Player p, Integer output) {

        PersistentDataContainer container = p.getPersistentDataContainer();

        if (container.get(new NamespacedKey(RPG.getPlugin(), c), PersistentDataType.INTEGER) == null) {
            container.set(new NamespacedKey(RPG.getPlugin(), c), PersistentDataType.INTEGER, output);

        }

    }

}
