package cn.maxpixel.mods.randomsonnature.block.entity;

import cn.maxpixel.mods.randomsonnature.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class WindTunnelControllerBlockEntity extends BlockEntity {
    private int radius = 0;
    private AABB area;
    private List<ServerPlayer> oldPlayers = List.of();

    public WindTunnelControllerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.WIND_TUNNEL_CONTROLLER.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, WindTunnelControllerBlockEntity be) {
        if (level.getGameTime() % 20 == 0) {
            int old = be.radius;
            int radius = be.radius = structureCheck(level, pos);
            if (radius == 0) be.area = null;
            else if (old != radius) {
                be.area = new AABB(
                        pos.getX() - radius,
                        pos.getY(),
                        pos.getZ() - radius,
                        pos.getX() + radius + 1,
                        pos.getY() + 20,
                        pos.getZ() + radius + 1
                );
            }
        }
        if (be.area != null) {
//            var players = level.getEntitiesOfClass(ServerPlayer.class, be.area);
//            if (!be.oldPlayers.isEmpty()) {
//                be.oldPlayers.removeAll(players);
//                for (var player : be.oldPlayers) {
//                    player.setForcedPose(null);
//                }
//            }
//            be.oldPlayers = players;
//            for (var player : players) {
//                System.out.println(player.getPose());
//                boolean flying = !player.onGround();
//                if (flying) {
//                    player.setForcedPose(Pose.CROUCHING);
//                }
//                else {
//                    player.setForcedPose(null);
//                }
//                if (flying) {
//                }
//            }
        }
    }

    private static int structureCheck(Level level, BlockPos blockPos) {
        BlockPos.MutableBlockPos pos = blockPos.mutable();
        int radius = 0;
        outer: for (int r = 1; r <= 8; r++) {
            if (!level.getBlockState(pos.move(Direction.NORTH)).is(Blocks.GRAY_CONCRETE)) break;
            for (int i = 0; i < r; i++) {
                if (!level.getBlockState(pos.move(Direction.EAST)).is(Blocks.GRAY_CONCRETE)) break outer;
            }
            for (int i = 0; i < r; i++) {
                if (!level.getBlockState(pos.move(Direction.SOUTH)).is(Blocks.GRAY_CONCRETE)) break outer;
                if (!level.getBlockState(pos.move(Direction.SOUTH)).is(Blocks.GRAY_CONCRETE)) break outer;
            }
            for (int i = 0; i < r; i++) {
                if (!level.getBlockState(pos.move(Direction.WEST)).is(Blocks.GRAY_CONCRETE)) break outer;
                if (!level.getBlockState(pos.move(Direction.WEST)).is(Blocks.GRAY_CONCRETE)) break outer;
            }
            for (int i = 0; i < r; i++) {
                if (!level.getBlockState(pos.move(Direction.NORTH)).is(Blocks.GRAY_CONCRETE)) break outer;
                if (!level.getBlockState(pos.move(Direction.NORTH)).is(Blocks.GRAY_CONCRETE)) break outer;
            }
            for (int i = 1; i < r; i++) {
                if (!level.getBlockState(pos.move(Direction.EAST)).is(Blocks.GRAY_CONCRETE)) break outer;
            }
            pos.move(Direction.EAST);
            radius = r;
        }
        return radius;
    }

    public int getRadius() {
        return radius;
    }
}