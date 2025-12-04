package io.github.MOPHEADART.arroket.block;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

//Use this method for any blocks that are going to have a stair variant, specifically use ArroketBlock.class

public class testBlock extends TemplateBlock {
    public static int testBlockSide;
    public static int testBlockTop;

    public testBlock(Identifier identifier) {
        super(identifier, Material.LEAVES);
    }

    @Override
    public int getTexture(int side) {
        if (side == 0 || side == 1){
            return testBlockTop;
        } else {
            return testBlockSide;
        }
    }
}
