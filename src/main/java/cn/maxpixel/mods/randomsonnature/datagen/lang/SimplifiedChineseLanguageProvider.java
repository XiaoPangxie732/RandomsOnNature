package cn.maxpixel.mods.randomsonnature.datagen.lang;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.datagen.Enchantments;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.registry.ItemRegistry;
import cn.maxpixel.mods.randomsonnature.util.I18nUtil;
import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class SimplifiedChineseLanguageProvider extends LanguageProvider {
    public SimplifiedChineseLanguageProvider(PackOutput output) {
        super(output, RandomsOnNatureMod.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(I18nUtil.makeItemGroup(RandomsOnNatureMod.MAIN_TAB_NAME), "随想自然");

        addBlock(BlockRegistry.WIND_TUNNEL_CONTROLLER, "风洞控制器");
        addBlock(BlockRegistry.WOOD_CHARCOAL_BLOCK, "原木的木炭块");

        addBlock(BlockRegistry.LIGHTNING_POWERED_OAK_LOG, "雷劈的橡木原木");
        addBlock(BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG, "雷劈的云杉原木");
        addBlock(BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG, "雷劈的白桦原木");
        addBlock(BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG, "雷劈的丛林原木");
        addBlock(BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG, "雷劈的金合欢原木");
        addBlock(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG, "雷劈的暗黑橡木原木");

        addBlock(BlockRegistry.LIGHTNING_POWERED_OAK_PLANKS, "雷劈的橡木木板");
        addBlock(BlockRegistry.LIGHTNING_POWERED_SPRUCE_PLANKS, "雷劈的云杉木板");
        addBlock(BlockRegistry.LIGHTNING_POWERED_BIRCH_PLANKS, "雷劈的白桦木板");
        addBlock(BlockRegistry.LIGHTNING_POWERED_JUNGLE_PLANKS, "雷劈的丛林木板");
        addBlock(BlockRegistry.LIGHTNING_POWERED_ACACIA_PLANKS, "雷劈的金合欢木板");
        addBlock(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_PLANKS, "雷劈的暗黑橡木木板");

        addItem(ItemRegistry.LIGHTNING_POWERED_WOODEN_SWORD, "雷劈的木剑");
        addItem(ItemRegistry.LIGHTNING_POWERED_WOODEN_AXE, "雷劈的木斧");

        add(Util.makeDescriptionId("enchantment", Enchantments.LIGHTNING_POWERED.location()), "雷赋能");
    }
}