package cn.maxpixel.mods.randomsonnature.block.entity;

import cn.maxpixel.mods.randomsonnature.annotations.UsedOn;
import cn.maxpixel.mods.randomsonnature.registry.BlockEntityRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WindTunnelControllerBlockEntity extends BlockEntity {
    public static final String KEY_RADIUS = "radius";
    public static final int MAX_RADIUS = 8;
    public static final int HEIGHT = 20;
    private int radius = 0;
    private AABB area;
    @UsedOn(UsedOn.Side.SERVER)
    private List<ServerPlayer> oldPlayers = List.of();
    @UsedOn(UsedOn.Side.CLIENT)
    private boolean lastTickHere;

    public WindTunnelControllerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.WIND_TUNNEL_CONTROLLER.get(), pos, state);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        CompoundTag tag = new CompoundTag();
        tag.putInt(KEY_RADIUS, radius);
        return tag;
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        int old = radius;
        radius = Mth.clamp(tag.getInt(KEY_RADIUS), 0, MAX_RADIUS);
        if (radius == 0) area = null;
        else if (old != radius) {
            area = new AABB(
                    worldPosition.getX() - radius,
                    worldPosition.getY(),
                    worldPosition.getZ() - radius,
                    worldPosition.getX() + radius + 1,
                    worldPosition.getY() + HEIGHT,
                    worldPosition.getZ() + radius + 1
            );
        }
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider lookupProvider) {
        CompoundTag tag = pkt.getTag();
        if (!tag.isEmpty()) handleUpdateTag(tag, lookupProvider);
    }

    private static boolean canBeBlown(Player p) {
        return !p.onGround() && !(p.isCreative() && p.getAbilities().flying);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, WindTunnelControllerBlockEntity be) {
        if (level.getGameTime() % 20 == 0) {
            int old = be.radius;
            int radius = be.radius = structureCheck(level, pos);
            if (radius == 0) {
                be.area = null;
                level.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
            } else if (old != radius) {
                be.area = new AABB(
                        pos.getX() - radius,
                        pos.getY(),
                        pos.getZ() - radius,
                        pos.getX() + radius + 1,
                        pos.getY() + 20,
                        pos.getZ() + radius + 1
                );
                level.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
            }
        }
        if (be.area != null) {
            var players = level.getEntitiesOfClass(ServerPlayer.class, be.area);
            if (!be.oldPlayers.isEmpty()) {
                be.oldPlayers.removeAll(players);
                for (var player : be.oldPlayers) {
                    player.setForcedPose(null);
                }
            }
            be.oldPlayers = players;
            for (var player : players) {
                boolean flying = canBeBlown(player);
                if (flying) player.setForcedPose(Pose.FALL_FLYING);
                else player.setForcedPose(null);
                if (flying) applyMotionToPlayer(be, player);
            }
            applyMotionToItems(be, level.getEntitiesOfClass(ItemEntity.class, be.area));
            for (Entity entity : level.getEntitiesOfClass(Entity.class, be.area, EntitySelector.NO_SPECTATORS
                    .and(EntitySelector.ENTITY_STILL_ALIVE)
                    .and(e -> (e instanceof LivingEntity) && !(e instanceof Player))
            )) {
                entity.addDeltaMovement(new Vec3(
                        0.0,
                        entity.getGravity() * 1.3 * Mth.lerp((be.area.maxY - entity.getY()) / HEIGHT, 0.3, 1.0)
                                + Math.random() * 0.05,
                        0.0
                ));
            }
        }
    }

    @UsedOn(UsedOn.Side.CLIENT)
    private static class ClientOnly {
        public static void clientTick(Level level, WindTunnelControllerBlockEntity be) {
            if (be.area != null) {
                var player = Minecraft.getInstance().player;
                if (player.getBoundingBox().intersects(be.area)) {
                    boolean flying = canBeBlown(player);
                    if (flying) player.setForcedPose(Pose.FALL_FLYING);
                    else player.setForcedPose(null);
                    be.lastTickHere = true;
                    if (flying) applyMotionToPlayer(be, player);
                } else if (be.lastTickHere) {
                    player.setForcedPose(null);
                    be.lastTickHere = false;
                }
                applyMotionToItems(be, level.getEntitiesOfClass(ItemEntity.class, be.area));
            }
        }
    }

    @UsedOn(UsedOn.Side.CLIENT)
    public static void clientTick(Level level, BlockPos pos, BlockState state, WindTunnelControllerBlockEntity be) {
        ClientOnly.clientTick(level, be);
    }

    private static void applyMotionToPlayer(WindTunnelControllerBlockEntity be, Player player) {
        player.resetFallDistance();
        Vec3 delta = player.getDeltaMovement();
        double strength = Mth.lerp((be.area.maxY - player.getY()) / HEIGHT, 0.3, 1.0);
        player.setDeltaMovement(
                Mth.clamp(delta.x * 1.4 * strength, -.2, .2),
                delta.y + player.getGravity() * 2 * strength * Mth.lerp(Math.abs(player.getXRot()) / 90., 1.0, 0.4),
                Mth.clamp(delta.z * 1.4 * strength, -.2, .2)
        );
    }

    private static void applyMotionToItems(WindTunnelControllerBlockEntity be, List<ItemEntity> items) {
        for (ItemEntity item : items) {
            item.addDeltaMovement(new Vec3(
                    0.0,
                    item.getGravity() * 1.5 * Mth.lerp((be.area.maxY - item.getY()) / HEIGHT, 0.3, 1.0),
                    0.0
            ));
        }
    }

    private static int structureCheck(Level level, BlockPos blockPos) {
        BlockPos.MutableBlockPos pos = blockPos.mutable();
        int radius = 0;
        outer: for (int r = 1; r <= MAX_RADIUS; r++) {
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