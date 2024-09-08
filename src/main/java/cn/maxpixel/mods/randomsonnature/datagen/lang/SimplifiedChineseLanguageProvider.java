package cn.maxpixel.mods.randomsonnature.datagen.lang;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.util.I18nUtil;
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
    }
}