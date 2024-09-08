package cn.maxpixel.mods.randomsonnature.registry;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RandomsOnNatureMod.MODID);

    public static void registerBlockItem(String name, DeferredBlock<?> block) {
        ITEMS.registerSimpleBlockItem(name, block);
    }
}
