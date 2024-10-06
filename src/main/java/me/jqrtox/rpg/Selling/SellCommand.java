package me.jqrtox.rpg.Selling;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.jqrtox.rpg.Selling.SellingGUI.createSellingGUI;

public class SellCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player p){
            createSellingGUI(p);
        }

        return true;
    }
}
