package cn.maxpixel.mods.randomsonnature.client.renderer.entity.block;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.block.entity.WindTunnelControllerBlockEntity;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

import static net.minecraft.client.renderer.RenderStateShard.POSITION_COLOR_SHADER;

public class WindTunnelControllerBlockEntityRenderer implements BlockEntityRenderer<WindTunnelControllerBlockEntity> {
    public static final RenderType QUADS = RenderType.create(
            RandomsOnNatureMod.MODID + "_wind_tunnel_quads",
            DefaultVertexFormat.POSITION_COLOR,
            VertexFormat.Mode.QUADS,
            1536,
            false,
            true,
            RenderType.CompositeState.builder()
                    .setShaderState(POSITION_COLOR_SHADER)
                    .createCompositeState(false)
    );

    public WindTunnelControllerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(WindTunnelControllerBlockEntity be, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.scale(be.getRadius() + 1, be.getRadius() + 1, be.getRadius() + 1);
//        poseStack.rotateAround(Axis.YP.rotationDegrees(), );
//        VertexConsumer vc = bufferSource.getBuffer(QUADS);
//        vc.addVertex(poseStack.last(), 0, 0, 0).setColor(0xffffff);
        poseStack.popPose();
    }
}