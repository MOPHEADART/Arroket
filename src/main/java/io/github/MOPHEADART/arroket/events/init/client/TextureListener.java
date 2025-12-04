package io.github.MOPHEADART.arroket.events.init.client;

import io.github.MOPHEADART.arroket.block.CrimsonPlanks;
import io.github.MOPHEADART.arroket.block.WarpedPlanks;
import io.github.MOPHEADART.arroket.block.testBlock;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import net.modificationstation.stationapi.api.util.Namespace;

import java.lang.invoke.MethodHandles;

public class TextureListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @SuppressWarnings("UnstableApiUsage")
    public static final Namespace NAMESPACE = Namespace.resolve();

    @EventListener
    private static void registerTextures(TextureRegisterEvent event){
        ExpandableAtlas terrain = Atlases.getTerrain();

        testBlock.testBlockSide = terrain.addTexture(NAMESPACE.id("block/test_block")).index;
        testBlock.testBlockTop = terrain.addTexture(NAMESPACE.id("block/test_block")).index;

        CrimsonPlanks.crimsonPlanks = terrain.addTexture(NAMESPACE.id("block/crimson_planks")).index;
        WarpedPlanks.warpedPlanks = terrain.addTexture(NAMESPACE.id("block/warped_planks")).index;
    }
}
