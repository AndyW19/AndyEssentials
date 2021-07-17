package me.andyw19.andyessentials;

import me.andyw19.andyessentials.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class AndyEssentials extends JavaPlugin {

    // Plugin instance reference
    // Call this function to get the plugin instance
    private static AndyEssentials pluginInstance;
    public static AndyEssentials getInstance() {
        return pluginInstance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("AndyEssentials has loaded");
        registerCommands();

    }

    private void registerCommands() {
        this.getCommand("gm").setExecutor(new Gamemode());
        this.getCommand("god").setExecutor(new GodmodeCommand());
        this.getCommand("killall").setExecutor(new Killall());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("AndyEssentials has unloaded");
    }
}
