package cn.maxpixel.mods.randomsonnature.datagen;

import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import com.google.common.collect.Iterables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;

public class BlockLoot extends BlockLootSubProvider {
    protected BlockLoot(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, pRegistries);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Iterables.transform(BlockRegistry.BLOCKS.getEntries(), DeferredHolder::value);
    }

    @Override
    protected void generate() {
        dropSelf(BlockRegistry.WIND_TUNNEL_CONTROLLER.get());
        dropOther(BlockRegistry.WOOD_CHARCOAL_BLOCK.get(), Items.CHARCOAL);
    }
}