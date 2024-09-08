package cn.maxpixel.mods.randomsonnature.client.renderer.entity.block;

import cn.maxpixel.mods.randomsonnature.block.entity.WindTunnelControllerBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class WindTunnelControllerBlockEntityRenderer implements BlockEntityRenderer<WindTunnelControllerBlockEntity> {
    public WindTunnelControllerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(WindTunnelControllerBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

    }
}