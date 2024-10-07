package cn.maxpixel.mods.randomsonnature.datagen.tags;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.registry.tags.BlockTags;
import cn.maxpixel.mods.randomsonnature.registry.tags.ItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.ItemTags.LOGS;
import static net.minecraft.tags.ItemTags.PLANKS;

public class RONItemTagsProvider extends ItemTagsProvider {
    public RONItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, provider, pBlockTags, RandomsOnNatureMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        copy(BlockTags.CAN_BE_LIGHTNING_POWERED_LOGS, ItemTags.CAN_BE_LIGHTNING_POWERED_LOGS);
        copy(BlockTags.LIGHTNING_POWERED_LOGS, ItemTags.LIGHTNING_POWERED_LOGS);
        copy(BlockTags.LIGHTNING_POWERED_PLANKS, ItemTags.LIGHTNING_POWERED_PLANKS);
        tag(LOGS).addTag(ItemTags.LIGHTNING_POWERED_LOGS);
        tag(PLANKS).addTag(ItemTags.LIGHTNING_POWERED_PLANKS);
        tag(ItemTags.CAN_BE_LIGHTNING_POWERED_WEAPONS).add(
                Items.DIAMOND_SWORD,
                Items.STONE_SWORD,
                Items.GOLDEN_SWORD,
                Items.NETHERITE_SWORD,
                Items.IRON_SWORD,
                Items.DIAMOND_AXE,
                Items.STONE_AXE,
                Items.GOLDEN_AXE,
                Items.NETHERITE_AXE,
                Items.IRON_AXE,
                Items.MACE,
                Items.TRIDENT
        );
    }
}