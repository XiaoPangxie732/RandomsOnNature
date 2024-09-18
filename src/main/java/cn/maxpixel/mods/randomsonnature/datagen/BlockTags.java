package cn.maxpixel.mods.randomsonnature.datagen;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.registry.TagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.*;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RandomsOnNatureMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(MINEABLE_WITH_PICKAXE).add(BlockRegistry.WOOD_CHARCOAL_BLOCK.get());
        tag(TagRegistry.LIGHTNING_POWERED_LOGS).add(
                BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_OAK_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG.get()
        );
        tag(MINEABLE_WITH_AXE).addTag(TagRegistry.LIGHTNING_POWERED_LOGS);
        tag(LOGS).addTag(TagRegistry.LIGHTNING_POWERED_LOGS);
    }
}