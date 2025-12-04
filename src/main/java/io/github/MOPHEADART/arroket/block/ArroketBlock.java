package io.github.MOPHEADART.arroket.block;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

//Template for creating a block, if a block will have stair or slab variant then this will need to be used.

public class ArroketBlock extends TemplateBlock {
    public int topTexture;
    public int bottomTexture;
    public int sideTexture;
    public int frontTexture;
    public int backTexture;

    public ArroketBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    public void setTextures (int topTexture, int bottomTexture, int sideTexture) {
        this.topTexture = topTexture;
        this.bottomTexture = bottomTexture;
        this.sideTexture = sideTexture;
        frontTexture = sideTexture;
        backTexture = sideTexture;
    }

    public void setTextures (int allTexture) {
        topTexture = allTexture;
        bottomTexture = allTexture;
        sideTexture = allTexture;
        frontTexture = allTexture;
        backTexture = allTexture;
    }

    //Need to add support for orientable blocks in the future
    @Override
    public int getTexture(int side) {
        if (side == 0) return bottomTexture;
        if (side == 1) return topTexture;
        else return sideTexture;
    }
}
