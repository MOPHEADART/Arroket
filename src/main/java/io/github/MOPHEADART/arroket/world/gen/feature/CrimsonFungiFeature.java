package io.github.MOPHEADART.arroket.world.gen.feature;

import io.github.MOPHEADART.arroket.events.init.BlockListener;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class CrimsonFungiFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (world.getBlockId(x, y - 1, z) != BlockListener.CRIMSON_NYLIUM.id) {
            return false;
        }
        if (world.getBlockId(x, y, z) != 0) {
            return false;
        }
        int stemHeight = 4 + random.nextInt(8);
        for (int i = 0; i <= stemHeight; i++) {
            if (world.getBlockId(x, y + i + 1, z) != 0) {
                stemHeight = i;
                break;
            }
        }
        for (int i = stemHeight - 3; i <= stemHeight; i++) {
            for (int j = -2; j <= 2; j++) {
                for (int k = -2; k <= 2; k++) {
                    if (world.getBlockId(x + j, y + i + 1, z + k) != 0) {
                        stemHeight = i;
                        break;
                    }
                }
            }
        }
        if (stemHeight < 3) {
            return false;
        }
        int mushroomCapLength = 3;
        for (int i = 0; i < stemHeight; i++) {
            if (i >= stemHeight - mushroomCapLength) {
                // Generate positive x side of the cap
                world.setBlock(x + 2, y + i, z + 1, BlockListener.CRIMSON_WART_BLOCK.id);
                world.setBlock(x + 2, y + i, z, BlockListener.CRIMSON_WART_BLOCK.id);
                world.setBlock(x + 2, y + i, z - 1, BlockListener.CRIMSON_WART_BLOCK.id);
                // Generate negative x side of the cap
                world.setBlock(x - 2, y + i, z + 1, BlockListener.CRIMSON_WART_BLOCK.id);
                world.setBlock(x - 2, y + i, z, BlockListener.CRIMSON_WART_BLOCK.id);
                world.setBlock(x - 2, y + i, z - 1, BlockListener.CRIMSON_WART_BLOCK.id);
                // Generate positive z side of the cap
                world.setBlock(x + 1, y + i, z + 2, BlockListener.CRIMSON_WART_BLOCK.id);
                world.setBlock(x, y + i, z + 2, BlockListener.CRIMSON_WART_BLOCK.id);
                world.setBlock(x - 1, y + i, z + 2, BlockListener.CRIMSON_WART_BLOCK.id);
                // Generate negative x side of the cap
                world.setBlock(x + 1, y + i, z - 2, BlockListener.CRIMSON_WART_BLOCK.id);
                world.setBlock(x, y + i, z - 2, BlockListener.CRIMSON_WART_BLOCK.id);
                world.setBlock(x - 1, y + i, z - 2, BlockListener.CRIMSON_WART_BLOCK.id);
            }
            world.setBlock(x, y + i, z, BlockListener.CRIMSON_STEM.id);
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                world.setBlock(x + i, y + stemHeight, z + j, BlockListener.CRIMSON_WART_BLOCK.id);
            }
        }
        return true;
    }
}
