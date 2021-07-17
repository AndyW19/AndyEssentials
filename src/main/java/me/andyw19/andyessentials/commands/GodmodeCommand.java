package me.andyw19.andyessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class GodmodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.YELLOW + "God mode " + ChatColor.RED + "disabled");
                } else {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.YELLOW + "God mode " + ChatColor.GREEN + "enabled");
                }
                return true;
            } else if (args.length == 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t.isInvulnerable()) {
                    t.setInvulnerable(false);
                    t.sendMessage(ChatColor.YELLOW + "God mode " + ChatColor.RED + "disabled");
                    p.sendMessage(ChatColor.YELLOW + "God mode " + ChatColor.RED + "disabled" + ChatColor.YELLOW + " for "
                            + ChatColor.GOLD + t.getName());
                } else {
                    t.setInvulnerable(true);
                    t.sendMessage(ChatColor.YELLOW + "God mode " + ChatColor.GREEN + "enabled");
                    p.sendMessage(ChatColor.YELLOW + "God mode " + ChatColor.GREEN + "enabled" + ChatColor.YELLOW + " for "
                            + ChatColor.GOLD + t.getName());
                }
                return true;
            }
        }
        return true;
    }
}