package cn.maxpixel.mods.randomsonnature.datagen;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockStates extends BlockStateProvider {
    public BlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RandomsOnNatureMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(BlockRegistry.WIND_TUNNEL_CONTROLLER.get(), models()
                .withExistingParent(path(BlockRegistry.WIND_TUNNEL_CONTROLLER), mcLoc("block/gray_concrete")));
        simpleBlockWithItem(BlockRegistry.WOOD_CHARCOAL_BLOCK.get(), models()
                .withExistingParent(path(BlockRegistry.WOOD_CHARCOAL_BLOCK), mcLoc("block/coal_block")));
        logBlock(BlockRegistry.LIGHTNING_POWERED_OAK_LOG.get());
        logBlock(BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG.get());
        logBlock(BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG.get());
        logBlock(BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG.get());
        logBlock(BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG.get());
        logBlock(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG.get());
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_OAK_LOG.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_OAK_LOG));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG));
        simpleBlock(BlockRegistry.LIGHTNING_POWERED_OAK_PLANKS.get());
        simpleBlock(BlockRegistry.LIGHTNING_POWERED_SPRUCE_PLANKS.get());
        simpleBlock(BlockRegistry.LIGHTNING_POWERED_BIRCH_PLANKS.get());
        simpleBlock(BlockRegistry.LIGHTNING_POWERED_JUNGLE_PLANKS.get());
        simpleBlock(BlockRegistry.LIGHTNING_POWERED_ACACIA_PLANKS.get());
        simpleBlock(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_PLANKS.get());
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_OAK_PLANKS.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_OAK_PLANKS));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_SPRUCE_PLANKS.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_SPRUCE_PLANKS));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_BIRCH_PLANKS.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_BIRCH_PLANKS));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_JUNGLE_PLANKS.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_JUNGLE_PLANKS));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_ACACIA_PLANKS.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_ACACIA_PLANKS));
        simpleBlockItem(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_PLANKS.get(), getBlockModel(BlockRegistry.LIGHTNING_POWERED_DARK_OAK_PLANKS));
    }

    private static String path(DeferredHolder<?, ?> holder) {
        return holder.getId().getPath();
    }

    private ModelFile getBlockModel(DeferredBlock<?> block) {
        return models().getBuilder(path(block));
    }
}