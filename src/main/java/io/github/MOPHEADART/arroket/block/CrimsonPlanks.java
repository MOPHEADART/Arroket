package io.github.MOPHEADART.arroket.block;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class CrimsonPlanks extends TemplateBlock {
    public static int crimsonPlanks;

    public CrimsonPlanks(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public int getTexture(int side) {
        return crimsonPlanks;
    }
}

