package cn.maxpixel.mods.randomsonnature.datagen.lang;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.datagen.Enchantments;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.registry.ItemRegistry;
import cn.maxpixel.mods.randomsonnature.util.I18nUtil;
import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class AmericanEnglishLanguageProvider extends LanguageProvider {
    public AmericanEnglishLanguageProvider(PackOutput output) {
        super(output, RandomsOnNatureMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(I18nUtil.makeItemGroup(RandomsOnNatureMod.MAIN_TAB_NAME), "Randoms on Nature");

        addBlock(BlockRegistry.WIND_TUNNEL_CONTROLLER, "Wind Tunnel Controller");
        addBlock(BlockRegistry.WOOD_CHARCOAL_BLOCK, "Wood Block of Charcoal");

        addBlock(BlockRegistry.LIGHTNING_POWERED_OAK_LOG, "Lightning-Powered Oak Log");
        addBlock(BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG, "Lightning-Powered Spruce Log");
        addBlock(BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG, "Lightning-Powered Birch Log");
        addBlock(BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG, "Lightning-Powered Jungle Log");
        addBlock(BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG, "Lightning-Powered Acacia Log");
        addBlock(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG, "Lightning-Powered Dark Oak Log");

        addBlock(BlockRegistry.LIGHTNING_POWERED_OAK_PLANKS, "Lightning-Powered Oak Planks");
        addBlock(BlockRegistry.LIGHTNING_POWERED_SPRUCE_PLANKS, "Lightning-Powered Spruce Planks");
        addBlock(BlockRegistry.LIGHTNING_POWERED_BIRCH_PLANKS, "Lightning-Powered Birch Planks");
        addBlock(BlockRegistry.LIGHTNING_POWERED_JUNGLE_PLANKS, "Lightning-Powered Jungle Planks");
        addBlock(BlockRegistry.LIGHTNING_POWERED_ACACIA_PLANKS, "Lightning-Powered Acacia Planks");
        addBlock(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_PLANKS, "Lightning-Powered Dark Oak Planks");

        addItem(ItemRegistry.LIGHTNING_POWERED_WOODEN_SWORD, "Lightning-Powered Wooden Sword");
        addItem(ItemRegistry.LIGHTNING_POWERED_WOODEN_AXE, "Lightning-Powered Wooden Axe");

        add(Util.makeDescriptionId("enchantment", Enchantments.LIGHTNING_POWERED.location()), "Lightning Powered");
    }
}