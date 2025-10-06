package de.netzkronehd.cleanworldgenerator;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public final class CleanWorldGeneratorPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CleanWorldGeneratorPlugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("CleanWorldGeneratorPlugin disabled");
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new CleanWorldGenerator();
    }
}
