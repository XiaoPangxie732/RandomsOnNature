package cn.maxpixel.mods.randomsonnature.block.entity;

import cn.maxpixel.mods.randomsonnature.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WindTunnelControllerBlockEntity extends BlockEntity {
    public WindTunnelControllerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.WIND_TUNNEL_CONTROLLER.get(), pos, state);
    }
}