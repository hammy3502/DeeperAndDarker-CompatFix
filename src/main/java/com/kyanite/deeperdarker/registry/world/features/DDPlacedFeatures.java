package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DDPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<PlacedFeature> SCULK_STONE = PLACED_FEATURES.register("sculk_stone", () -> new PlacedFeature(DDConfiguredFeatures.ORE_SCULK_STONE.getHolder().get(), commonOrePlacement(32, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(200)))));
    public static final RegistryObject<PlacedFeature> INFESTED_SCULK = PLACED_FEATURES.register("infested_sculk", () -> new PlacedFeature(DDConfiguredFeatures.ORE_INFESTED_SCULK.getHolder().get(), commonOrePlacement(64, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(50)))));
    public static final RegistryObject<PlacedFeature> SCULK_GLEAM = PLACED_FEATURES.register("sculk_gleam", () -> new PlacedFeature(DDConfiguredFeatures.EXTRA_SCULK_GLEAM.getHolder().get(), commonOrePlacement(25, PlacementUtils.FULL_RANGE)));

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier range) {
        return List.of(placementModifier, InSquarePlacement.spread(), range, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int attempts, PlacementModifier range) {
        return orePlacement(CountPlacement.of(attempts), range);
    }

    public static List<PlacementModifier> rareOrePlacement(int attempts, PlacementModifier range) {
        return orePlacement(RarityFilter.onAverageOnceEvery(attempts), range);
    }
}
