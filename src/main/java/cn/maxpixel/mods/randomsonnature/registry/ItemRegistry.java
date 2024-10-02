package cn.maxpixel.mods.randomsonnature.registry;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RandomsOnNatureMod.MODID);

    public static final DeferredItem<SwordItem> LIGHTNING_POWERED_WOODEN_SWORD = ITEMS.register(
            "lightning_powered_wooden_sword", () -> new SwordItem(Tiers.WOOD, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD, 5f, -2.4f))) {
                @Override
                public boolean isFoil(ItemStack pStack) {
                    return true;
                }
            }
    );
    public static final DeferredItem<AxeItem> LIGHTNING_POWERED_WOODEN_AXE = ITEMS.register(
            "lightning_powered_wooden_axe", () -> new AxeItem(Tiers.WOOD, new Item.Properties().attributes(AxeItem.createAttributes(Tiers.WOOD, 8.0f, -3.2f))) {
                @Override
                public boolean isFoil(ItemStack pStack) {
                    return true;
                }
            }
    );

    public static void registerBlockItem(String name, DeferredBlock<?> block) {
        ITEMS.registerSimpleBlockItem(name, block);
    }
}
