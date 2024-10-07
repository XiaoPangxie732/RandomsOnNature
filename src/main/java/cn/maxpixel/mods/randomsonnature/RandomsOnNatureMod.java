package cn.maxpixel.mods.randomsonnature;

import cn.maxpixel.mods.randomsonnature.registry.BlockEntityRegistry;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.registry.ItemRegistry;
import cn.maxpixel.mods.randomsonnature.util.I18nUtil;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(RandomsOnNatureMod.MODID)
public class RandomsOnNatureMod {
    public static final String MODID = "randomsonnature";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final String MAIN_TAB_NAME = "main";
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register(MAIN_TAB_NAME, () -> CreativeModeTab.builder()
            .title(Component.translatable(I18nUtil.makeItemGroup(MAIN_TAB_NAME))) //The language key for the title of your CreativeModeTab
            .icon(() -> BlockRegistry.WIND_TUNNEL_CONTROLLER.asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(BlockRegistry.WIND_TUNNEL_CONTROLLER); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(BlockRegistry.WOOD_CHARCOAL_BLOCK);
                output.accept(BlockRegistry.LIGHTNING_POWERED_OAK_LOG);
                output.accept(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG);
                output.accept(BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG);
                output.accept(BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG);
                output.accept(BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG);
                output.accept(BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG);
                output.accept(BlockRegistry.LIGHTNING_POWERED_OAK_PLANKS);
                output.accept(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_PLANKS);
                output.accept(BlockRegistry.LIGHTNING_POWERED_SPRUCE_PLANKS);
                output.accept(BlockRegistry.LIGHTNING_POWERED_JUNGLE_PLANKS);
                output.accept(BlockRegistry.LIGHTNING_POWERED_BIRCH_PLANKS);
                output.accept(BlockRegistry.LIGHTNING_POWERED_ACACIA_PLANKS);
                output.accept(ItemRegistry.LIGHTNING_POWERED_WOODEN_AXE);
                output.accept(ItemRegistry.LIGHTNING_POWERED_WOODEN_SWORD);
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public RandomsOnNatureMod(IEventBus modEventBus, ModContainer modContainer) {
        BlockRegistry.BLOCKS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}