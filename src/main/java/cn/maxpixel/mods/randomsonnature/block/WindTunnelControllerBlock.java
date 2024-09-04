package cn.maxpixel.mods.randomsonnature.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WindTunnelControllerBlock extends Block implements EntityBlock {
    public static final String NAME = "wind_tunnel_controller";

    public WindTunnelControllerBlock(Properties prop) {
        super(prop);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }
}