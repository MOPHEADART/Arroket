package io.github.MOPHEADART.arroket.block;

import io.github.MOPHEADART.arroket.events.init.BlockListener;
import io.github.MOPHEADART.arroket.world.gen.feature.CrimsonFungiFeature;
import io.github.MOPHEADART.arroket.world.gen.feature.WarpedFungiFeature;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NyliumFungi extends TemplateBlock {

    public NyliumFungi(Identifier identifier, Material material) {
        super(identifier, material);
        float var3 = 0.2F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
        this.setTickRandomly(true);
    }

    public boolean canPlaceAt(World world, int x, int y, int z) {
        return super.canPlaceAt(world, x, y, z) && this.canPlantOnTop(world.getBlockId(x, y - 1, z));
    }

    protected boolean canPlantOnTop(int id) {
        return id == Block.NETHERRACK.id || id == BlockListener.CRIMSON_NYLIUM.id || id == BlockListener.WARPED_NYLIUM.id;
    }

    public void neighborUpdate(World world, int x, int y, int z, int id) {
        super.neighborUpdate(world, x, y, z, id);
        this.breakIfCannotGrow(world, x, y, z);
    }

    public void onTick(World world, int x, int y, int z, Random random) {
        this.breakIfCannotGrow(world, x, y, z);
    }

    protected final void breakIfCannotGrow(World world, int x, int y, int z) {
        if (!this.canGrow(world, x, y, z)) {
            this.dropStacks(world, x, y, z, world.getBlockMeta(x, y, z));
            world.setBlock(x, y, z, 0);
        }
    }

    public boolean canGrow(World world, int x, int y, int z) {
        return this.canPlantOnTop(world.getBlockId(x, y - 1, z));
    }


    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }


    @Override
    public boolean onBonemealUse(World world, int x, int y, int z, BlockState state) {
        world.setBlockWithoutNotifyingNeighbors(x, y, z, 0);

        Feature feature;

        if (this.id == BlockListener.CRIMSON_FUNGI.id) {
            feature = new CrimsonFungiFeature();
        } else{
            feature = new WarpedFungiFeature();
        }

        if (!feature.generate(world, new Random(), x, y, z)) {
            world.setBlockWithoutNotifyingNeighbors(x, y, z, this.id);
            return false;
        }
        return true;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

}
