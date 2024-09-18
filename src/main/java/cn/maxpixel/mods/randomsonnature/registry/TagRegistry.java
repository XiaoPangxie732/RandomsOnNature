package cn.maxpixel.mods.randomsonnature.registry;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagRegistry {
    public static final TagKey<Block> LIGHTNING_POWERED_LOGS = TagKey.create(
            Registries.BLOCK,
            RandomsOnNatureMod.rl("lightning_powered_logs")
    );
    public static final TagKey<Block> LIGHTNING_POWERED_PLANKS = TagKey.create(
            Registries.BLOCK,
            RandomsOnNatureMod.rl("lightning_powered_planks")
    );
}