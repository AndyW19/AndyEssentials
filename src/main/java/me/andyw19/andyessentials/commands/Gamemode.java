package me.andyw19.andyessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Gamemode implements TabExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                p.sendMessage(ChatColor.YELLOW + "/gm <number>");
            } else if (args.length == 1) {
                switch (args[0]) {
                    case "0":
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatColor.YELLOW + "Gamemode set to " + ChatColor.GREEN + "Survival");
                        break;
                    case "1":
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ChatColor.YELLOW + "Gamemode set to " + ChatColor.GREEN + "Creative");
                        break;
                    case "2":
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(ChatColor.YELLOW + "Gamemode set to " + ChatColor.GREEN + "Adventure");
                        break;
                    case "3":
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ChatColor.YELLOW + "Gamemode set to " + ChatColor.GREEN + "Spectator");
                        break;
                    default:
                        p.sendMessage(ChatColor.YELLOW + "/gm <number>");
                        break;
                }
            } else if (args.length == 2) {
                Player target = Bukkit.getPlayer(args[1]);
                if (target != null) {
                    switch (args[0]) {
                        case "0":
                            target.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.YELLOW + " gamemode set to " + ChatColor.GREEN + "Survival");
                            target.sendMessage(ChatColor.YELLOW + "Gamemode set to " + ChatColor.GREEN + "Survival");
                            break;
                        case "1":
                            target.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.YELLOW + " gamemode set to " + ChatColor.GREEN + "Creative");
                            target.sendMessage(ChatColor.YELLOW + "Gamemode set to " + ChatColor.GREEN + "Creative");
                            break;
                        case "2":
                            target.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.YELLOW + " gamemode set to " + ChatColor.GREEN + "Adventure");
                            target.sendMessage(ChatColor.YELLOW + "Gamemode set to " + ChatColor.GREEN + "Adventure");
                            break;
                        case "3":
                            target.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.YELLOW + " gamemode set to " + ChatColor.GREEN + "Spectator");
                            target.sendMessage(ChatColor.YELLOW + "Gamemode set to " + ChatColor.GREEN + "Spectator");
                            break;
                        default:
                            p.sendMessage(ChatColor.YELLOW + "/gm <number> <player>");
                            break;
                    }
                }
            }
        }


        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 1) {
            List<String> gm = new ArrayList<>();
            gm.add("0");
            gm.add("1");
            gm.add("2");
            gm.add("3");

            return gm;
        }

        return null;
    }
}