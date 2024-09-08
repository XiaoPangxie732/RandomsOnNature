package cn.maxpixel.mods.randomsonnature.datagen;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {
    public BlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RandomsOnNatureMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(BlockRegistry.WIND_TUNNEL_CONTROLLER.get(), models()
                .withExistingParent(BlockRegistry.WIND_TUNNEL_CONTROLLER.getId().getPath(),
                        mcLoc("block/gray_concrete")));
    }
}