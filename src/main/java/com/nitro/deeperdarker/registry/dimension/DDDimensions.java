package com.nitro.deeperdarker.registry.dimension;

import com.nitro.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DDDimensions {
    public static final ResourceKey<Level> OTHERSIDE_KEY = ResourceKey.create(
            Registry.DIMENSION_REGISTRY,
            new ResourceLocation(DeeperAndDarker.MOD_ID, "otherside"));

    public static final ResourceKey<DimensionType> OTHERSIDE = ResourceKey.create(
            Registry.DIMENSION_TYPE_REGISTRY,
            OTHERSIDE_KEY.registry()
    );
}
