package cn.maxpixel.mods.randomsonnature.registry;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.block.WindTunnelControllerBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RandomsOnNatureMod.MODID);

    public static final DeferredBlock<WindTunnelControllerBlock> WIND_TUNNEL_CONTROLLER = registerWithItem(WindTunnelControllerBlock.NAME, () ->
            new WindTunnelControllerBlock(BlockBehaviour.Properties.of()
                    .strength(2.f, 10.f)
            ));
    public static final DeferredBlock<Block> WOOD_CHARCOAL_BLOCK = registerWithItem("wood_charcoal_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
            ));
    public static final DeferredBlock<RotatedPillarBlock> LIGHTNING_POWERED_OAK_LOG = registerWithItem("lightning_powered_oak_log", () ->
            log(MapColor.WOOD, MapColor.PODZOL));
    public static final DeferredBlock<RotatedPillarBlock> LIGHTNING_POWERED_SPRUCE_LOG = registerWithItem("lightning_powered_spruce_log", () ->
            log(MapColor.PODZOL, MapColor.COLOR_BROWN));
    public static final DeferredBlock<RotatedPillarBlock> LIGHTNING_POWERED_BIRCH_LOG = registerWithItem("lightning_powered_birch_log", () ->
            log(MapColor.SAND, MapColor.QUARTZ));
    public static final DeferredBlock<RotatedPillarBlock> LIGHTNING_POWERED_JUNGLE_LOG = registerWithItem("lightning_powered_jungle_log", () ->
            log(MapColor.DIRT, MapColor.PODZOL));
    public static final DeferredBlock<RotatedPillarBlock> LIGHTNING_POWERED_ACACIA_LOG = registerWithItem("lightning_powered_acacia_log", () ->
            log(MapColor.COLOR_ORANGE, MapColor.STONE));
    public static final DeferredBlock<RotatedPillarBlock> LIGHTNING_POWERED_DARK_OAK_LOG = registerWithItem("lightning_powered_dark_oak_log", () ->
            log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final DeferredBlock<Block> LIGHTNING_POWERED_OAK_PLANKS = registerWithItem("lightning_powered_oak_planks",
            () -> planks(MapColor.WOOD));
    public static final DeferredBlock<Block> LIGHTNING_POWERED_SPRUCE_PLANKS = registerWithItem("lightning_powered_spruce_planks",
            () -> planks(MapColor.PODZOL));
    public static final DeferredBlock<Block> LIGHTNING_POWERED_BIRCH_PLANKS = registerWithItem("lightning_powered_birch_planks",
            () -> planks(MapColor.SAND));
    public static final DeferredBlock<Block> LIGHTNING_POWERED_JUNGLE_PLANKS = registerWithItem("lightning_powered_jungle_planks",
            () -> planks(MapColor.DIRT));
    public static final DeferredBlock<Block> LIGHTNING_POWERED_ACACIA_PLANKS = registerWithItem("lightning_powered_acacia_planks",
            () -> planks(MapColor.COLOR_ORANGE));
    public static final DeferredBlock<Block> LIGHTNING_POWERED_DARK_OAK_PLANKS = registerWithItem("lightning_powered_dark_oak_planks",
            () -> planks(MapColor.COLOR_BROWN));

    private static <T extends Block> DeferredBlock<T> registerWithItem(String name, Supplier<T> sup) {
        var block = BLOCKS.register(name, sup);
        ItemRegistry.registerBlockItem(name, block);
        return block;
    }

    private static RotatedPillarBlock log(MapColor topMapColor, MapColor sideMapColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of()
                .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
        );
    }

    private static Block planks(MapColor mapColor) {
        return new Block(
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
        );
    }
}