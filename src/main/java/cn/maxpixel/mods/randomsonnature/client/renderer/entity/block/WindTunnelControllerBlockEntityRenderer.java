package cn.maxpixel.mods.randomsonnature.client.renderer.entity.block;

import cn.maxpixel.mods.randomsonnature.RandomsOnNatureMod;
import cn.maxpixel.mods.randomsonnature.block.entity.WindTunnelControllerBlockEntity;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.client.renderer.RenderStateShard.LIGHTMAP;
import static net.minecraft.client.renderer.RenderStateShard.POSITION_COLOR_LIGHTMAP_SHADER;

public class WindTunnelControllerBlockEntityRenderer implements BlockEntityRenderer<WindTunnelControllerBlockEntity> {
    private static final float UNIT = 1f / 16f;
    private static final int COLOR = 0x55;
    public static final RenderType QUADS = RenderType.create(
            RandomsOnNatureMod.MODID + "_wind_tunnel_quads",
            DefaultVertexFormat.POSITION_COLOR_LIGHTMAP,
            VertexFormat.Mode.QUADS,
            1536,
            true,
            false,
            RenderType.CompositeState.builder()
                    .setLightmapState(LIGHTMAP)
                    .setShaderState(POSITION_COLOR_LIGHTMAP_SHADER)
                    .createCompositeState(false)
    );

    public WindTunnelControllerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(WindTunnelControllerBlockEntity be, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.translate(.5f, 1.001f, .5f);
        poseStack.scale(be.getRadius() * 2 + .9f, 1, be.getRadius() * 2 + .9f);
        poseStack.rotateAround(Axis.YP.rotation(Mth.TWO_PI * (be.getLevel().getGameTime() % 5 + partialTick) / 5), 0.f, 0.f, 0.f);
        VertexConsumer vc = bufferSource.getBuffer(QUADS);
        vc.addVertex(poseStack.last(), -UNIT, 0f, -0.5f).setColor(COLOR, COLOR, COLOR, 0xff).setLight(packedLight);
        vc.addVertex(poseStack.last(), -UNIT, 0f, 0.5f).setColor(COLOR, COLOR, COLOR, 0xff).setLight(packedLight);
        vc.addVertex(poseStack.last(), UNIT, 0f, 0.5f).setColor(COLOR, COLOR, COLOR, 0xff).setLight(packedLight);
        vc.addVertex(poseStack.last(), UNIT, 0f, -0.5f).setColor(COLOR, COLOR, COLOR, 0xff).setLight(packedLight);
        vc.addVertex(poseStack.last(), -0.5f, 0f, -UNIT).setColor(COLOR, COLOR, COLOR, 0xff).setLight(packedLight);
        vc.addVertex(poseStack.last(), -0.5f, 0f, UNIT).setColor(COLOR, COLOR, COLOR, 0xff).setLight(packedLight);
        vc.addVertex(poseStack.last(), 0.5f, 0f, UNIT).setColor(COLOR, COLOR, COLOR, 0xff).setLight(packedLight);
        vc.addVertex(poseStack.last(), 0.5f, 0f, -UNIT).setColor(COLOR, COLOR, COLOR, 0xff).setLight(packedLight);
    }

    @Override
    public @NotNull AABB getRenderBoundingBox(WindTunnelControllerBlockEntity blockEntity) {
        return blockEntity.getArea() != null ? blockEntity.getArea() :
                BlockEntityRenderer.super.getRenderBoundingBox(blockEntity);
    }
}