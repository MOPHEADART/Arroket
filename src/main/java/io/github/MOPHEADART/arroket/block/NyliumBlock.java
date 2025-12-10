package io.github.MOPHEADART.arroket.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NyliumBlock extends TemplateBlock {
    public NyliumBlock(Identifier identifier, Material material) {
        super(identifier, Material.STONE);
        this.setTickRandomly(true);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (!world.isRemote) {
            if (world.getLightLevel(x, y + 1, z) < 4 && Block.BLOCKS_LIGHT_OPACITY[world.getBlockId(x, y + 1, z)] > 2) {
                if (random.nextInt(4) != 0) {
                    return;
                }
                world.setBlock(x, y, z, Block.NETHERRACK.id);
            }
        }
    }
}
