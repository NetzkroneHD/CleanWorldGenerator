package de.netzkronehd.cleanworldgenerator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;

import javax.annotation.Nullable;
import java.util.Random;

public class CleanWorldGenerator extends ChunkGenerator {

    public static final int DEFAULT_Y_SPAWN_OFFSET = 64;
    public static final int DEFAULT_CHUNK_WIDTH = 16;

    @Override
    public void generateSurface(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkData chunkData) {
        chunkData.setRegion(0, worldInfo.getMinHeight(), 0, DEFAULT_CHUNK_WIDTH, worldInfo.getMaxHeight(), DEFAULT_CHUNK_WIDTH, Material.AIR);
    }

    @Override
    public @Nullable Location getFixedSpawnLocation(World world, Random random) {
        if (!world.isChunkLoaded(0, 0)) {
            world.loadChunk(0, 0);
        }

        final int highestBlock = world.getHighestBlockYAt(0, 0);

        if (isHighestBlockAir(world, highestBlock)) {
            return new Location(world, 0, DEFAULT_Y_SPAWN_OFFSET, 0);
        }
        return new Location(world, 0, highestBlock, 0);
    }

    private boolean isHighestBlockAir(World world, int highestBlock) {
        return highestBlock <= 0 && world.getBlockAt(0, 0, 0).getType() == Material.AIR;
    }

    @Override
    public boolean shouldGenerateSurface() {
        return true;
    }

}
