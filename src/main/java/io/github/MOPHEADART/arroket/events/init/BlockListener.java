package io.github.MOPHEADART.arroket.events.init;

import io.github.MOPHEADART.arroket.block.testBlock;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.block.TemplateStairsBlock;

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
    public static Block CRIMSON_STEM;
    public static Block WARPED_STEM;
    public static Block CRIMSON_PLANKS;
    public static Block CRIMSON_SLAB;
    public static Block CRIMSON_STAIRS;
    public static Block WARPED_PLANKS;
    public static Block WARPED_SLAB;
    public static Block WARPED_STAIRS;

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

        CRIMSON_STEM = new TemplateBlock(NAMESPACE.id("crimson_stem"), Material.WOOD)
                .setTranslationKey(NAMESPACE.id("crimson_stem"))
                .setSoundGroup(Block.WOOD_SOUND_GROUP)
                .setHardness(2.F)
                .setResistance(2.F);

        WARPED_STEM = new TemplateBlock(NAMESPACE.id("warped_stem"), Material.WOOD)
                .setTranslationKey(NAMESPACE.id("warped_stem"))
                .setSoundGroup(Block.WOOD_SOUND_GROUP)
                .setHardness(2.F)
                .setResistance(2.F);

        CRIMSON_PLANKS = new TemplateBlock(NAMESPACE.id("crimson_planks"), Material.WOOD)
                .setTranslationKey(NAMESPACE.id("crimson_planks"))
                .setSoundGroup(Block.WOOD_SOUND_GROUP)
                .setHardness(2.F)
                .setResistance(2.F);

        CRIMSON_SLAB = new TemplateBlock(NAMESPACE.id("crimson_slab"), Material.WOOD)
                .setTranslationKey(NAMESPACE.id("crimson_slab"))
                .setSoundGroup(Block.WOOD_SOUND_GROUP)
                .setHardness(2.F)
                .setResistance(2.F);

        CRIMSON_STAIRS = new TemplateStairsBlock(NAMESPACE.id("crimson_stairs"), CRIMSON_PLANKS)
                .setTranslationKey(NAMESPACE.id("crimson_stairs"));

        WARPED_PLANKS = new TemplateBlock(NAMESPACE.id("warped_planks"), Material.WOOD)
                .setTranslationKey(NAMESPACE.id("warped_planks"))
                .setSoundGroup(Block.WOOD_SOUND_GROUP)
                .setHardness(2.F)
                .setResistance(2.F);

        WARPED_SLAB = new TemplateBlock(NAMESPACE.id("warped_slab"), Material.WOOD)
                .setTranslationKey(NAMESPACE.id("warped_slab"))
                .setSoundGroup(Block.WOOD_SOUND_GROUP)
                .setHardness(2.F)
                .setResistance(2.F);

        WARPED_STAIRS = new TemplateBlock(NAMESPACE.id("warped_stairs"), Material.WOOD)
                .setTranslationKey(NAMESPACE.id("warped_stairs"))
                .setSoundGroup(Block.WOOD_SOUND_GROUP)
                .setHardness(2.F)
                .setResistance(2.F);
    }
}
