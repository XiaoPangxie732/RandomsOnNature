package cn.maxpixel.mods.randomsonnature;

import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.registry.ItemRegistry;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(RandomsOnNatureMod.MODID)
public class RandomsOnNatureMod {
    public static final String MODID = "randomsonnature";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.randomsonnature")) //The language key for the title of your CreativeModeTab
            .icon(() -> BlockRegistry.WIND_TUNNEL_CONTROLLER.asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(BlockRegistry.WIND_TUNNEL_CONTROLLER.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public RandomsOnNatureMod(IEventBus modEventBus, ModContainer modContainer) {
        BlockRegistry.register(modEventBus);
        ItemRegistry.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}