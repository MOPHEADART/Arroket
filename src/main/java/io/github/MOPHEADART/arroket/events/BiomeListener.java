package io.github.MOPHEADART.arroket.events;

import io.github.MOPHEADART.arroket.ArroketMod;
import io.github.MOPHEADART.arroket.events.init.BlockListener;
import io.github.MOPHEADART.arroket.world.gen.feature.CrimsonFungiFeature;
import io.github.MOPHEADART.arroket.world.gen.feature.WarpedFungiFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.modificationstation.stationapi.api.event.world.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeProviderRegisterEvent;
import net.modificationstation.stationapi.api.worldgen.BiomeAPI;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeBuilder;
import net.modificationstation.stationapi.api.worldgen.biome.ClimateBiomeProvider;
import net.modificationstation.stationapi.api.worldgen.biome.VoronoiBiomeProvider;
import net.modificationstation.stationapi.api.worldgen.surface.SurfaceBuilder;

public class BiomeListener {

    //Biome Variables
    public static Biome[] netherBiomes;


    @EventListener
    public void registerBiomes(BiomeRegisterEvent event){
        netherBiomes = new Biome[2];


        BiomeBuilder biomebuilder;
        // Crimson Forest builder
        biomebuilder = BiomeBuilder.start("Crimson Forest");
        biomebuilder.fogColor(0xC72D0E);
        biomebuilder.grassAndLeavesColor(0xA1B87C);
        biomebuilder.surfaceRule(SurfaceBuilder.start(BlockListener.CRIMSON_NYLIUM).ground(1).replace(Block.NETHERRACK).build());
        biomebuilder.feature(new CrimsonFungiFeature());
        netherBiomes[0] = biomebuilder.build();

        // Warped Forest Builder
        biomebuilder = BiomeBuilder.start("Warped Forest");
        biomebuilder.fogColor(0x4D4B80);
        biomebuilder.grassAndLeavesColor(0xA1B87C);
        biomebuilder.surfaceRule(SurfaceBuilder.start(BlockListener.WARPED_NYLIUM).ground(1).replace(Block.NETHERRACK).build());
        biomebuilder.feature(new WarpedFungiFeature());
        netherBiomes[1] = biomebuilder.build();
    }

    @EventListener
    public void registerBiomeProvider(BiomeProviderRegisterEvent event) {

        VoronoiBiomeProvider provider = new VoronoiBiomeProvider(32);
        provider.addBiome(netherBiomes[0]);
        provider.addBiome(netherBiomes[1]);
        BiomeAPI.addNetherBiomeProvider(ArroketMod.NAMESPACE.id("climate_biome_provider"), provider);
    }
}
