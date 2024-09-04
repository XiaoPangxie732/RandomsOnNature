package cn.maxpixel.mods.randomsonnature.registry;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.block.WindTunnelControllerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {
    static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RandomsOnNatureMod.MODID);

    public static final DeferredBlock<WindTunnelControllerBlock> WIND_TUNNEL_CONTROLLER = registerWithItem(WindTunnelControllerBlock.NAME, () ->
            new WindTunnelControllerBlock(BlockBehaviour.Properties.of()
                    .strength(2.f, 10.f)
            ));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    private static <T extends Block> DeferredBlock<T> registerWithItem(String name, Supplier<T> sup) {
        var block = BLOCKS.register(name, sup);
        ItemRegistry.registerBlockItem(name, block);
        return block;
    }
}