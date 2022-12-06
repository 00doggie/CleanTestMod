package testmod.client.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import testmod.TestMod;
import testmod.client.entity.models.PterodactylModel;
import testmod.common.entity.Pterodactyl;

public class PterodactylRenderer extends GeoEntityRenderer<Pterodactyl> {
    public PterodactylRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PterodactylModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(Pterodactyl instance) {
        return new ResourceLocation(TestMod.MOD_ID, "textures/entity/pterodactyl/pterodactyl.png");
    }

    @Override
    public RenderType getRenderType(Pterodactyl animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0F, 1.0F, 1.0F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
