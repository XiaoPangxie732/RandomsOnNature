package cn.maxpixel.mods.randomsonnature.util;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;

public class I18nUtil {
    public static String make(String category, String path) {
        return category + '.' + RandomsOnNatureMod.MODID + '.' + path;
    }

    public static String makeItemGroup(String name) {
        return make("itemGroup", name);
    }

    public static String makeScreenText(String screen, String name) {
        return make("screen", screen + '.' + name);
    }
}