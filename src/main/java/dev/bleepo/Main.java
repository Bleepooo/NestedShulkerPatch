package dev.bleepo;

import dev.bleepo.events.inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new inventory(this), this);
        getLogger().info("Loaded Nested Shulker Patch by Bleepo");
    }

    @Override
    public void onDisable() {
        getLogger().info("Bai");
    }
}
