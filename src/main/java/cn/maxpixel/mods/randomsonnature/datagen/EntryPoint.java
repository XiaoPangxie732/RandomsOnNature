package cn.maxpixel.mods.randomsonnature.datagen;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.datagen.lang.AmericanEnglishLanguageProvider;
import cn.maxpixel.mods.randomsonnature.datagen.lang.SimplifiedChineseLanguageProvider;
import cn.maxpixel.mods.randomsonnature.datagen.tags.RONBlockTagsProvider;
import cn.maxpixel.mods.randomsonnature.datagen.tags.RONItemTagsProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = RandomsOnNatureMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EntryPoint {
    @SubscribeEvent
    public static void onGatheringData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var efh = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();

        // Languages
        generator.addProvider(event.includeClient(), (DataProvider.Factory<SimplifiedChineseLanguageProvider>) SimplifiedChineseLanguageProvider::new);
        generator.addProvider(event.includeClient(), (DataProvider.Factory<AmericanEnglishLanguageProvider>) AmericanEnglishLanguageProvider::new);

        generator.addProvider(event.includeClient(), new BlockStates(output, efh));
        generator.addProvider(event.includeClient(), new ItemModels(output, efh));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLoot::new, LootContextParamSets.BLOCK)
        ), lookup));
        var blockTags = generator.addProvider(event.includeServer(), new RONBlockTagsProvider(output, lookup, efh));
        generator.addProvider(event.includeServer(), new RONItemTagsProvider(output, lookup, blockTags.contentsGetter(), efh));
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, lookup,
                new RegistrySetBuilder()
                        .add(Registries.ENCHANTMENT, Enchantments::addEnchantments),
                Set.of(RandomsOnNatureMod.MODID)
        ));
    }
}