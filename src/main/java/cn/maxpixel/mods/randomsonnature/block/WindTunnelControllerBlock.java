package cn.maxpixel.mods.randomsonnature.block;

import cn.maxpixel.mods.randomsonnature.block.entity.WindTunnelControllerBlockEntity;
import cn.maxpixel.mods.randomsonnature.registry.BlockEntityRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WindTunnelControllerBlock extends BaseEntityBlock {
    public static final String NAME = "wind_tunnel_controller";
    public static final MapCodec<WindTunnelControllerBlock> CODEC = simpleCodec(WindTunnelControllerBlock::new);

    public WindTunnelControllerBlock(Properties prop) {
        super(prop);
    }

    @Override
    protected MapCodec<WindTunnelControllerBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WindTunnelControllerBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState pState, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.WIND_TUNNEL_CONTROLLER.get(), WindTunnelControllerBlockEntity::serverTick);
    }
}