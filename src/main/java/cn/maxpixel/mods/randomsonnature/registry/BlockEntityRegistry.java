package cn.maxpixel.mods.randomsonnature.registry;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.block.WindTunnelControllerBlock;
import cn.maxpixel.mods.randomsonnature.block.entity.WindTunnelControllerBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntityRegistry {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, RandomsOnNatureMod.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WindTunnelControllerBlockEntity>> WIND_TUNNEL_CONTROLLER = BLOCK_ENTITIES
            .register(WindTunnelControllerBlock.NAME, () -> BlockEntityType.Builder.of(WindTunnelControllerBlockEntity::new,
                    BlockRegistry.WIND_TUNNEL_CONTROLLER.get()).build(null));
}