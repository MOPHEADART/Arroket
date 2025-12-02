package io.github.MOPHEADART.arroket.events.init;

import io.github.MOPHEADART.arroket.block.testBlock;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.block.TemplateStairsBlock;
import net.modificationstation.stationapi.api.util.Namespace;

import java.lang.invoke.MethodHandles;

import static io.github.MOPHEADART.arroket.ArroketMod.NAMESPACE;

public class BlockListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    //Block Variables
    public static Block TEST_BLOCK;
    public static Block TEST_BLOCK_STAIRS;
    public static Block CRIMSON_NYLIUM;
    public static Block WARPED_NYLIUM;

    //Block Registry
    @EventListener
    private static void registerBlocks(BlockRegistryEvent event) {
        TEST_BLOCK = new testBlock(NAMESPACE.id("test_block"))
                .setTranslationKey(NAMESPACE.id("test_block"))
                .setSoundGroup(Block.DIRT_SOUND_GROUP)
                .setHardness(0.6F)
                .setResistance(1.F);

        TEST_BLOCK_STAIRS = new TemplateStairsBlock(NAMESPACE.id("test_block_stairs"), TEST_BLOCK)
                .setTranslationKey(NAMESPACE.id("test_block_stairs"));

        CRIMSON_NYLIUM = new TemplateBlock(NAMESPACE.id("crimson_nylium"), Material.STONE)
                .setTranslationKey(NAMESPACE.id("crimson_nylium"))
                .setSoundGroup(Block.STONE_SOUND_GROUP)
                .setHardness(0.5F)
                .setResistance(0.5F);

        WARPED_NYLIUM = new TemplateBlock(NAMESPACE.id("warped_nylium"), Material.STONE)
                .setTranslationKey(NAMESPACE.id("warped_nylium"))
                .setSoundGroup(Block.STONE_SOUND_GROUP)
                .setHardness(0.5F)
                .setResistance(0.5F);
    }
}
