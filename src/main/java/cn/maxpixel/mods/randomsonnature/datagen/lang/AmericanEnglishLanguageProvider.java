package cn.maxpixel.mods.randomsonnature.datagen.lang;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.util.I18nUtil;
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
    }
}