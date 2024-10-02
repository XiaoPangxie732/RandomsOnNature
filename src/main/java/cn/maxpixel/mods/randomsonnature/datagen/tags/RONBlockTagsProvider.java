package cn.maxpixel.mods.randomsonnature.datagen.tags;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.registry.tags.BlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.*;

public class RONBlockTagsProvider extends BlockTagsProvider {
    public RONBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RandomsOnNatureMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(MINEABLE_WITH_PICKAXE).add(BlockRegistry.WOOD_CHARCOAL_BLOCK.get());
        tag(BlockTags.LIGHTNING_POWERED_LOGS).add(
                BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_OAK_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG.get(),
                BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG.get()
        );
        tag(BlockTags.CAN_BE_LIGHTNING_POWERED_LOGS).add(
                Blocks.ACACIA_LOG,
                Blocks.OAK_LOG,
                Blocks.JUNGLE_LOG,
                Blocks.BIRCH_LOG,
                Blocks.SPRUCE_LOG,
                Blocks.DARK_OAK_LOG
        );
        tag(BlockTags.LIGHTNING_POWERED_PLANKS).add(
                BlockRegistry.LIGHTNING_POWERED_ACACIA_PLANKS.get(),
                BlockRegistry.LIGHTNING_POWERED_OAK_PLANKS.get(),
                BlockRegistry.LIGHTNING_POWERED_JUNGLE_PLANKS.get(),
                BlockRegistry.LIGHTNING_POWERED_BIRCH_PLANKS.get(),
                BlockRegistry.LIGHTNING_POWERED_SPRUCE_PLANKS.get(),
                BlockRegistry.LIGHTNING_POWERED_DARK_OAK_PLANKS.get()
        );
        tag(MINEABLE_WITH_AXE).addTag(BlockTags.LIGHTNING_POWERED_LOGS)
                .addTag(BlockTags.LIGHTNING_POWERED_PLANKS);
        tag(LOGS).addTag(BlockTags.LIGHTNING_POWERED_LOGS);
    }
}