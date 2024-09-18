package cn.maxpixel.mods.randomsonnature.registry;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RandomsOnNatureMod.MODID);

    public static final DeferredItem<SwordItem> WOODEN_SWORD = ITEMS.register(
            "lightning_powered_wooden_sword", () -> new SwordItem(Tiers.WOOD, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD, 3, -2.4F)))
    );
    public static final DeferredItem<ShovelItem> WOODEN_SHOVEL = ITEMS.register(
            "lightning_powered_wooden_shovel", () -> new ShovelItem(Tiers.WOOD, new Item.Properties().attributes(ShovelItem.createAttributes(Tiers.WOOD, 1.5F, -3.0F)))
    );
    public static final DeferredItem<PickaxeItem> WOODEN_PICKAXE = ITEMS.register(
            "lightning_powered_wooden_pickaxe", () -> new PickaxeItem(Tiers.WOOD, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.WOOD, 1.0F, -2.8F)))
    );
    public static final DeferredItem<AxeItem> WOODEN_AXE = ITEMS.register(
            "lightning_powered_wooden_axe", () -> new AxeItem(Tiers.WOOD, new Item.Properties().attributes(AxeItem.createAttributes(Tiers.WOOD, 6.0F, -3.2F)))
    );
    public static final DeferredItem<HoeItem> WOODEN_HOE = ITEMS.register(
            "lightning_powered_wooden_hoe", () -> new HoeItem(Tiers.WOOD, new Item.Properties().attributes(HoeItem.createAttributes(Tiers.WOOD, 0.0F, -3.0F)))
    );

    public static void registerBlockItem(String name, DeferredBlock<?> block) {
        ITEMS.registerSimpleBlockItem(name, block);
    }
}
