package cn.maxpixel.mods.randomsonnature.registry.tags;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public interface ItemTags {
    TagKey<Item> CAN_BE_LIGHTNING_POWERED_WEAPONS = key("can_be_lightning_powered_weapons");
    TagKey<Item> CAN_BE_LIGHTNING_POWERED_LOGS = key("can_be_lightning_powered_logs");
    TagKey<Item> LIGHTNING_POWERED_LOGS = key("lightning_powered_logs");
    TagKey<Item> LIGHTNING_POWERED_PLANKS = key("lightning_powered_planks");

    private static TagKey<Item> key(String name) {
        return TagKey.create(Registries.ITEM, RandomsOnNatureMod.rl(name));
    }
}
