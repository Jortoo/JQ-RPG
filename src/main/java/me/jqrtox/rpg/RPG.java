package me.jqrtox.rpg;

import me.jqrtox.rpg.Collection.CollectionGUI;
import me.jqrtox.rpg.Contianers.ContainerSetter;
import me.jqrtox.rpg.Contianers.Containers;
import me.jqrtox.rpg.Foraging.ForageCollectionGui;
import me.jqrtox.rpg.Foraging.WoodMining;
import me.jqrtox.rpg.Main.DelayedTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPG extends JavaPlugin {

    private static RPG plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new WoodMining(), this);
        getServer().getPluginManager().registerEvents(new Containers(), this);
        getServer().getPluginManager().registerEvents(new CollectionGUI(), this);
        getServer().getPluginManager().registerEvents(new ForageCollectionGui(), this);

        getCommand("collections").setExecutor(new CollectionGUI());
        new DelayedTask(this);
    }

    @Override
    public void onDisable() {

    }
    public static RPG getPlugin() {
        return plugin;
    }
}
