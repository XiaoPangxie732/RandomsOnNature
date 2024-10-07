package cn.maxpixel.mods.randomsonnature.registry.tags;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static net.minecraft.tags.BlockTags.create;

public interface BlockTags {
    TagKey<Block> CAN_BE_LIGHTNING_POWERED_LOGS = key("can_be_lightning_powered_logs");
    TagKey<Block> LIGHTNING_POWERED_LOGS = key("lightning_powered_logs");
    TagKey<Block> LIGHTNING_POWERED_PLANKS = key("lightning_powered_planks");

    private static TagKey<Block> key(String name) {
        return create(RandomsOnNatureMod.rl(name));
    }
}