package cn.maxpixel.mods.randomsonnature.datagen;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = RandomsOnNatureMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EntryPoint {
    @SubscribeEvent
    public static void onGatheringData(GatherDataEvent event) {
    }
}