package cn.maxpixel.mods.randomsonnature.listener;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.datagen.Enchantments;
import cn.maxpixel.mods.randomsonnature.registry.BlockRegistry;
import cn.maxpixel.mods.randomsonnature.registry.tags.BlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.VanillaGameEvent;
import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Map;

@EventBusSubscriber(modid = RandomsOnNatureMod.MODID)
public class LightningStrikeHandler {
    private static final Map<Block, DeferredBlock<RotatedPillarBlock>> REPLACEMENTS = Map.of(
            Blocks.ACACIA_LOG, BlockRegistry.LIGHTNING_POWERED_ACACIA_LOG,
            Blocks.OAK_LOG, BlockRegistry.LIGHTNING_POWERED_OAK_LOG,
            Blocks.JUNGLE_LOG, BlockRegistry.LIGHTNING_POWERED_JUNGLE_LOG,
            Blocks.BIRCH_LOG, BlockRegistry.LIGHTNING_POWERED_BIRCH_LOG,
            Blocks.SPRUCE_LOG, BlockRegistry.LIGHTNING_POWERED_SPRUCE_LOG,
            Blocks.DARK_OAK_LOG, BlockRegistry.LIGHTNING_POWERED_DARK_OAK_LOG
    );

    @SubscribeEvent
    public static void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
        if (event.getEntity() instanceof ItemEntity entity) {
            if (entity.getRandom().nextInt(5) == 0) {
                var ench = entity.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT)
                        .getOrThrow(Enchantments.LIGHTNING_POWERED);
                ItemStack is = entity.getItem();
                if (is.supportsEnchantment(ench)) {
                    entity.setInvulnerable(true);
                    int lvl = is.getEnchantmentLevel(ench);
                    if (lvl < 5) {
                        is.enchant(ench, lvl + 1);
                    }
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onVanillaGameEvent(VanillaGameEvent event) {
        if (event.getVanillaEvent() == GameEvent.LIGHTNING_STRIKE) {
            var lightningPos = event.getEventPosition();
            Level level = event.getLevel();
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(lightningPos.x, lightningPos.y, lightningPos.z);
            for (int i = 0; i <= 3; i++) {
                if (level.getBlockState(pos.move(Direction.DOWN)).is(BlockTags.CAN_BE_LIGHTNING_POWERED_LOGS)) {
                    spreadStrike(level, pos, event.getCause().getRandom());
                    break;
                }
            }
        }
    }

    private static void spreadStrike(Level level, BlockPos.MutableBlockPos lightningPos, RandomSource random) {
        for (var pos : BlockPos.betweenClosed(
                lightningPos.getX() - 1,
                Mth.clamp(lightningPos.getY() - 10, level.getMinBuildHeight(), level.getMaxBuildHeight()),
                lightningPos.getZ() - 1,
                lightningPos.getX() + 1,
                lightningPos.getY(),
                lightningPos.getZ() + 1
        )) {
            BlockState state = level.getBlockState(pos);
            if (state.is(BlockTags.CAN_BE_LIGHTNING_POWERED_LOGS)) {
                var replacement = REPLACEMENTS.get(state.getBlock());
                if (replacement != null) {
                    if (random.nextInt(3) == 0) { // 1 / 3
                        level.setBlockAndUpdate(pos, replacement.get().defaultBlockState()
                                .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)));
                    } else {
                        level.setBlockAndUpdate(pos, BlockRegistry.WOOD_CHARCOAL_BLOCK.get().defaultBlockState());
                    }
                }
            }
        }
    }
}