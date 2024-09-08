package cn.maxpixel.mods.randomsonnature.client;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.client.renderer.entity.block.WindTunnelControllerBlockEntityRenderer;
import cn.maxpixel.mods.randomsonnature.registry.BlockEntityRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = RandomsOnNatureMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientRegistries {
    @SubscribeEvent
    public static void onEntityRenderersRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityRegistry.WIND_TUNNEL_CONTROLLER.get(), WindTunnelControllerBlockEntityRenderer::new);
    }
}
