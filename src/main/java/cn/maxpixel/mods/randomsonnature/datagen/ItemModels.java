package cn.maxpixel.mods.randomsonnature.datagen;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {
    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RandomsOnNatureMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ItemRegistry.LIGHTNING_POWERED_WOODEN_SWORD.getId().getPath(), mcLoc("item/wooden_sword"));
        withExistingParent(ItemRegistry.LIGHTNING_POWERED_WOODEN_AXE.getId().getPath(), mcLoc("item/wooden_axe"));
    }
}