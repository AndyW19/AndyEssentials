package me.andyw19.andyessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Killall implements TabExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 1) {
                    if ((args[0].equals("mobs")) || (args[0].equals("MOBS"))) {
                        List<Entity> nearby =  p.getNearbyEntities(96,96,96);
                        int mobCount = 0;
                        for (Entity tmp: nearby) {
                            if (tmp instanceof Mob) {
                                tmp.remove();
                                mobCount++;
                            }
                        }

                        p.sendMessage(ChatColor.YELLOW + "Killed " + ChatColor.GREEN + mobCount + ChatColor.YELLOW +" nearby mobs");
                        return true;
                    }

                }
            }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 1) {
            List<String> tab = new ArrayList<>();
            tab.add("mobs");

            return tab;
        }

        return null;
    }
}